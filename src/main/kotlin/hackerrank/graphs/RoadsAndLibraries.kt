package hackerrank.graphs

import java.util.*
import kotlin.math.min

/**
 * isolated subgraphs가 아니라고 가정하고 간단하게 구현
 *  - ✓ 일반적으로 좀 더 빠른 BFS로 구현을 시작
 *  - ✓ 길을 연결 안하는 방법과 비교
 *
 * isolated subgraphs 고려
 *  - ✓ 다른 집합도 있음을 고려 (빈 탐색이 없도록 하자)
 *  - ✓ A 그룹은 연결을, B 그룹은 모든 도시에 도서관 설립. 이런 식으로 각 그룹별로 최적의 조합을 고려하기
 */
fun roadsAndLibraries(
    n: Int,
    c_lib: Int,
    c_road: Int,
    cities: Array<Array<Int>>
): Long {

    val nodes = buildCityNodes(n, cities)
    val visited = Array(n) { false }
    var totalCost = 0L

    nodes.forEach { node ->
        if (!visited[node.value - 1]) {
            val distance = bfs(node, visited)

            totalCost += calculateMinCost(
                distance + 1,
                c_lib,
                distance,
                c_road
            )
        }
    }

    return totalCost
}

private fun buildCityNodes(count: Int, cities: Array<Array<Int>>): List<CityNode> {
    val nodes = (1..count).map { CityNode(it) }

    cities.forEach { link ->
        val from = nodes[link[0] - 1]
        val to = nodes[link[1] - 1]

        from.addNeighbor(to)
        to.addNeighbor(from)
    }

    return nodes
}

private fun bfs(root: CityNode, visited: Array<Boolean>): Int {

    var distance = 0
    val queue = ArrayDeque<CityNode>()
    queue.addLast(root)

    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        visited[node.value - 1] = true

        node.neighbors.forEach { neighbor ->
            if (!visited[neighbor.value - 1]) {

                distance++
                visited[neighbor.value - 1] = true
                queue.addLast(neighbor)

            }
        }
    }

    return distance
}

private fun calculateMinCost(
    cityCount: Int,
    c_lib: Int,
    distance: Int,
    c_road: Int
): Int {

    val librariesCost = cityCount * c_lib
    val roadsCost = distance * c_road + c_lib

    return min(
        librariesCost,
        roadsCost
    )

}

data class CityNode(val value: Int) {

    val neighbors: MutableSet<CityNode> = mutableSetOf()

    fun addNeighbor(neighbor: CityNode) = neighbors.add(neighbor)

}

package hackerrank.graphs

import java.util.*

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
    var totalCost = 0L

    0.until(n).forEach { i ->
        if (!nodes[i].visited) {
            val distance = bfs(nodes[i])

            totalCost += if (c_road < c_lib) distance * c_road + c_lib
            else (distance + 1) * c_lib
        }
    }

    return totalCost
}

private fun buildCityNodes(count: Int, cities: Array<Array<Int>>): Array<CityNode> {
    val nodes = Array(count) { CityNode() }

    cities.forEach { link ->
        val from = nodes[link[0] - 1]
        val to = nodes[link[1] - 1]

        from.addNeighbor(to)
        to.addNeighbor(from)
    }

    return nodes
}

private fun bfs(root: CityNode): Int {

    var distance = 0
    val queue = ArrayDeque<CityNode>()
    queue.addLast(root)

    while (queue.isNotEmpty()) {

        val node = queue.removeFirst()
        node.visited = true
        node.neighbors.forEach {

            if (!it.visited) {
                distance++
                it.visited = true
                queue.addLast(it)
            }
        }
    }

    return distance
}

class CityNode {

    var visited = false
    val neighbors: MutableSet<CityNode> = mutableSetOf()
    fun addNeighbor(neighbor: CityNode) = neighbors.add(neighbor)

}
package hackerrank.graphs

import java.util.*
import kotlin.math.min

/**
 * TODO isolated subgraphs가 아니라고 가정하고 간단하게 구현
 *  - ✓ 일반적으로 좀 더 빠른 BFS로 구현을 시작
 *  - ✓ 길을 연결 안하는 방법과 비교
 *
 * TODO isolated subgraphs 고려
 *  - [] 다른 집합도 있음을 고려 (빈 탐색이 없도록 하자)
 *  - [] A 그룹은 연결을, B 그룹은 모든 도시에 도서관 설립. 이런 식으로 각 그룹별로 최적의 조합을 고려하기
 */
fun roadsAndLibraries(
    n: Int,
    c_lib: Int,
    c_road: Int,
    cities: Array<Array<Int>>
): Long {

    val nodes = buildCityNodes(cities)
    val distance = bfs(nodes.first())

    return calculateMinCost(
        nodes.size,
        c_lib,
        distance,
        c_road
    )

}

private fun buildCityNodes(cities: Array<Array<Int>>): MutableCollection<CityNode> {
    val nodes = mutableMapOf<Int, CityNode>()

    cities.forEach { link ->
        val from = link[0]
        val to = link.last()

        nodes.putIfAbsent(
            from,
            CityNode(from)
        )

        nodes.putIfAbsent(
            to,
            CityNode(to)
        )

        nodes
            .getValue(from)
            .neighbors
            .add(nodes.getValue(to))

        nodes
            .getValue(to)
            .neighbors
            .add(nodes.getValue(from))
    }

    return nodes.values
}

private fun bfs(root: CityNode): Int {

    var distance = 0
    val queue = ArrayDeque<CityNode>()
    queue.addLast(root)

    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        node.visited = true

        node.neighbors.forEach { neighbor ->
            if (!neighbor.visited) {
                distance++
                neighbor.visited = true
                queue.addLast(neighbor)
            }
        }
    }

    return distance
}

private fun calculateMinCost(
    nodeSize: Int,
    c_lib: Int,
    distance: Int,
    c_road: Int
) = min(
    nodeSize * c_lib.toLong(),
    distance * c_road + c_lib.toLong()
)

data class CityNode(val value: Int) {

    var visited = false
    val neighbors: MutableSet<CityNode> = mutableSetOf()

    override fun toString() = "CityNode(" +
            "value=$value, " +
            "neighbors=${neighbors.map { it.value }}" +
            ")"

}
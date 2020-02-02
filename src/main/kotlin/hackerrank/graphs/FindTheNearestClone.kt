package hackerrank.graphs

import java.util.*

fun findShortest(
    graphNodes: Int,     // an integer, the number of nodes
    graphFrom: IntArray, // an array of integers, the start nodes for each edge
    graphTo: IntArray,   // an array of integers, the end nodes for each edge
    ids: LongArray,      // an array of integers, the color id per node
    `val`: Int           // an integer, the id of the color to match
): Int {

    val nodes = generateNodes(ids, graphFrom, graphTo)
    return findShortestColorMatchingDistance(nodes[`val` - 1])
}

private fun generateNodes(
    ids: LongArray,
    graphFrom: IntArray,
    graphTo: IntArray
): Array<CNode> {
    val nodes: Array<CNode> = ids
        .mapIndexed { index, color -> CNode(index + 1, color) }
        .toTypedArray()

    graphFrom.indices.forEach {
        val from = nodes[graphFrom[it] - 1]
        val to = nodes[graphTo[it] - 1]
        from.addNeighbor(to)
    }

    return nodes
}

private fun findShortestColorMatchingDistance(start: CNode): Int {
    val queue: Queue<CNode> = ArrayDeque<CNode>()
    queue.offer(start)
    start.distance = 0

    while (queue.isNotEmpty()) {
        val polled = queue.poll()

        polled.neighbors.forEach { n ->
            if (n.isNotVisited()) {
                n.distance = polled.distance + 1
                if (start.matchColor(n)) return n.distance
                queue.offer(n)
            }
        }
    }

    return -1
}

internal data class CNode(
    val value: Int,
    val color: Long,
    var distance: Int = initialDistance,
    val neighbors: MutableSet<CNode> = mutableSetOf()
) {

    companion object {
        const val initialDistance = -1
    }

    fun addNeighbor(node: CNode) {
        this.neighbors.add(node)
        node.neighbors.add(this)
    }

    fun isNotVisited() = distance == initialDistance

    fun matchColor(compare: CNode) = color == compare.color

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as CNode
        return value == other.value
    }

    override fun hashCode(): Int {
        return value
    }

    override fun toString(): String {
        return "CNode(value=$value, color=$color, distance=$distance)"
    }

}
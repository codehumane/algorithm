package hackerrank.graphs

import java.util.*

fun main(args: Array<String>) {

    val scan = Scanner(System.`in`)
    val q = scan.nextInt() // queries

    val graphs = Array(q + 1) {
        Graph(Node(1), emptyArray())
    }

    (0 until q).forEach { qIndex ->
        val n = scan.nextInt() // number of nodes
        val m = scan.nextInt() // number of edges
        val nodes = Array(n) { Node(it + 1) }

        (0 until m).forEach { _ ->
            val u = scan.nextInt() // edge from
            val v = scan.nextInt() // edge to
            nodes[u - 1].addNeighbor(nodes[v - 1])
        }

        val s = scan.nextInt() // start node value
        graphs[qIndex] = Graph(
            nodes[s - 1],
            nodes
        )
    }

    graphs
        .map { g -> g.shortestReach() }
        .forEach { d -> println(d.joinToString(" ")) }

    scan.close()
}

internal class Graph(private val start: Node, private val nodes: Array<Node>) {

    fun shortestReach(): IntArray {

        start.distance = 0
        val queue = ArrayDeque<Node>()
        queue.add(start)

        while (queue.isNotEmpty()) {
            val from = queue.remove()
            from.neighbors.forEach { to ->
                if (to.isNotVisited()) {
                    to.distance = from.distance + 1
                    queue.add(to)
                }
            }
        }

        return nodes
            .filterNot { it.value == start.value }
            .map { it.getWeightedDistance() }
            .toIntArray()
    }

}

internal class Node(val value: Int) {

    private val weight = 6
    private val notVisitedDistance = -1
    var distance = notVisitedDistance
    val neighbors = mutableSetOf<Node>()

    // undirected
    fun addNeighbor(node: Node) {
        this.neighbors.add(node)
        node.neighbors.add(this)
    }

    fun isNotVisited() = distance == notVisitedDistance

    fun getWeightedDistance() = if (isNotVisited()) notVisitedDistance else weight * distance

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Node
        return value == other.value
    }

    override fun hashCode(): Int {
        return value
    }

}

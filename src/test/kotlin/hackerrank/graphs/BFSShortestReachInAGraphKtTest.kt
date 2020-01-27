package hackerrank.graphs

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class BFSShortestReachInAGraphKtTest {

    @Test
    fun `getDistances sample 1`() {

        // given
        val node1 = Node(1)
        val node2 = Node(2)
        val node3 = Node(3)
        val node4 = Node(4)

        // and
        node1.addNeighbor(node2)
        node1.addNeighbor(node3)

        // and
        val graph = Graph(
            node1,
            arrayOf(
                node1,
                node2,
                node3,
                node4
            )
        )

        // when
        val distance = graph.shortestReach()

        // then
        assertArrayEquals(intArrayOf(6, 6, -1), distance)
    }

    @Test
    fun `getDistances sample 2`() {

        // given
        val node1 = Node(1)
        val node2 = Node(2)
        val node3 = Node(3)

        // and
        node2.addNeighbor(node3)

        // and
        val graph = Graph(
            node2,
            arrayOf(
                node1,
                node2,
                node3
            )
        )

        // when
        val distance = graph.shortestReach()

        // then
        assertArrayEquals(intArrayOf(-1, 6), distance)
    }

    @Test
    fun `getDistances sample 3`() {

        // given
        val node1 = Node(1)
        val node2 = Node(2)
        val node3 = Node(3)
        val node4 = Node(4)
        val node5 = Node(5)
        val node6 = Node(6)

        // and
        node1.addNeighbor(node2)
        node1.addNeighbor(node5)
        node2.addNeighbor(node3)
        node3.addNeighbor(node4)

        // and
        val graph = Graph(
            node1,
            arrayOf(
                node1,
                node2,
                node3,
                node4,
                node5,
                node6
            )
        )

        // when
        val distance = graph.shortestReach()

        // then
        assertArrayEquals(intArrayOf(6, 12, 18, 6, -1), distance)
    }

    @Test
    fun `getDistances sample 4`() {

        // given
        val node1 = Node(1)
        val node2 = Node(2)
        val node3 = Node(3)
        val node4 = Node(4)
        val node5 = Node(5)
        val node6 = Node(6)
        val node7 = Node(7)

        // and
        node1.addNeighbor(node2)
        node1.addNeighbor(node3)
        node3.addNeighbor(node4)
        node2.addNeighbor(node5)

        // and
        val graph = Graph(
            node2,
            arrayOf(
                node1,
                node2,
                node3,
                node4,
                node5,
                node6,
                node7
            )
        )

        // when
        val distance = graph.shortestReach()

        // then
        assertArrayEquals(intArrayOf(6, 12, 18, 6, -1, -1), distance)
    }

    @Test
    fun `getDistances undirected 임에 유의한다`() {

        // given
        val node1 = Node(1)
        val node2 = Node(2)
        val node3 = Node(3)
        val node4 = Node(4)

        // and
        node1.addNeighbor(node2)
        node2.addNeighbor(node1)
        node1.addNeighbor(node3)

        // and
        val graph = Graph(
            node1,
            arrayOf(
                node1,
                node2,
                node3,
                node4
            )
        )

        // when
        val distance = graph.shortestReach()

        // then
        assertArrayEquals(intArrayOf(6, 6, -1), distance)
    }

}

package basic.tree

import basic.tree.MinHeap.Companion.ROOT_INDEX
import org.junit.Assert.assertEquals
import org.junit.Test

class MinHeapTest {

    @Test
    fun childIndex() {
        val heap = MinHeap(15)
        assertEquals(2, heap.leftChildIndexOf(1))
        assertEquals(4, heap.leftChildIndexOf(2))
        assertEquals(6, heap.leftChildIndexOf(3))
        assertEquals(8, heap.leftChildIndexOf(4))
        assertEquals(10, heap.leftChildIndexOf(5))
        assertEquals(12, heap.leftChildIndexOf(6))
        assertEquals(14, heap.leftChildIndexOf(7))
    }

    @Test
    fun parentIndex() {
        val heap = MinHeap(15)
        assertEquals(7, heap.parentIndexOf(15))
        assertEquals(7, heap.parentIndexOf(14))
        assertEquals(6, heap.parentIndexOf(13))
        assertEquals(6, heap.parentIndexOf(12))
        assertEquals(1, heap.parentIndexOf(3))
        assertEquals(1, heap.parentIndexOf(2))
        assertEquals(0, heap.parentIndexOf(1))
    }

    @Test
    fun insert() {
        val heap = MinHeap(15)

        /**
         * 14
         */
        heap.insert(14)
        assertEquals(14, heap.root())

        /**
         *   5
         *  /
         * 14
         */
        heap.insert(5)
        assertEquals(5, heap.root())
        assertEquals(14, heap.leftChildOf(ROOT_INDEX))

        /**
         *   5
         *  / \
         * 14 15
         */
        heap.insert(15)
        assertEquals(5, heap.root())
        assertEquals(14, heap.leftChildOf(ROOT_INDEX))
        assertEquals(15, heap.rightChildOf(ROOT_INDEX))

        /**
         *     5
         *    / \
         *   13 15
         *  /
         * 14
         */
        heap.insert(13)
        assertEquals(5, heap.root())
        assertEquals(13, heap.leftChildOf(ROOT_INDEX))
        assertEquals(15, heap.rightChildOf(ROOT_INDEX))
        assertEquals(14, heap.leftChildOf(heap.leftChildIndexOf(ROOT_INDEX)))

        /**
         *     3
         *    / \
         *   5  15
         *  / \
         * 14 13
         */
        heap.insert(3)
        assertEquals(3, heap.root())
        assertEquals(5, heap.leftChildOf(ROOT_INDEX))
        assertEquals(15, heap.rightChildOf(ROOT_INDEX))
        assertEquals(14, heap.leftChildOf(heap.leftChildIndexOf(ROOT_INDEX)))
        assertEquals(13, heap.rightChildOf(heap.leftChildIndexOf(ROOT_INDEX)))

        /**
         *      3
         *    /   \
         *   5     7
         *  / \   /
         * 14 13 15
         */
        heap.insert(7)
        assertEquals(3, heap.root())
        assertEquals(5, heap.leftChildOf(ROOT_INDEX))
        assertEquals(7, heap.rightChildOf(ROOT_INDEX))
        assertEquals(14, heap.leftChildOf(heap.leftChildIndexOf(ROOT_INDEX)))
        assertEquals(13, heap.rightChildOf(heap.leftChildIndexOf(ROOT_INDEX)))
        assertEquals(15, heap.leftChildOf(heap.rightChildIndexOf(ROOT_INDEX)))

        /**
         *      2
         *    /   \
         *   5     3
         *  / \   / \
         * 14 13 15 7
         */
        heap.insert(2)
        assertEquals(2, heap.root())
        assertEquals(5, heap.leftChildOf(ROOT_INDEX))
        assertEquals(3, heap.rightChildOf(ROOT_INDEX))
        assertEquals(14, heap.leftChildOf(heap.leftChildIndexOf(ROOT_INDEX)))
        assertEquals(13, heap.rightChildOf(heap.leftChildIndexOf(ROOT_INDEX)))
        assertEquals(15, heap.leftChildOf(heap.rightChildIndexOf(ROOT_INDEX)))
        assertEquals(7, heap.rightChildOf(heap.rightChildIndexOf(ROOT_INDEX)))
    }
}
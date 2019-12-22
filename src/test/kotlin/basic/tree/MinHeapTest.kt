package basic.tree

import basic.tree.MinHeap.Companion.ROOT_INDEX
import org.junit.Assert.*
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
        assertArrayEquals(arrayOf(14), heap.toArray())

        /**
         *   5
         *  /
         * 14
         */
        heap.insert(5)
        assertEquals(5, heap.root())
        assertEquals(14, heap.leftChildOf(ROOT_INDEX))
        assertArrayEquals(arrayOf(5, 14), heap.toArray())

        /**
         *   5
         *  / \
         * 14 15
         */
        heap.insert(15)
        assertEquals(5, heap.root())
        assertEquals(14, heap.leftChildOf(ROOT_INDEX))
        assertEquals(15, heap.rightChildOf(ROOT_INDEX))
        assertArrayEquals(arrayOf(5, 14, 15), heap.toArray())

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
        assertArrayEquals(arrayOf(5, 13, 15, 14), heap.toArray())

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
        assertArrayEquals(arrayOf(3, 5, 15, 14, 13), heap.toArray())

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
        assertArrayEquals(arrayOf(3, 5, 7, 14, 13, 15), heap.toArray())

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
        assertArrayEquals(arrayOf(2, 5, 3, 14, 13, 15, 7), heap.toArray())
    }

    @Test
    fun `extract 원소가 1개인 경우`() {

        // given
        val heap = MinHeap(15)
        val inserted = 1
        heap.insert(inserted)
        assertArrayEquals(arrayOf(1), heap.toArray())

        // when
        val extracted = heap.extract()

        // then
        assertEquals(inserted, extracted)
        assertArrayEquals(arrayOf(), heap.toArray())
    }

    @Test
    fun `extract 복잡한 경우`() {

        /**
         * 준비
         *
         *      2
         *    /   \
         *   5     3
         *  / \   / \
         * 14 13 15  4
         */
        val heap = MinHeap(15)
        heap.insert(14)
        heap.insert(5)
        heap.insert(15)
        heap.insert(13)
        heap.insert(3)
        heap.insert(4)
        heap.insert(2)
        assertArrayEquals(arrayOf(2, 5, 3, 14, 13, 15, 4), heap.toArray())

        /**
         *      3
         *    /   \
         *   5     4
         *  / \   /
         * 14 13 15
         */
        assertEquals(2, heap.extract())
        assertArrayEquals(arrayOf(3, 5, 4, 14, 13, 15), heap.toArray())

        /**
         *      4
         *    /   \
         *   5    15
         *  / \
         * 14 13
         */
        assertEquals(3, heap.extract())
        assertArrayEquals(arrayOf(4, 5, 15, 14, 13), heap.toArray())

        /**
         *      5
         *    /   \
         *   13    15
         *  / \
         * 14
         */
        assertEquals(4, heap.extract())
        assertArrayEquals(arrayOf(5, 13, 15, 14), heap.toArray())

        /**
         *      13
         *    /   \
         *   14    15
         */
        assertEquals(5, heap.extract())
        assertArrayEquals(arrayOf(13, 14, 15), heap.toArray())

        /**
         *     14
         *    /
         *   15
         */
        assertEquals(13, heap.extract())
        assertArrayEquals(arrayOf(14, 15), heap.toArray())

        /**
         * 루트에만 15가 남은 heap
         */
        assertEquals(14, heap.extract())
        assertArrayEquals(arrayOf(15), heap.toArray())

        /**
         * 마지막 값을 추출한 뒤 비어 있는 heap
         */
        assertEquals(15, heap.extract())
        assertArrayEquals(arrayOf(), heap.toArray())

        /**
         * 추출할 것이 없는 비어 있는 heap
         */
        assertNull(heap.extract())
        assertArrayEquals(arrayOf(), heap.toArray())
    }
}
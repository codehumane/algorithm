package hackerrank.linkedlist

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ReverseADoublyLinkedListKtTest {

    @Test
    fun reverse() {

        // given
        val node1 = DoublyLinkedListNode(1)
        val node2 = DoublyLinkedListNode(2)
        val node3 = DoublyLinkedListNode(3)
        val node4 = DoublyLinkedListNode(4)

        // and
        node1.next = node2
        node2.prev = node1
        node2.next = node3
        node3.prev = node2
        node3.next = node4
        node4.prev = node3

        // when
        val reversed = reverseDoublyLinkedListNode(node1)

        // then
        reversed!!.apply {
            assertNull(prev)
            assertEquals(4, data)
            assertEquals(3, next!!.data)
        }

        reversed.next!!.apply {
            assertEquals(4, prev!!.data)
            assertEquals(3, data)
            assertEquals(2, next!!.data)
        }

        reversed.next!!.next!!.apply {
            assertEquals(3, prev!!.data)
            assertEquals(2, data)
            assertEquals(1, next!!.data)
        }

        reversed.next!!.next!!.next!!.apply {
            assertEquals(2, prev!!.data)
            assertEquals(1, data)
            assertNull(next)
        }
    }

    @Test
    fun `reverse 원소가 하나뿐인 경우`() {

        // given
        val only = DoublyLinkedListNode(1)

        // when
        val reversed = reverseDoublyLinkedListNode(only)

        // then
        reversed!!.apply {
            assertEquals(1, data)
            assertNull(prev)
            assertNull(next)
        }
    }

    @Test
    fun `reverse 원소가 빈 경우`() {
        assertNull(reverseDoublyLinkedListNode(null))
    }
}
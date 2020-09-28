package linkedlist;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListReverseTest {

    @Test
    public void reverseListExample1() {

        // given: 1->2->3->4->5->NULL
        val node1 = new ListNode(1);
        val node2 = new ListNode(2);
        val node3 = new ListNode(3);
        val node4 = new ListNode(4);
        val node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // when
        val reversed = new LinkedListReverse().reverseList(node1);

        // then
        assertEquals(node5, reversed);
        assertEquals(node4, reversed.next);
        assertEquals(node3, reversed.next.next);
        assertEquals(node2, reversed.next.next.next);
        assertEquals(node1, reversed.next.next.next.next);
    }
}
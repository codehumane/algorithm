package linkedlist;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListRemoveTest {

    @Test
    public void removeElements() {

        // given: 1->2->6->3->4->5->6
        val node1 = new ListNode(1);
        val node2 = new ListNode(2);
        val node3 = new ListNode(3);
        val node4 = new ListNode(4);
        val node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // when: 6
        val removed = new LinkedListRemove().removeElements(node1, 6);

        // then: 1->2->3->4->5
        assertEquals(node1, removed);
        assertEquals(node2, removed.next);
        assertEquals(node3, removed.next.next);
        assertEquals(node4, removed.next.next.next);
        assertEquals(node5, removed.next.next.next.next);
    }
}
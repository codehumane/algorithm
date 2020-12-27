package quiz.linkedlist;

import data.linkedlist.ListNode;
import lombok.val;
import org.junit.Test;
import quiz.linkedlist.LinkedListOddEven;

import static org.junit.Assert.assertEquals;

public class LinkedListOddEvenTest {

    @Test
    public void oddEvenListExample1() {

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
        val oddEven = new LinkedListOddEven().oddEvenList(node1);

        // then
        assertEquals(node1, oddEven);
        assertEquals(node3, oddEven.next);
        assertEquals(node5, oddEven.next.next);
        assertEquals(node2, oddEven.next.next.next);
        assertEquals(node4, oddEven.next.next.next.next);
    }

    @Test
    public void oddEvenListExample2() {

        // given: 2->1->3->5->6->4->7->NULL
        val node1 = new ListNode(2);
        val node2 = new ListNode(1);
        val node3 = new ListNode(3);
        val node4 = new ListNode(5);
        val node5 = new ListNode(6);
        val node6 = new ListNode(4);
        val node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        // when
        val oddEven = new LinkedListOddEven().oddEvenList(node1);

        // then
        assertEquals(node1, oddEven);
        assertEquals(node3, oddEven.next);
        assertEquals(node5, oddEven.next.next);
        assertEquals(node7, oddEven.next.next.next);
        assertEquals(node2, oddEven.next.next.next.next);
        assertEquals(node4, oddEven.next.next.next.next.next);
        assertEquals(node6, oddEven.next.next.next.next.next.next);
    }

}
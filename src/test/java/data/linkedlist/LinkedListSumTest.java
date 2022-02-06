package data.linkedlist;

import data.linkedlist.LinkedListNode;
import data.linkedlist.LinkedListSum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListSumTest {

    @Test
    public void sum() {

        // 문제 (617: 7->1->6)
        final LinkedListNode l1 = new LinkedListNode(7);
        l1.next = new LinkedListNode(1);
        l1.next.next = new LinkedListNode(6);

        // 문제 (295: 5->9->2)
        final LinkedListNode l2 = new LinkedListNode(5);
        l2.next = new LinkedListNode(9);
        l2.next.next = new LinkedListNode(2);

        // 풀이
        final LinkedListNode result = LinkedListSum.sum(l1, l2);

        // 확인
        assertEquals(2, result.value);
        assertEquals(1, result.next.value);
        assertEquals(9, result.next.next.value);
    }

    @Test
    public void sum_자릿수_다를_경우() {

        // 문제 (17: 7->1)
        final LinkedListNode l1 = new LinkedListNode(7);
        l1.next = new LinkedListNode(1);

        // 문제 (295: 5->9->2)
        final LinkedListNode l2 = new LinkedListNode(5);
        l2.next = new LinkedListNode(9);
        l2.next.next = new LinkedListNode(2);

        // 풀이
        final LinkedListNode result = LinkedListSum.sum(l1, l2);

        // 확인
        assertEquals(2, result.value);
        assertEquals(1, result.next.value);
        assertEquals(3, result.next.next.value);
    }

    @Test
    public void sumReversely() {

        // 문제 (617: 6->1->7)
        final LinkedListNode l1 = new LinkedListNode(6);
        l1.next = new LinkedListNode(1);
        l1.next.next = new LinkedListNode(7);

        // 문제 (295: 2->9->5)
        final LinkedListNode l2 = new LinkedListNode(2);
        l2.next = new LinkedListNode(9);
        l2.next.next = new LinkedListNode(5);

        // 풀이
        final LinkedListNode result = LinkedListSum.sumReversely(l1, l2);

        // 확인
        assertEquals(9, result.value);
        assertEquals(1, result.next.value);
        assertEquals(2, result.next.next.value);
    }

    @Test
    public void sumReversely_자릿수_다를_경우() {

        // 문제 (17: 1->7)
        final LinkedListNode l1 = new LinkedListNode(1);
        l1.next = new LinkedListNode(7);

        // 문제 (295: 2->9->5)
        final LinkedListNode l2 = new LinkedListNode(2);
        l2.next = new LinkedListNode(9);
        l2.next.next = new LinkedListNode(5);

        // 풀이
        final LinkedListNode result = LinkedListSum.sumReversely(l1, l2);

        // 확인
        assertEquals(3, result.value);
        assertEquals(1, result.next.value);
        assertEquals(2, result.next.next.value);
    }

}
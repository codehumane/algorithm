package quiz.linkedlist;

import org.junit.jupiter.api.Test;
import quiz.linkedlist.RemoveNthNodeFromEndOfList.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class RemoveNthNodeFromEndOfListTest {

    private final RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();

    @Test
    void example1() {

        // given
        var n5 = new ListNode(5);
        var n4 = new ListNode(4, n5);
        var n3 = new ListNode(3, n4);
        var n2 = new ListNode(2, n3);
        var n1 = new ListNode(1, n2);

        // when
        var head = solution.removeNthFromEnd(n1, 2);

        // then
        assertEquals(head, n1);
        assertEquals(head.next, n2);
        assertEquals(head.next.next, n3);
        assertEquals(head.next.next.next, n5);
    }

    @Test
    void example2() {
        var n1 = new ListNode(1);
        var head = solution.removeNthFromEnd(n1, 1);
        assertNull(head);
    }

    @Test
    void example3() {
        var n2 = new ListNode(2);
        var n1 = new ListNode(1, n2);
        var head = solution.removeNthFromEnd(n1, 1);
        assertEquals(head, n1);
        assertNull(head.next);
    }

    @Test
    void custom1() {
        var n2 = new ListNode(2);
        var n1 = new ListNode(1, n2);
        var head = solution.removeNthFromEnd(n1, 2);
        assertEquals(head, n2);
        assertNull(head.next);
    }

    @Test
    void custom2() {

        // given
        var n3 = new ListNode(3);
        var n2 = new ListNode(2, n3);
        var n1 = new ListNode(1, n2);

        // when
        var head = solution.removeNthFromEnd(n1, 1);

        // then
        assertEquals(head, n1);
        assertEquals(head.next, n2);
        assertNull(head.next.next);
    }

    @Test
    void custom3() {

        // given
        var n3 = new ListNode(3);
        var n2 = new ListNode(2, n3);
        var n1 = new ListNode(1, n2);

        // when
        var head = solution.removeNthFromEnd(n1, 2);

        // then
        assertEquals(head, n1);
        assertEquals(head.next, n3);
        assertNull(head.next.next);
    }

    @Test
    void custom4() {

        // given
        var n3 = new ListNode(3);
        var n2 = new ListNode(2, n3);
        var n1 = new ListNode(1, n2);

        // when
        var head = solution.removeNthFromEnd(n1, 3);

        // then
        assertEquals(head, n2);
        assertEquals(head.next, n3);
        assertNull(head.next.next);
    }

}
package quiz.linkedlist;

import org.junit.jupiter.api.Test;
import quiz.linkedlist.SwapNodesInPairs.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SwapNodesInPairsTest {

    private final SwapNodesInPairs solution = new SwapNodesInPairs();

    @Test
    void example1() {

        // given
        var n1 = new ListNode(1);
        var n2 = new ListNode(2);
        var n3 = new ListNode(3);
        var n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        // when
        var swapped = solution.swapPairs(n1);

        // then
        assertEquals(swapped, n2);
        assertEquals(swapped.next, n1);
        assertEquals(swapped.next.next, n4);
        assertEquals(swapped.next.next.next, n3);
        assertNull(swapped.next.next.next.next);
    }

    @Test
    void example2() {
        assertNull(solution.swapPairs(null));
    }

    @Test
    void example3() {
        var n1 = new ListNode(1);
        var swapped = solution.swapPairs(n1);
        assertEquals(n1, swapped);
        assertNull(swapped.next);
    }

    @Test
    void custom1() {

        // given
        var n1 = new ListNode(1);
        var n2 = new ListNode(2);
        n1.next = n2;

        // when
        var swapped = solution.swapPairs(n1);

        // then
        assertEquals(n2, swapped);
        assertEquals(n1, swapped.next);
        assertNull(swapped.next.next);
    }

    @Test
    void custom2() {

        // given
        var n1 = new ListNode(1);
        var n2 = new ListNode(2);
        var n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        // when
        var swapped = solution.swapPairs(n1);

        // then
        assertEquals(n2, swapped);
        assertEquals(n1, swapped.next);
        assertEquals(n3, swapped.next.next);
        assertNull(swapped.next.next.next);
    }

    @Test
    void custom3() {

        // given
        var n1 = new ListNode(1);
        var n2 = new ListNode(2);
        var n3 = new ListNode(3);
        var n4 = new ListNode(4);
        var n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // when
        var swapped = solution.swapPairs(n1);

        // then
        assertEquals(swapped, n2);
        assertEquals(swapped.next, n1);
        assertEquals(swapped.next.next, n4);
        assertEquals(swapped.next.next.next, n3);
        assertEquals(swapped.next.next.next.next, n5);
        assertNull(swapped.next.next.next.next.next);
    }
    
}
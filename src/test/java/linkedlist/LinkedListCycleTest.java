package linkedlist;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListCycleTest {

    @Test
    public void hasCycleExample1() {

        // given: 3 -> 2 -> 0 -> -4 -> 2(cycle)
        val node1 = new LinkedListCycle.ListNode(3);
        val node2 = new LinkedListCycle.ListNode(2);
        val node3 = new LinkedListCycle.ListNode(0);
        val node4 = new LinkedListCycle.ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        // when
        val hasCycle = new LinkedListCycle().hasCycle(node1);

        // then
        assertTrue(hasCycle);
    }

    @Test
    public void hasCycleExample2() {

        // given: 1 -> 2 -> 1(cycle)
        val node1 = new LinkedListCycle.ListNode(1);
        val node2 = new LinkedListCycle.ListNode(2);
        node1.next = node2;
        node2.next = node1;

        // when
        val hasCycle = new LinkedListCycle().hasCycle(node1);

        // then
        assertTrue(hasCycle);
    }

    @Test
    public void hasCycleExample3() {

        // given: 1
        val node1 = new LinkedListCycle.ListNode(1);

        // when
        val hasCycle = new LinkedListCycle().hasCycle(node1);

        // then
        assertFalse(hasCycle);
    }

    @Test
    public void hasCycleWhenHeadIsNull() {

        // when
        val hasCycle = new LinkedListCycle().hasCycle(null);

        // then
        assertFalse(hasCycle);
    }

    @Test
    public void detectCycleExample1() {

        // given: 3 -> 2 -> 0 -> -4 -> 2(cycle)
        val node1 = new LinkedListCycle.ListNode(3);
        val node2 = new LinkedListCycle.ListNode(2);
        val node3 = new LinkedListCycle.ListNode(0);
        val node4 = new LinkedListCycle.ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        // when
        val cycle = new LinkedListCycle().detectCycle(node1);

        // then
        assertNotNull(cycle);
        assertEquals(node2, cycle);
    }

    @Test
    public void detectCycleExample2() {

        // given: 1 -> 2 -> 1(cycle)
        val node1 = new LinkedListCycle.ListNode(1);
        val node2 = new LinkedListCycle.ListNode(2);
        node1.next = node2;
        node2.next = node1;

        // when
        val cycle = new LinkedListCycle().detectCycle(node1);

        // then
        assertNotNull(cycle);
        assertEquals(node1, cycle);
    }

    @Test
    public void detectCycleExample3() {

        // given: 1
        val node1 = new LinkedListCycle.ListNode(1);

        // when
        val cycle = new LinkedListCycle().detectCycle(node1);

        // then
        assertNull(cycle);
    }

    @Test
    public void detectCycleCustom1() {

        // given: 1 -> 2 -> 3 -> 4 -> 5 -> 3
        val node1 = new LinkedListCycle.ListNode(1);
        val node2 = new LinkedListCycle.ListNode(2);
        val node3 = new LinkedListCycle.ListNode(3);
        val node4 = new LinkedListCycle.ListNode(4);
        val node5 = new LinkedListCycle.ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        // when
        val cycle = new LinkedListCycle().detectCycle(node1);

        // then
        assertNotNull(cycle);
        assertEquals(node3, cycle);
    }

    @Test
    public void detectCycleCustom2() {

        // given: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 3
        val node1 = new LinkedListCycle.ListNode(1);
        val node2 = new LinkedListCycle.ListNode(2);
        val node3 = new LinkedListCycle.ListNode(3);
        val node4 = new LinkedListCycle.ListNode(4);
        val node5 = new LinkedListCycle.ListNode(5);
        val node6 = new LinkedListCycle.ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;

        // when
        val cycle = new LinkedListCycle().detectCycle(node1);

        // then
        assertNotNull(cycle);
        assertEquals(node3, cycle);
    }

    @Test
    public void detectCycleCustom3() {

        // given: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 4
        val node1 = new LinkedListCycle.ListNode(1);
        val node2 = new LinkedListCycle.ListNode(2);
        val node3 = new LinkedListCycle.ListNode(3);
        val node4 = new LinkedListCycle.ListNode(4);
        val node5 = new LinkedListCycle.ListNode(5);
        val node6 = new LinkedListCycle.ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node4;

        // when
        val cycle = new LinkedListCycle().detectCycle(node1);

        // then
        assertNotNull(cycle);
        assertEquals(node4, cycle);
    }

    @Test
    public void detectCycleCustom4() {

        // given: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 4
        val node1 = new LinkedListCycle.ListNode(1);
        val node2 = new LinkedListCycle.ListNode(2);
        val node3 = new LinkedListCycle.ListNode(3);
        val node4 = new LinkedListCycle.ListNode(4);
        val node5 = new LinkedListCycle.ListNode(5);
        val node6 = new LinkedListCycle.ListNode(6);
        val node7 = new LinkedListCycle.ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node4;

        // when
        val cycle = new LinkedListCycle().detectCycle(node1);

        // then
        assertNotNull(cycle);
        assertEquals(node4, cycle);
    }

    @Test
    public void detectCycleCustom5() {

        // given: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 4
        val node1 = new LinkedListCycle.ListNode(1);
        val node2 = new LinkedListCycle.ListNode(2);
        val node3 = new LinkedListCycle.ListNode(3);
        val node4 = new LinkedListCycle.ListNode(4);
        val node5 = new LinkedListCycle.ListNode(5);
        val node6 = new LinkedListCycle.ListNode(6);
        val node7 = new LinkedListCycle.ListNode(7);
        val node8 = new LinkedListCycle.ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node4;

        // when
        val cycle = new LinkedListCycle().detectCycle(node1);

        // then
        assertNotNull(cycle);
        assertEquals(node4, cycle);
    }

    @Test
    public void detectCycleCustom6() {

        // given: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 8
        val node1 = new LinkedListCycle.ListNode(1);
        val node2 = new LinkedListCycle.ListNode(2);
        val node3 = new LinkedListCycle.ListNode(3);
        val node4 = new LinkedListCycle.ListNode(4);
        val node5 = new LinkedListCycle.ListNode(5);
        val node6 = new LinkedListCycle.ListNode(6);
        val node7 = new LinkedListCycle.ListNode(7);
        val node8 = new LinkedListCycle.ListNode(8);
        val node9 = new LinkedListCycle.ListNode(9);
        val node10 = new LinkedListCycle.ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node10;

        // when
        val cycle = new LinkedListCycle().detectCycle(node1);

        // then
        assertNotNull(cycle);
        assertEquals(node10, cycle);
    }

}

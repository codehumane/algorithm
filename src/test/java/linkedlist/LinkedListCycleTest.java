package linkedlist;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

}

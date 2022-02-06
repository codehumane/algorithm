package data.linkedlist;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTwoPointerTest {

    @Test
    public void hasCycleExample1() {

        // given: 3 -> 2 -> 0 -> -4 -> 2(cycle)
        val node1 = new ListNode(3);
        val node2 = new ListNode(2);
        val node3 = new ListNode(0);
        val node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        // when
        val hasCycle = new LinkedListTwoPointer().hasCycle(node1);

        // then
        assertTrue(hasCycle);
    }

    @Test
    public void hasCycleExample2() {

        // given: 1 -> 2 -> 1(cycle)
        val node1 = new ListNode(1);
        val node2 = new ListNode(2);
        node1.next = node2;
        node2.next = node1;

        // when
        val hasCycle = new LinkedListTwoPointer().hasCycle(node1);

        // then
        assertTrue(hasCycle);
    }

    @Test
    public void hasCycleExample3() {

        // given: 1
        val node1 = new ListNode(1);

        // when
        val hasCycle = new LinkedListTwoPointer().hasCycle(node1);

        // then
        assertFalse(hasCycle);
    }

    @Test
    public void hasCycleWhenHeadIsNull() {

        // when
        val hasCycle = new LinkedListTwoPointer().hasCycle(null);

        // then
        assertFalse(hasCycle);
    }

    @Test
    public void detectCycleExample1() {

        // given: 3 -> 2 -> 0 -> -4 -> 2(cycle)
        val node1 = new ListNode(3);
        val node2 = new ListNode(2);
        val node3 = new ListNode(0);
        val node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        // when
        val cycle = new LinkedListTwoPointer().detectCycle(node1);

        // then
        assertNotNull(cycle);
        assertEquals(node2, cycle);
    }

    @Test
    public void detectCycleExample2() {

        // given: 1 -> 2 -> 1(cycle)
        val node1 = new ListNode(1);
        val node2 = new ListNode(2);
        node1.next = node2;
        node2.next = node1;

        // when
        val cycle = new LinkedListTwoPointer().detectCycle(node1);

        // then
        assertNotNull(cycle);
        assertEquals(node1, cycle);
    }

    @Test
    public void detectCycleExample3() {

        // given: 1
        val node1 = new ListNode(1);

        // when
        val cycle = new LinkedListTwoPointer().detectCycle(node1);

        // then
        assertNull(cycle);
    }

    @Test
    public void detectCycleCustom1() {

        // given: 1 -> 2 -> 3 -> 4 -> 5 -> 3
        val node1 = new ListNode(1);
        val node2 = new ListNode(2);
        val node3 = new ListNode(3);
        val node4 = new ListNode(4);
        val node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        // when
        val cycle = new LinkedListTwoPointer().detectCycle(node1);

        // then
        assertNotNull(cycle);
        assertEquals(node3, cycle);
    }

    @Test
    public void detectCycleCustom2() {

        // given: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 3
        val node1 = new ListNode(1);
        val node2 = new ListNode(2);
        val node3 = new ListNode(3);
        val node4 = new ListNode(4);
        val node5 = new ListNode(5);
        val node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;

        // when
        val cycle = new LinkedListTwoPointer().detectCycle(node1);

        // then
        assertNotNull(cycle);
        assertEquals(node3, cycle);
    }

    @Test
    public void detectCycleCustom3() {

        // given: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 4
        val node1 = new ListNode(1);
        val node2 = new ListNode(2);
        val node3 = new ListNode(3);
        val node4 = new ListNode(4);
        val node5 = new ListNode(5);
        val node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node4;

        // when
        val cycle = new LinkedListTwoPointer().detectCycle(node1);

        // then
        assertNotNull(cycle);
        assertEquals(node4, cycle);
    }

    @Test
    public void detectCycleCustom4() {

        // given: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 4
        val node1 = new ListNode(1);
        val node2 = new ListNode(2);
        val node3 = new ListNode(3);
        val node4 = new ListNode(4);
        val node5 = new ListNode(5);
        val node6 = new ListNode(6);
        val node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node4;

        // when
        val cycle = new LinkedListTwoPointer().detectCycle(node1);

        // then
        assertNotNull(cycle);
        assertEquals(node4, cycle);
    }

    @Test
    public void detectCycleCustom5() {

        // given: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 4
        val node1 = new ListNode(1);
        val node2 = new ListNode(2);
        val node3 = new ListNode(3);
        val node4 = new ListNode(4);
        val node5 = new ListNode(5);
        val node6 = new ListNode(6);
        val node7 = new ListNode(7);
        val node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node4;

        // when
        val cycle = new LinkedListTwoPointer().detectCycle(node1);

        // then
        assertNotNull(cycle);
        assertEquals(node4, cycle);
    }

    @Test
    public void detectCycleCustom6() {

        // given: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 8
        val node1 = new ListNode(1);
        val node2 = new ListNode(2);
        val node3 = new ListNode(3);
        val node4 = new ListNode(4);
        val node5 = new ListNode(5);
        val node6 = new ListNode(6);
        val node7 = new ListNode(7);
        val node8 = new ListNode(8);
        val node9 = new ListNode(9);
        val node10 = new ListNode(8);
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
        val cycle = new LinkedListTwoPointer().detectCycle(node1);

        // then
        assertNotNull(cycle);
        assertEquals(node10, cycle);
    }

    @Test
    public void getIntersectionNodeExample1() {

        // given:
        //      4 -> 1
        //            \
        //              -> 8 -> 4 -> 5
        //            /
        // 5 -> 6 -> 1
        val nodeA1 = new ListNode(4);
        val nodeA2 = new ListNode(1);
        val nodeB1 = new ListNode(5);
        val nodeB2 = new ListNode(6);
        val nodeB3 = new ListNode(1);
        val nodeI1 = new ListNode(8);
        val nodeI2 = new ListNode(4);
        val nodeI3 = new ListNode(5);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeI1;
        nodeB1.next = nodeB2;
        nodeB2.next = nodeB3;
        nodeB3.next = nodeI1;
        nodeI1.next = nodeI2;
        nodeI2.next = nodeI3;

        // when
        val intersection = new LinkedListTwoPointer().getIntersectionNode(nodeA1, nodeB1);

        // then
        assertEquals(nodeI1, intersection);
    }

    @Test
    public void getIntersectionNodeExample2() {

        // given:
        // 1 -> 9 -> 1
        //            \
        //              -> 2 -> 4
        //            /
        //           3
        val nodeA1 = new ListNode(1);
        val nodeA2 = new ListNode(9);
        val nodeA3 = new ListNode(1);
        val nodeB1 = new ListNode(3);
        val nodeI1 = new ListNode(2);
        val nodeI2 = new ListNode(4);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = nodeI1;
        nodeB1.next = nodeI1;
        nodeI1.next = nodeI2;

        // when
        val intersection = new LinkedListTwoPointer().getIntersectionNode(nodeA1, nodeB1);

        // then
        assertEquals(nodeI1, intersection);
    }

    @Test
    public void getIntersectionNodeExample3() {

        // given: 만나지 않음
        // 2 -> 6 -> 4
        //      1 -> 5
        val nodeA1 = new ListNode(2);
        val nodeA2 = new ListNode(6);
        val nodeA3 = new ListNode(4);
        val nodeB1 = new ListNode(1);
        val nodeB2 = new ListNode(5);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeB1.next = nodeB2;

        // when
        val intersection = new LinkedListTwoPointer().getIntersectionNode(nodeA1, nodeB1);

        // then
        assertNull(intersection);
    }

    @Test
    public void removeNthFromEndExample1() {

        // given 1 -> 2 -> 3 -> 4 -> 5
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
        val removed = new LinkedListTwoPointer().removeNthFromEndMoreEasily(node1, 2);

        // then 1 -> 2 -> 3 -> 5
        assertEquals(removed, node1);
        assertEquals(node2, node1.next);
        assertEquals(node3, node2.next);
        assertEquals(node5, node3.next);
        assertNull(node5.next);
    }

    @Test
    public void removeNthFromEndWhenFirstToBeRemoved() {

        // given
        val node1 = new ListNode(1);
        val node2 = new ListNode(2);
        node1.next = node2;

        // when
        val removed = new LinkedListTwoPointer().removeNthFromEndMoreEasily(node1, 2);

        assertEquals(node2, removed);
        assertNull(removed.next);
    }

    @Test
    public void removeNthFromEndWhenLastToBeRemoved() {

        // given
        val node1 = new ListNode(1);
        val node2 = new ListNode(2);
        node1.next = node2;

        // when
        val removed = new LinkedListTwoPointer().removeNthFromEndMoreEasily(node1, 1);

        assertEquals(node1, removed);
        assertNull(removed.next);
    }

    @Test
    public void removeNthFromEndWhenOfOnlyOne() {

        // given
        val node1 = new ListNode(1);

        // when
        val removed = new LinkedListTwoPointer().removeNthFromEndMoreEasily(node1, 1);

        // then
        assertNull(removed);
    }

}

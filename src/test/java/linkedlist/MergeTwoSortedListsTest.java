package linkedlist;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MergeTwoSortedListsTest {

    @Test
    public void mergeTwoListsExample1() {

        // given: 1->2->4, 1->3->4
        val nodeA1 = new ListNode(1);
        val nodeA2 = new ListNode(2);
        val nodeA3 = new ListNode(4);
        val nodeB1 = new ListNode(1);
        val nodeB2 = new ListNode(3);
        val nodeB3 = new ListNode(4);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeB1.next = nodeB2;
        nodeB2.next = nodeB3;

        // when
        val merged = new MergeTwoSortedLists().mergeTwoLists(nodeA1, nodeB1);

        // then: 1->1->2->3->4->4
        assertEquals(nodeA1.val, merged.val);
        assertEquals(nodeB1.val, merged.next.val);
        assertEquals(nodeA2.val, merged.next.next.val);
        assertEquals(nodeB2.val, merged.next.next.next.val);
        assertEquals(nodeA3.val, merged.next.next.next.next.val);
        assertEquals(nodeB3.val, merged.next.next.next.next.next.val);
    }

    @Test
    public void mergeTwoListsExample2() {
        // given: 2, 1
        val nodeA1 = new ListNode(2);
        val nodeB1 = new ListNode(1);

        // when
        val merged = new MergeTwoSortedLists().mergeTwoLists(nodeA1, nodeB1);

        // then: 1->2
        assertEquals(nodeB1.val, merged.val);
        assertEquals(nodeA1.val, merged.next.val);
    }

}
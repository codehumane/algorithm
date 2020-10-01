package data.linkedlist;

public class LinkedListRemove {

    /**
     * Remove all elements from a linked list of integers that have value val.
     * <p>
     * Example:
     * Input:  1->2->6->3->4->5->6, val = 6
     * Output: 1->2->3->4->5
     */
    public ListNode removeElements(ListNode head, int val) {
        final ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode cursor = dummy;

        while (cursor.next != null) {
            if (cursor.next.val == val) cursor.next = cursor.next.next;
            else cursor = cursor.next;
        }

        return dummy.next;
    }
}

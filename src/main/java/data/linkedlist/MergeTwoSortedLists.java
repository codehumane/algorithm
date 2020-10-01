package data.linkedlist;

/**
 * Merge two sorted linked lists and return it as a new sorted list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = new ListNode(-1);
        ListNode c = head;
        ListNode c1 = l1;
        ListNode c2 = l2;

        while (c1 != null || c2 != null) {

            if (c1 == null || (c2 != null && c1.val > c2.val)) {
                c.next = c2;
                c = c.next;
                c2 = c2.next;
            } else {
                c.next = c1;
                c = c.next;
                c1 = c1.next;
            }

        }

        return head.next;
    }

}

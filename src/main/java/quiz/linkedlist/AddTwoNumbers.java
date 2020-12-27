package quiz.linkedlist;

import data.linkedlist.ListNode;

public class AddTwoNumbers {

    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     * <p>
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * <p>
     * Example:
     * <p>
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode cursor = result;
        ListNode c1 = l1;
        ListNode c2 = l2;
        int left = 0;

        while (c1 != null || c2 != null) {
            int added = ((c1 == null) ? 0 : c1.val) + ((c2 == null) ? 0 : c2.val) + left;
            cursor.next = new ListNode(added % 10);
            left = added / 10;

            if (c1 != null) c1 = c1.next;
            if (c2 != null) c2 = c2.next;
            cursor = cursor.next;
        }

        if (left > 0) cursor.next = new ListNode(left);

        return result.next;
    }

}

package data.linkedlist;

public class LinkedListReverse {

    /**
     * Reverse a singly linked list.
     * <p>
     * In this algorithm, each node will be moved exactly once.
     * Therefore, the time complexity is O(N),
     * where N is the length of the linked list.
     * <p>
     * We only use constant extra space so the space complexity is O(1).
     */
    public ListNode reverseList(ListNode head) {
        ListNode reversed = null;
        ListNode before = null;
        ListNode cursor = head;
        ListNode next;

        while (cursor != null) {
            next = cursor.next;
            cursor.next = before;
            reversed = cursor;
            before = cursor;
            cursor = next;
        }

        return reversed;
    }

}

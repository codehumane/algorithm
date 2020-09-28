package linkedlist;

public class LinkedListPalindrome {

    private static final LinkedListReverse reverser = new LinkedListReverse();

    /**
     * Given a singly linked list, determine if it is a palindrome.
     * <p>
     * Example 1:
     * Input: 1->2
     * Output: false
     * <p>
     * Example 2:
     * Input: 1->2->2->1
     * Output: true
     * <p>
     * Follow up:
     * Could you do it in O(n) time and O(1) space?
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        if (head.next == null) return true;

        final int size = getSize(head);
        ListNode half = forward(head, size / 2 - 1);
        ListNode right = reverse(splitHalf(size, half));
        return equalsValues(head, right);
    }

    private int getSize(ListNode node) {
        int size = 0;

        while (node != null) {
            node = node.next;
            size++;
        }

        return size;
    }

    private ListNode forward(ListNode from, int step) {
        for (int i = 1; i <= step; i++) {
            from = from.next;
        }

        return from;
    }

    private ListNode splitHalf(int size, ListNode half) {
        final ListNode rightHead;

        if (size % 2 == 0) {
            rightHead = half.next;
        } else {
            rightHead = half.next.next;
            half.next.next = null;
        }

        half.next = null;
        return rightHead;
    }

    private ListNode reverse(ListNode head) {
        return reverser.reverseList(head);
    }

    private boolean equalsValues(ListNode left, ListNode right) {
        while (right != null) {
            if (right.val != left.val) return false;
            right = right.next;
            left = left.next;
        }

        return true;
    }

}

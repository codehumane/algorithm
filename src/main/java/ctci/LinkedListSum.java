package ctci;

/**
 * 입력: (7 -> 1 -> 6) + (5 -> 9 -> 2). 즉, 617 + 295
 * 출력: 2 -> 1 -> 9. 즉, 912.
 */
public class LinkedListSum {

    public static LinkedListNode sum(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode cur = new LinkedListNode();
        LinkedListNode head = cur;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int left = (l1 == null) ? 0 : l1.value;
            int right = (l2 == null) ? 0 : l2.value;
            int sum = carry + left + right;

            carry = sum / 10;
            cur.value = sum % 10;
            cur.next = new LinkedListNode();
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        cur.next = null;
        return head;
    }

}

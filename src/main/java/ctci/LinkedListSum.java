package ctci;

public class LinkedListSum {

    /**
     * 입력: (7 -> 1 -> 6) + (5 -> 9 -> 2). 즉, 617 + 295
     * 출력: 2 -> 1 -> 9. 즉, 912.
     */
    public static LinkedListNode sum(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode cur = new LinkedListNode();
        LinkedListNode head = cur;
        LinkedListNode tail = cur;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int left = (l1 == null) ? 0 : l1.value;
            int right = (l2 == null) ? 0 : l2.value;
            int sum = carry + left + right;

            carry = sum / 10;
            cur.value = sum % 10;
            cur.next = new LinkedListNode();

            tail = cur;
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        tail.next = null;
        return head;
    }

    /**
     * 입력: (6 -> 1 -> 7) + (2 -> 9 -> 5). 즉, 617 + 295
     * 출력: (9 -> 1 -> 2). 즉, 912.
     */
    public static LinkedListNode sumReversely(LinkedListNode l1, LinkedListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        LinkedListNode sum = sum(l1, l2);
        return reverse(sum);

//        LinkedListNode cur = new LinkedListNode();
//        LinkedListNode head = cur;
//        LinkedListNode before;
//
//        padStart(l1, l2);
//
//        while (l1 != null || l2 != null) {
//            int left = (l1 == null) ? 0 : l1.value;
//            int right = (l2 == null) ? 0 : l2.value;
//            int sum = carry + left + right;
//
//            carry = sum / 10;
//            cur.value = sum % 10;
//            cur.next = new LinkedListNode();
//            cur = cur.next;
//
//            if (l1 != null) l1 = l1.next;
//            if (l2 != null) l2 = l2.next;
//        }
    }

    private static LinkedListNode reverse(LinkedListNode node) {
        if (node == null) return null;

        LinkedListNode head = node;
        node = node.next;
        head.next = null;

        while (node != null) {
            LinkedListNode after = node.next;
            node.next = head;
            head = node;
            node = after;
        }

        return head;
    }

    private static void padStart(LinkedListNode l1, LinkedListNode l2) {
        int l1Length = lengthOf(l1);
        int l2Length = lengthOf(l2);

        if (l1Length < l2Length) {
            padStart(l1, l2Length - l1Length);
        }

        if (l1Length > l2Length) {
            padStart(l2, l1Length - l2Length);
        }
    }

    private static int lengthOf(LinkedListNode node) {
        int length = 0;

        while (node != null) {
            node = node.next;
            length++;
        }

        return length;
    }

    private static void padStart(LinkedListNode head, int diff) {
        for (int i = 0; i < diff; i++) {
            LinkedListNode pad = new LinkedListNode(0);
            pad.next = head;
            head = pad;
        }
    }

}

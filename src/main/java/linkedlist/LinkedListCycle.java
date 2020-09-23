package linkedlist;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        ListNode faster = head;
        ListNode slower = head;

        while (faster != null && faster.next != null) {

            faster = faster.next;
            if (faster == slower) return true;

            faster = faster.next;
            if (faster == null) return false;
            if (faster == slower) return true;

            slower = slower.next;
        }

        return false;
    }

    public static class ListNode {

        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }
}


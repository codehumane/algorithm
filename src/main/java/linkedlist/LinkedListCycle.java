package linkedlist;

public class LinkedListCycle {

    /**
     * Given head, the head of a linked list,
     * determine if the linked list has a cycle in it.
     */
    public boolean hasCycle(ListNode head) {
        return findMeetPoint(head) != null;
    }

    /**
     * Given a linked list, return the node where the cycle begins.
     * If there is no cycle, return null.
     * Solve it using O(1) (i.e. constant) memory
     */
    public ListNode detectCycle(ListNode head) {
        final ListNode met = findMeetPoint(head);
        if (met == null) return null;

        ListNode fromStart = head;
        ListNode fromMet = met;

        while (true) {
            if (fromStart == fromMet) return fromStart;
            fromStart = fromStart.next;
            fromMet = fromMet.next;
        }
    }

    private ListNode findMeetPoint(ListNode head) {
        ListNode faster = head;
        ListNode slower = head;

        while (faster != null) {
            faster = faster.next;
            if (faster == null) return null;

            faster = faster.next;
            if (faster == null) return null;

            slower = slower.next;
            if (slower == faster) return slower;
        }

        return null;
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


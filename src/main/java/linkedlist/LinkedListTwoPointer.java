package linkedlist;

public class LinkedListTwoPointer {

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

    /**
     * find the node
     * at which the intersection of two singly linked lists begins.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        final int sizeA = getSize(headA);
        final int sizeB = getSize(headB);
        final int diff = sizeA - sizeB;

        ListNode cursorA = headA;
        ListNode cursorB = headB;

        if (diff > 0) cursorA = forward(cursorA, diff);
        else cursorB = forward(cursorB, -diff);

        while (true) {
            if (cursorA == null) return null;
            if (cursorB == null) return null;
            if (cursorA == cursorB) return cursorA;
            cursorA = cursorA.next;
            cursorB = cursorB.next;
        }
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (true) {
            if (head == null) return size;
            head = head.next;
            size++;
        }
    }

    private ListNode forward(ListNode cursor, int diff) {
        for (int i = 0; i < diff; i++) {
            cursor = cursor.next;
        }

        return cursor;
    }

    /**
     * Given a linked list,
     * remove the n-th node from the end of list
     * and return its head.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        final int size = getSize(head);

        if (n == 0) return head;

        if (n == size) {
            final ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }

        final ListNode remover = forward(head, size - n - 1);
        remover.next = remover.next.next;
        return head;
    }

    public ListNode removeNthFromEndMoreEasily(ListNode head, int n) {

        // dummy:
        //  - head 포인터(캐시)임과 동시에,
        //  - 노드가 한 개 뿐이 없는 경우에도 코드를 간결하게 유지해 준다.
        final ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode ahead = dummy;
        ListNode behind = dummy;
        dummy.next = head;

        for (int i = 0; i < n; i++) {
            // n이 valid(이는 거꾸로인 경우에도 마찬가지)하다고 전제하고 있으므로 null check 불필요
            ahead = ahead.next;
        }

        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }

        behind.next = behind.next.next;
        return dummy.next;
    }

}


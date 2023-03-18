package quiz.linkedlist;

import lombok.ToString;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        final var prefix = new ListNode(Integer.MIN_VALUE, head);

        var node = prefix;
        while (node.next != null && node.next.next != null) {
            var n1 = node.next;
            var n2 = node.next.next;
            var n3 = node.next.next.next;

            node.next = n2;
            n2.next = n1;
            n1.next = n3;

            node = n1;
        }

        return prefix.next;
    }

    @ToString(of = {"val"})
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

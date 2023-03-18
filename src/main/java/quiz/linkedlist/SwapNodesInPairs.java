package quiz.linkedlist;

import lombok.ToString;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        if (isNull(head)) return null;
        if (isNull(head.next)) return head;

        final ListNode newHead = head.next;
        ListNode before = null;
        ListNode node = head;

        while (nonNull(node) && nonNull(node.next)) {
            var temp = node.next.next;

            if (nonNull(before)) {
                before.next = node.next;
            }

            node.next.next = node;
            node.next = temp;
            before = node;
            node = temp;
        }

        return newHead;
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

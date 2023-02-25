package quiz.linkedlist;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Objects;

@Slf4j
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        assert Objects.nonNull(head);
        var deque = new ArrayDeque<ListNode>(n + 1);
        var node = head;

        while (Objects.nonNull(node)) {
            if (deque.size() > n) {
                deque.removeFirst();
            }

            deque.offer(node);
            node = node.next;
        }

        if (deque.size() == n) {
            return head.next;
        }

        var first = deque.removeFirst();
        var second = deque.removeFirst();
        first.next = second.next;
        return head;

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

package hackerrank.linkedlist;

public class ReverseADoublyLinkedListJava {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode temp = null;
        DoublyLinkedListNode node = head;

        while (node != null) {
            node.prev = node.next;
            node.next = temp;
            temp = node;
            if (node.prev == null) break;
            node = node.prev;
        }

        return node;
    }

}


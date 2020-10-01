package data.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList {

    private DoublyListNode head;
    private int size = 0;

    /**
     * Get the value of the index-th node in the linked list.
     * If the index is invalid, return -1.
     */
    public int get(int index) {
        final DoublyListNode found = find(index);
        return found != null ? found.val : -1;
    }

    private DoublyListNode find(int index) {
        if (head == null) return null;
        DoublyListNode cursor = head;
        for (int i = 1; i <= index && cursor != null; i++) {
            cursor = cursor.next;
        }

        return cursor;
    }

    /**
     * Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        final DoublyListNode add = new DoublyListNode(val);

        if (head != null) {
            head.prev = add;
            add.next = head;
        }

        head = add;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        final DoublyListNode tail = new DoublyListNode(val);

        if (head == null) {
            head = tail;
            size++;
            return;
        }

        DoublyListNode last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = tail;
        tail.prev = last;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        final DoublyListNode at = find(index);
        if (at == null) return;

        final DoublyListNode add = new DoublyListNode(val);

        add.prev = at.prev;
        add.next = at;

        at.prev.next = add;
        at.prev = add;

        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (head == null) return;

        if (index == 0) {
            head = head.next;
            if (head != null) head.prev = null;
            size--;
            return;
        }

        final DoublyListNode at = find(index);
        if (at == null) return;

        at.prev.next = at.next;
        if (at.next != null) at.next.prev = at.prev;
        size--;
    }

    @Override
    public String toString() {
        final List<String> values = new ArrayList<>(size);
        DoublyListNode cursor = this.head;

        while (cursor != null) {
            values.add(String.valueOf(cursor.val));
            cursor = cursor.next;
        }

        return "DoublyLinkedList{" + String.join(", ", values) + '}';
    }

    static class DoublyListNode {

        public int val;
        public DoublyListNode prev;
        public DoublyListNode next;

        public DoublyListNode(int val) {
            this.val = val;
            next = null;
        }

    }

}

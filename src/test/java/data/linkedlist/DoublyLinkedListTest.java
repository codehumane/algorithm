package data.linkedlist;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoublyLinkedListTest {

    @Test
    public void get() {
        val doubly = new DoublyLinkedList();
        assertEquals(-1, doubly.get(0));

        doubly.addAtHead(1);
        assertEquals(1, doubly.get(0));
        assertEquals(-1, doubly.get(1));

        doubly.addAtHead(2);
        assertEquals(2, doubly.get(0));
        assertEquals(1, doubly.get(1));
        assertEquals(-1, doubly.get(2));

        doubly.addAtHead(3);
        assertEquals(3, doubly.get(0));
        assertEquals(2, doubly.get(1));
        assertEquals(1, doubly.get(2));
        assertEquals(-1, doubly.get(3));
    }

    @Test
    public void addAtHead() {
        val doubly = new DoublyLinkedList();
        doubly.addAtHead(1);
        doubly.addAtHead(2);
        doubly.addAtHead(3);

        assertEquals(3, doubly.get(0));
        assertEquals(2, doubly.get(1));
        assertEquals(1, doubly.get(2));
    }

    @Test
    public void addAtTail() {
        val doubly = new DoublyLinkedList();

        doubly.addAtTail(1);
        assertEquals(1, doubly.get(0));

        doubly.addAtTail(2);
        assertEquals(1, doubly.get(0));
        assertEquals(2, doubly.get(1));

        doubly.addAtTail(3);
        assertEquals(1, doubly.get(0));
        assertEquals(2, doubly.get(1));
        assertEquals(3, doubly.get(2));
    }

    @Test
    public void addAtIndex() {
        val doubly = new DoublyLinkedList();
        doubly.addAtTail(1); // 1
        doubly.addAtTail(2); // 1->2
        doubly.addAtTail(3); // 1->2->3

        doubly.addAtIndex(0, 4); // 4->1->2->3
        assertEquals(4, doubly.get(0));
        assertEquals(1, doubly.get(1));
        assertEquals(2, doubly.get(2));
        assertEquals(3, doubly.get(3));
        assertEquals(-1, doubly.get(4));

        doubly.addAtIndex(2, 5); // 4->1->5->2->3
        assertEquals(4, doubly.get(0));
        assertEquals(1, doubly.get(1));
        assertEquals(5, doubly.get(2));
        assertEquals(2, doubly.get(3));
        assertEquals(3, doubly.get(4));
        assertEquals(-1, doubly.get(5));

        doubly.addAtIndex(5, 6); // 4->1->5->2->3->6
        assertEquals(4, doubly.get(0));
        assertEquals(1, doubly.get(1));
        assertEquals(5, doubly.get(2));
        assertEquals(2, doubly.get(3));
        assertEquals(3, doubly.get(4));
        assertEquals(6, doubly.get(5));
        assertEquals(-1, doubly.get(6));

        doubly.addAtIndex(7, 6); // 4->1->5->2->3->6
        assertEquals(4, doubly.get(0));
        assertEquals(1, doubly.get(1));
        assertEquals(5, doubly.get(2));
        assertEquals(2, doubly.get(3));
        assertEquals(3, doubly.get(4));
        assertEquals(6, doubly.get(5));
        assertEquals(-1, doubly.get(6));
    }

    @Test
    public void deleteAtIndex() {
        val doubly = new DoublyLinkedList();
        doubly.addAtTail(1); // 1
        doubly.addAtTail(2); // 1->2
        doubly.addAtTail(3); // 1->2->3
        doubly.addAtIndex(0, 4); // 4->1->2->3
        doubly.addAtIndex(2, 5); // 4->1->5->2->3
        doubly.addAtIndex(5, 6); // 4->1->5->2->3->6

        doubly.deleteAtIndex(0); // 1->5->2->3->6
        assertEquals(1, doubly.get(0));
        assertEquals(5, doubly.get(1));
        assertEquals(2, doubly.get(2));
        assertEquals(3, doubly.get(3));
        assertEquals(6, doubly.get(4));
        assertEquals(-1, doubly.get(5));

        doubly.deleteAtIndex(4); // 1->5->2->3
        assertEquals(1, doubly.get(0));
        assertEquals(5, doubly.get(1));
        assertEquals(2, doubly.get(2));
        assertEquals(3, doubly.get(3));
        assertEquals(-1, doubly.get(4));

        doubly.deleteAtIndex(1); // 1->2->3
        assertEquals(1, doubly.get(0));
        assertEquals(2, doubly.get(1));
        assertEquals(3, doubly.get(2));
        assertEquals(-1, doubly.get(3));

        doubly.deleteAtIndex(3); // 1->2->3
        assertEquals(1, doubly.get(0));
        assertEquals(2, doubly.get(1));
        assertEquals(3, doubly.get(2));
        assertEquals(-1, doubly.get(3));

        doubly.deleteAtIndex(0); // 2->3
        doubly.deleteAtIndex(0); // 3
        doubly.deleteAtIndex(0); // null
        assertEquals(-1, doubly.get(0));
        assertEquals(-1, doubly.get(1));
    }

    @Test
    public void submitFailed() {
        val doubly = new DoublyLinkedList();
        doubly.addAtHead(38);
        doubly.addAtTail(66);
        doubly.addAtTail(61);
        doubly.addAtTail(76);
        doubly.addAtTail(26);
        doubly.addAtTail(37);
        doubly.addAtTail(8);
        doubly.deleteAtIndex(5);
        doubly.addAtHead(4);
        doubly.addAtHead(45);
        assertEquals(61, doubly.get(4));
        doubly.addAtTail(85);
        doubly.addAtHead(37);
        assertEquals(61, doubly.get(5));
        doubly.addAtTail(93);
        doubly.addAtIndex(10, 23);
        doubly.addAtTail(21);
        doubly.addAtHead(52);
        doubly.addAtHead(15);
        doubly.addAtHead(47);
        assertEquals(85, doubly.get(12));
        doubly.addAtIndex(6, 24);
        doubly.addAtHead(64);
        assertEquals(37, doubly.get(4));
        doubly.addAtHead(31);
        doubly.deleteAtIndex(6);
        doubly.addAtHead(40);
        doubly.addAtTail(17);
        doubly.addAtTail(15);
        doubly.addAtIndex(19, 2);
        doubly.addAtTail(11);
        doubly.addAtHead(86);
        assertEquals(23, doubly.get(17));
        doubly.addAtTail(55);
        doubly.deleteAtIndex(15);
        doubly.addAtIndex(14, 95);
        doubly.deleteAtIndex(22);
        doubly.addAtHead(66);
        doubly.addAtTail(95);
        doubly.addAtHead(8);
        doubly.addAtHead(47);
        doubly.addAtTail(23);
        doubly.addAtTail(39);
        assertEquals(-1, doubly.get(30));
        assertEquals(95, doubly.get(27));
        doubly.addAtHead(0);
        doubly.addAtTail(99);
        doubly.addAtTail(45);
        doubly.addAtTail(4);
        doubly.addAtIndex(9, 11);
        assertEquals(31, doubly.get(6));
        doubly.addAtHead(81);
        doubly.addAtIndex(18, 32);
        doubly.addAtHead(20);
        doubly.addAtTail(13);
        doubly.addAtTail(42);
        doubly.addAtIndex(37, 91);
        doubly.deleteAtIndex(36);
        doubly.addAtIndex(10, 37);
        doubly.addAtHead(96);
        doubly.addAtHead(57);
        doubly.deleteAtIndex(20);
        doubly.addAtTail(89);
        doubly.deleteAtIndex(18);
        doubly.addAtIndex(41, 5);
        doubly.addAtTail(23);
        doubly.addAtHead(75);
        assertEquals(8, doubly.get(7));
        doubly.addAtIndex(25, 51);
        doubly.addAtTail(48);
        doubly.addAtHead(46);
        doubly.addAtHead(29);
        doubly.addAtHead(85);
        doubly.addAtHead(82);
        doubly.addAtHead(6);
        doubly.addAtHead(38);
        doubly.deleteAtIndex(14);
        assertEquals(6, doubly.get(1));
        assertEquals(47, doubly.get(12));
        doubly.addAtHead(42);
        assertEquals(23, doubly.get(42));
        doubly.addAtTail(83);
        doubly.addAtTail(13);
        doubly.addAtIndex(14, 20);
        doubly.addAtIndex(17, 34);
        doubly.addAtHead(36);
        doubly.addAtTail(58);
        doubly.addAtTail(2);
        assertEquals(93, doubly.get(38));
        doubly.addAtIndex(33, 59);
        doubly.addAtHead(37);
        doubly.deleteAtIndex(15);
        doubly.addAtTail(64);
        assertEquals(48, doubly.get(56));
        doubly.addAtHead(0);
        assertEquals(93, doubly.get(40));
        doubly.addAtHead(92);
        doubly.deleteAtIndex(63);
        assertEquals(59, doubly.get(35));
        doubly.addAtTail(62);
        doubly.addAtTail(32);
    }

}
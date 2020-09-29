package linkedlist;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddTwoNumbersTest {

    @Test
    public void addTwoNumbersExample1() {

        // given: 342 + 465 = 807
        val numA1 = new ListNode(2);
        val numA2 = new ListNode(4);
        val numA3 = new ListNode(3);
        val numB1 = new ListNode(5);
        val numB2 = new ListNode(6);
        val numB3 = new ListNode(4);
        numA1.next = numA2;
        numA2.next = numA3;
        numB1.next = numB2;
        numB2.next = numB3;

        // when
        val added = new AddTwoNumbers().addTwoNumbers(numA1, numB1);

        // then
        assertEquals(7, added.val);
        assertEquals(0, added.next.val);
        assertEquals(8, added.next.next.val);
    }

    @Test
    public void addTwoNumbersCustom1() {

        // given: 3 + 47 = 50
        val numA1 = new ListNode(3);
        val numB1 = new ListNode(7);
        val numB2 = new ListNode(4);
        numB1.next = numB2;

        // when
        val added = new AddTwoNumbers().addTwoNumbers(numA1, numB1);

        // then
        assertEquals(0, added.val);
        assertEquals(5, added.next.val);
    }

    @Test
    public void addTwoNumbersCustom2() {

        // given: 3 + 7 = 10
        val numA1 = new ListNode(3);
        val numB1 = new ListNode(7);

        // when
        val added = new AddTwoNumbers().addTwoNumbers(numA1, numB1);

        // then
        assertEquals(0, added.val);
        assertEquals(1, added.next.val);
    }

}
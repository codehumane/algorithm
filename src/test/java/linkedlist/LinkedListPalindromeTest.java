package linkedlist;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkedListPalindromeTest {

    @Test
    public void isPalindromeExample1() {

        // given: 1->2
        val node1 = new ListNode(1);
        val node2 = new ListNode(2);
        node1.next = node2;

        // when
        val isPalindrome = new LinkedListPalindrome().isPalindrome(node1);

        // then
        assertFalse(isPalindrome);
    }

    @Test
    public void isPalindromeExample2() {

        // given: 1->2->2->1
        val node1 = new ListNode(1);
        val node2 = new ListNode(2);
        val node3 = new ListNode(2);
        val node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // when
        val isPalindrome = new LinkedListPalindrome().isPalindrome(node1);

        // then
        assertTrue(isPalindrome);
    }

    @Test
    public void isPalindromeCustom1() {

        // given: 1->2
        val node1 = new ListNode(1);
        val node2 = new ListNode(2);
        val node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;

        // when
        val isPalindrome = new LinkedListPalindrome().isPalindrome(node1);

        // then
        assertTrue(isPalindrome);
    }

    @Test
    public void isPalindromeCustom2() {

        // given: 1
        val node1 = new ListNode(1);

        // when
        val isPalindrome = new LinkedListPalindrome().isPalindrome(node1);

        // then
        assertTrue(isPalindrome);
    }

    @Test
    public void isPalindromeCustom3() {

        // when
        val isPalindrome = new LinkedListPalindrome().isPalindrome(null);

        // then
        assertTrue(isPalindrome);
    }
}
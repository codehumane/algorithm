package quiz.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).<br/>
 * <br/>
 * Notes:<br/>
 * <br/>
 * 1. You must use only standard operations of a stack,
 * which means only push to top, peek/pop from top, size, and is empty operations are valid.<br/>
 * <p>
 * 2. Depending on your language,
 * the stack may not be supported natively.
 * You may simulate a stack using a list or deque (double-ended queue)
 * as long as you use only a stack's standard operations.<br/>
 * <br/>
 * Follow-up<br/>
 * Can you implement the queue such that each operation is amortized O(1) time complexity?
 * In other words, performing n operations will take overall O(n) time
 * even if one of those operations may take longer.
 * <br/>
 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1386/<br/>
 * <br/>
 */
public class ImplementQueueUsingStacks {

    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Deque<Integer> reversedStack = new ArrayDeque<>();

    public void push(int x) {
        stack.push(x);
    }

    public int pop() throws NoSuchElementException {
        return retrieveFloor(true);
    }

    public int peek() throws NoSuchElementException {
        return retrieveFloor(false);
    }

    private int retrieveFloor(boolean removal) throws NoSuchElementException {

        while (!stack.isEmpty()) {
            reversedStack.push(stack.pop());
        }

        final Integer element = reversedStack.element();

        if (removal) {
            reversedStack.pop();
        }

        while (!reversedStack.isEmpty()) {
            stack.push(reversedStack.pop());
        }

        return element;
    }

    public boolean empty() {
        return stack.isEmpty();
    }

}

package quiz.stackqueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Implement a last in first out (LIFO) stack using only two queues.
 * The implemented stack should support all the functions of a normal queue (push, top, pop, and empty).<br/>
 * <p>
 * Implement the MyStack class:<br/>
 * <p>
 * - void push(int x) Pushes element x to the top of the stack.<br/>
 * - int pop() Removes the element on the top of the stack and returns it.<br/>
 * - int top() Returns the element on the top of the stack.<br/>
 * - boolean empty() Returns true if the stack is empty, false otherwise.<br/>
 * <br/>
 * Notes:<br/>
 * <br/>
 * - You must use only standard operations of a queue,
 * which means only push to back, peek/pop from front, size, and is empty operations are valid.<br/>
 * - Depending on your language, the queue may not be supported natively.
 * You may simulate a queue using a list or deque (double-ended queue),
 * as long as you use only a queue's standard operations.<br/>
 * <p>
 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1387/<br/>
 * <br/>
 * Constraints:<br/>
 * <br/>
 * - 1 <= x <= 9<br/>
 * - At most 100 calls will be made to push, pop, top, and empty.<br/>
 * - All the calls to pop and top are valid.<br/>
 * <br/>
 * Follow-up:
 * Can you implement the stack such that each operation is amortized O(1) time complexity?
 * In other words, performing n operations will take overall O(n) time
 * even if one of those operations may take longer.
 * You can use more than two queues.
 */
public class ImplementStackUsingQueues {

    private final Queue<Integer> queue1 = new ArrayDeque<>();
    private final Queue<Integer> queue2 = new ArrayDeque<>();

    public void push(int x) {
        queue1.offer(x);
    }

    public int pop() {
        return top(true);
    }

    public int top() {
        return top(false);
    }

    private int top(boolean removal) {
        if (queue1.isEmpty()) {
            throw new IllegalStateException();
        }

        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }

        final Integer top;
        if (removal) {
            top = queue1.poll();
        } else {
            top = queue1.peek();
            queue2.offer(queue1.poll());
        }

        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }

        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

}

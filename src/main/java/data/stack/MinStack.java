package data.stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.<br/>
 * <br/>
 * Implement the MinStack class:<br/>
 * <br/>
 * - MinStack() initializes the stack object.<br/>
 * - void push(val) pushes the element val onto the stack.<br/>
 * - void pop() removes the element on the top of the stack.<br/>
 * - int top() gets the top element of the stack.<br/>
 * - int getMin() retrieves the minimum element in the stack.<br/>
 * <br/>
 * Constraints:<br/>
 * - -2^31 <= val <= 2^31 - 1<br/>
 * - Methods pop, top and getMin operations will always be called on non-empty stacks.<br/>
 * - At most 3 * 10^4 calls will be made to push, pop, top, and getMin.<br/>
 * <br/>
 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1360/
 */
public class MinStack {

    // "At most 3 * 10^4 calls will be made to push, pop, top, and getMin" 제약 내용 따른 최대 capacity 지정
    private final int maxCapacity = 3 * (int) Math.pow(10d, 4d);
    private final Node[] data;
    private int top = -1;

    public MinStack() {
        data = new Node[maxCapacity];
    }

    public void push(int val) {
        if (top >= maxCapacity) throw new IllegalStateException();
        final int min = top == -1 ? val : Math.min(val, data[top].min);
        data[++top] = new Node(val, min);
    }

    public void pop() {
        if (top < 0) throw new IllegalStateException();
        top--;
    }

    public int top() {
        if (top < 0 || top >= maxCapacity) throw new IllegalStateException();
        return data[top].value;
    }

    public int getMin() {
        return data[top].min;
    }

    static class Node {

        final int value;
        final int min;

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }

    }

}

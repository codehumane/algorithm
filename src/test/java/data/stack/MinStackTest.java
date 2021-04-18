package data.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinStackTest {

    @Test
    public void example1() {
        final MinStack minStack = new MinStack();

        minStack.push(-2);
        assertEquals(-2, minStack.top());
        assertEquals(-2, minStack.getMin());

        minStack.push(0);
        assertEquals(0, minStack.top());
        assertEquals(-2, minStack.getMin());

        minStack.push(-3);
        assertEquals(-3, minStack.top());
        assertEquals(-3, minStack.getMin());

        minStack.pop();
        assertEquals(0, minStack.top());
        assertEquals(-2, minStack.getMin());
    }

}
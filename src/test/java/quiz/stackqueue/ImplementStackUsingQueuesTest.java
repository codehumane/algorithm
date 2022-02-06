package quiz.stackqueue;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ImplementStackUsingQueuesTest {

    @Test
    public void example1() {
        val myStack = new ImplementStackUsingQueues();

        myStack.push(1);
        assertEquals(1, myStack.top());

        myStack.push(2);
        assertEquals(2, myStack.top());
        assertEquals(2, myStack.pop());
        assertFalse(myStack.empty());

        assertEquals(1, myStack.pop());
        assertTrue(myStack.empty());

        myStack.push(3);
        assertEquals(3, myStack.top());
        assertFalse(myStack.empty());

        myStack.push(4);
        assertEquals(4, myStack.top());
        assertFalse(myStack.empty());

        assertEquals(4, myStack.pop());
        assertEquals(3, myStack.top());

        myStack.push(5);
        assertEquals(5, myStack.top());
    }

}
package quiz.stackqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ImplementQueueUsingStacksTest {

    private final ImplementQueueUsingStacks solution = new ImplementQueueUsingStacks();

    @Test
    public void example() {
        solution.push(1);
        solution.push(2);
        assertEquals(1, solution.peek());
        assertEquals(1, solution.pop());
        assertFalse(solution.empty());
    }

}
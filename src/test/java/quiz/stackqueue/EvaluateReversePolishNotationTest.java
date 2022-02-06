package quiz.stackqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvaluateReversePolishNotationTest {

    private final EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();

    @Test
    public void example1() {
        final String[] tokens = {"2", "1", "+", "3", "*"};
        final int result = solution.evalRPN(tokens);
        assertEquals(9, result);
    }

    @Test
    public void example2() {
        final String[] tokens = {"4", "13", "5", "/", "+"};
        final int result = solution.evalRPN(tokens);
        assertEquals(6, result);
    }

    @Test
    public void example3() {
        final String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        final int result = solution.evalRPN(tokens);
        assertEquals(22, result);
    }

    @Test
    public void customs() {
        assertEquals(2, solution.evalRPN(new String[]{"2", "1", "/"}));
        assertEquals(3, solution.evalRPN(new String[]{"2", "1", "+"}));
        assertEquals(1, solution.evalRPN(new String[]{"2", "1", "-"}));
        assertEquals(2, solution.evalRPN(new String[]{"2", "1", "*"}));
    }

}
package quiz.stack;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParenthesesTest {

    private final ValidParentheses solution = new ValidParentheses();

    @Test
    public void examples() {
        assertTrue(solution.isValid("()"));
        assertTrue(solution.isValid("()[]{}"));
        assertFalse(solution.isValid("(]"));
        assertFalse(solution.isValid("([)]"));
        assertTrue(solution.isValid("{[]}"));
    }

    @Test
    public void custom() {
        assertFalse(solution.isValid("("));
        assertFalse(solution.isValid(")"));
        assertFalse(solution.isValid("()("));
        assertFalse(solution.isValid("((("));
        assertFalse(solution.isValid(")))"));
        assertTrue(solution.isValid("((())){}"));
    }

}
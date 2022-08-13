package quiz.dynamic;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumRemoveToMakeValidParenthesesTest {

    private final MinimumRemoveToMakeValidParentheses solution = new MinimumRemoveToMakeValidParentheses();

    @Test
    void example1() {
        val input = "lee(t(c)o)de)";
        val output = "lee(t(c)o)de";
        val actual = solution.minRemoveToMakeValid(input);
        assertEquals(output, actual);
    }

    @Test
    void example2() {
        val input = "a)b(c)d";
        val output = "ab(c)d";
        val actual = solution.minRemoveToMakeValid(input);
        assertEquals(output, actual);
    }

    @Test
    void example3() {
        val input = "))((";
        val output = "";
        val actual = solution.minRemoveToMakeValid(input);
        assertEquals(output, actual);
    }

}
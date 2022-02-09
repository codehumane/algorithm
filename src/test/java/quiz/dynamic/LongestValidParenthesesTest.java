package quiz.dynamic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestValidParenthesesTest {

    private final LongestValidParentheses solution = new LongestValidParentheses();

    @ParameterizedTest
    @CsvSource({
            "((),2",
            ")()()),4",
            ",0"
    })
    void examples(String input, int output) {
        assertEquals(output, solution.longestValidParentheses(input == null ? "" : input));
    }

    @ParameterizedTest
    @CsvSource({
            "(,0",
            "),0",
            "((,0",
            "(),2",
            ")(,0",
            ")),0"
    })
    void basic(String input, int output) {
        assertEquals(output, solution.longestValidParentheses(input));
    }

    @ParameterizedTest
    @CsvSource({
            "()(),4",
            "()((),2",
            "((())),6",
            "((()))(),8",
            "((()((,2",
            "((()(),4",
            ")((()))(,6"
    })
    void advanced(String input, int output) {
        assertEquals(output, solution.longestValidParentheses(input));
    }
}
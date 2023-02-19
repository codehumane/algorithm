package quiz.etc;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LetterCombinationsOfAPhoneNumberTest {

    private final LetterCombinationsOfAPhoneNumber solution = new LetterCombinationsOfAPhoneNumber();

    @Test
    void example1() {
        var input = "23";
        var expected = Set.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        var result = new HashSet<>(solution.letterCombinations(input));
        assertEquals(expected, result);
    }

    @Test
    void example2() {
        var input = "";
        var expected = Set.of();
        var result = new HashSet<>(solution.letterCombinations(input));
        assertEquals(expected, result);
    }

    @Test
    void example3() {
        var input = "2";
        var expected = Set.of("a", "b", "c");
        var result = new HashSet<>(solution.letterCombinations(input));
        assertEquals(expected, result);
    }

    @Test
    void custom1() {
        var input = "1";
        var expected = Set.of();
        var result = new HashSet<>(solution.letterCombinations(input));
        assertEquals(expected, result);
    }

    @Test
    void custom2() {
        var input = "123";
        var expected = Set.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        var result = new HashSet<>(solution.letterCombinations(input));
        assertEquals(expected, result);
    }

    @Test
    void custom3() {
        var input = "231";
        var expected = Set.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        var result = new HashSet<>(solution.letterCombinations(input));
        assertEquals(expected, result);
    }

    @Test
    void custom4() {
        var input = "213";
        var expected = Set.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        var result = new HashSet<>(solution.letterCombinations(input));
        assertEquals(expected, result);
    }


}
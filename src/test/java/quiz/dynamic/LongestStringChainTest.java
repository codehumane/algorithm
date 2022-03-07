package quiz.dynamic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestStringChainTest {

    private LongestStringChain solution = new LongestStringChain();

    @Test
    void example1() {
        var expected = 4;
        var words = new String[]{"a", "b", "ba", "bca", "bda", "bdca"};
        var result = solution.longestStrChain(words);
        assertEquals(expected, result);
    }

    @Test
    void example2() {
        var expected = 5;
        var words = new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        var result = solution.longestStrChain(words);
        assertEquals(expected, result);
    }

    @Test
    void example3() {
        var expected = 1;
        var words = new String[]{"abcd", "dbqca"};
        var result = solution.longestStrChain(words);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            " 1 | a ",
            " 1 | a,a ",
            " 1 | a,b ",
            " 2 | a,ab ",
            " 2 | a,ba ",
            " 1 | a,abc ",
            " 1 | a,abcd ",
    }, delimiter = '|')
    void custom1(int expected, String words) {
        assertEquals(expected, solution.longestStrChain(words.split(",")));
    }

    @ParameterizedTest
    @CsvSource(value = {
            " 4 | a,b,c,ba,bac,ac,bdac ",
            " 2 | c,b,a,ddd,dddc "
    }, delimiter = '|')
    void custom2(int expected, String words) {
        assertEquals(expected, solution.longestStrChain(words.split(",")));
    }

    @ParameterizedTest
    @CsvSource({
            "false, a, a",
            "false, a, b",
            "false, a, bb",
            "true, a, aa",
            "true, a, ab",
            "true, a, ba",

            "true, xbc, cxbc",
            "true, aba, abba",
            "true, aba, abab",
            "true, aba, abaa",
            "true, aba, aaba",
            "true, aba, abba",
    })
    void isPredecessor(boolean expected, String s1, String s2) {
        assertEquals(expected, solution.isPredecessor(s1, s2));
    }

}
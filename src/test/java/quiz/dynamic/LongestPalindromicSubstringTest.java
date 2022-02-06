package quiz.dynamic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPalindromicSubstringTest {

    private final LongestPalindromicSubstring solution = new LongestPalindromicSubstring();

    @ParameterizedTest
    @CsvSource({
            "babad,bab",
            "cbbd,bb"
    })
    public void examples(String input, String output) {
        var result = solution.longestPalindrome(input);
        assertEquals(output, result);
    }

    @ParameterizedTest
    @CsvSource({
            "a,a",
            "aa,aa",
            "ab,a",
            "aba,aba",
            "abba,abba",
            "abcba,abcba",
            "abcb,bcb",
            "abbb,bbb",
            "bbba,bbb",
            "bbabbbb,bbabb",
            "abbba,abbba",
            "aabaa,aabaa"
    })
    public void customs(String input, String output) {
        var result = solution.longestPalindrome(input);
        assertEquals(output, result);
    }

}
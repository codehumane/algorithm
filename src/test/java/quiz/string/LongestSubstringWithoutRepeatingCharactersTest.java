package quiz.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringWithoutRepeatingCharactersTest {

    private final LongestSubstringWithoutRepeatingCharacters solution =
            new LongestSubstringWithoutRepeatingCharacters();

    @ParameterizedTest
    @CsvSource(value = {
            // example
            "3,abcabcbb",
            "1,bbbbb",
            "3,pwwkew",
            "1,' '", // blank string " "
            "1,b",
            "3,aaabc",
            "3,dvdf",
            "2,abba"
    })
    public void verify(int output, String input) {
        var actual = solution.lengthOfLongestSubstring(input);
        assertEquals(output, actual);
    }

}
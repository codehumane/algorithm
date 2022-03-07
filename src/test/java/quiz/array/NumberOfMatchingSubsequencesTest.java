package quiz.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import quiz.array.NumberOfMatchingSubsequences.MatchingWordUniquely;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfMatchingSubsequencesTest {

    private final NumberOfMatchingSubsequences solution = new NumberOfMatchingSubsequences();

    @ParameterizedTest
    @CsvSource(value = {

            " abcde      | a,bb,acd,ace                     | 3 ", // There are three strings in words that are a subsequence of s: "a", "acd", "ace"
            " dsahjpjauf | ahjpjau,ja,ahbwzgqnuk,tnmlanowax | 2 "

    }, delimiter = '|')
    void examples(String s, String words, int expected) {
        assertEquals(expected, solution.numMatchingSubseq(s, words.split(",")));
    }

    @ParameterizedTest
    @CsvSource(value = {
            " a  | a  | true  ",
            " aa | a  | true  ",
            " aa | aa | true  ",
            " aa | ab | false ",

            " aaaa | ab | false ",
            " a    | aa | false ",

            " abcde | a   | true  ",
            " abcde | bb  | false ",
            " abcde | acd | true  ",
            " abcde | ace | true  ",

            " dsahjpjauf | ja         | true  ",
            " dsahjpjauf | ahjpjau    | true  ",
            " dsahjpjauf | ahbwzgqnuk | false ",
            " dsahjpjauf | tnmlanowax | false ",
    }, delimiter = '|')
    void isSubsequence(String s, String word, boolean expected) {
        assertEquals(expected, new MatchingWordUniquely().isSubsequence(s, word));
    }

}
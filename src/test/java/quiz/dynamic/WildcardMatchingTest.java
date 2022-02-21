package quiz.dynamic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class WildcardMatchingTest {

    private final WildcardMatching solution = new WildcardMatching();

    @ParameterizedTest
    @CsvSource({
            "a,aa,false",
            "*,aa,true",
            "?a,cb,false"
    })
    public void example(String pattern, String text, boolean expected) {
        verify(pattern, text, expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            " a  |      | false ",
            " a  | a    | true  ",
            " a  | b    | false ",
            " a  | aa   | false ",
            " a  | ab   | false ",

            " ?  |      | false ",
            " ?  | a    | true  ",
            " ?  | b    | true  ",
            " ?  | aa   | false ",
            " ?  | ab   | false ",

            " *  |      | true ",
            " *  | a    | true ",
            " *  | b    | true ",
            " *  | aa   | true ",
            " *  | ab   | true "
    }, delimiter = '|')
    void patternLengthIsOne(String pattern, String text, boolean expected) {
        verify(pattern, text, expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "     | a  | false  ",

            " a   | a  | true   ",
            " b   | a  | false  ",
            " aa  | a  | false  ",
            " ab  | a  | false  ",

            " *   | a  | true  ",
            " *   | b  | true  ",
            " *a  | a  | true  ",
            " *b  | a  | false ",
            " a*  | a  | true  ",
            " b*  | a  | false ",

            " ?   | a  | true  ",
            " ?   | b  | true  ",
            " ??  | a  | false  ",
            " ?a  | a  | false  ",
    }, delimiter = '|')
    void textLengthIsOne(String pattern, String text, boolean expected) {
        verify(pattern, text, expected);
    }

    @ParameterizedTest
    @CsvSource({
            "m??*ss*?i*pi,mississippi,false",
            "*a*,b,false",
            "******,aa,true",
            "******,a,true",
            "******,,true",
            "*a*b,adceb,true",
            "aa,aa,true"
    })
    void wrong(String pattern, String text, boolean expected) {
        verify(pattern, text, expected);
    }

    @Test
    void timeLimitExceeded() {
        var text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        var pattern = "*aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa*";
        var result = solution.isMatch(text, pattern);
        assertFalse(result);
    }

    private void verify(String pattern, String text, boolean expected) {
        final String t = text == null ? "" : text;
        final String p = pattern == null ? "" : pattern;
        final boolean result = solution.isMatch(t, p);
        assertEquals(expected, result);
    }

}
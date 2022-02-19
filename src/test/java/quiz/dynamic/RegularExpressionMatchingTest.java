package quiz.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class RegularExpressionMatchingTest {

    private final RegularExpressionMatching solution = new RegularExpressionMatching();

    @ParameterizedTest
    @CsvSource({
            "false,aa,a",
            "true,aa,a*",
            "true,ab,.*"
    })
    public void example(boolean expected, String s, String p) {
        assertEquals(expected, solution.isMatch(s, p));
    }

    @ParameterizedTest
    @CsvSource({
            "true,aab,c*a*b",
            "false,mississippi,mis*is*p*."
    })
    void wrong(boolean expected, String s, String p) {
        assertEquals(expected, solution.isMatch(s, p));
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "a      |        | false    ",
                    "a      | a      | true     ",
                    "a      | aa     | false    ",
                    "a      | b      | false    ",
                    "a      | ba     | false    ",
                    "a      | ab     | false    ",

                    "a*     |        | true     ",
                    "a*     | a      | true     ",
                    "a*     | aa     | true     ",
                    "a*     | b      | false    ",
                    "a*     | ab     | false    ",

                    "a*b    | b      | true     ",
                    "a*b    | ab     | true     ",
                    "a*b    | aab    | true     ",
                    "a*b    | aac    | false    ",
                    "a*b    | aaa    | false    ",
                    "a*b    | a      | false    ",
                    "a*b    | abc    | false    ",

                    "a*a    |        | false    ",
                    "a*a    | a      | true     ",
                    "a*a    | aa     | true     ",
                    "a*a    | aaa    | true     ",
                    "a*a    | aab    | false    ",
                    "a*a    | ab     | false    ",
                    "a*a    | b      | false    ",
                    "a*a    | aba    | false    ",
                    "a*a    | abcca  | false    ",

                    ".      | a      | true     ",
                    ".      | b      | true     ",
                    ".      | ba     | false    ",
                    ".      |        | false    ",

                    "a.     | a      | false    ",
                    "a.     | aa     | true     ",
                    "a.     | ab     | true     ",
                    "a.     | ba     | false    ",

                    ".*     |        | true     ",
                    ".*     | a      | true     ",
                    ".*     | b      | true     ",
                    ".*     | aa     | true     ",
                    ".*     | ab     | true     ",

                    ".*a    |        | false    ",
                    ".*a    | a      | true     ",
                    ".*a    | ba     | true     ",
                    ".*a    | aa     | true     ",
                    ".*a    | bba    | true     ",

                    "a.*b   |        | false    ",
                    "a.*b   | ac     | false    ",
                    "a.*b   | cb     | false    ",
                    "a.*b   | ba     | false    ",
                    "a.*b   | cab    | false    ",
                    "a.*b   | baa    | false    ",
                    "a.*b   | ab     | true     ",
                    "a.*b   | acb    | true     ",
                    "a.*b   | aab    | true     ",
                    "a.*b   | abb    | true     ",
            },
            delimiter = '|'
    )
    void sub(String p, String s, boolean expected) {
        assertEquals(expected, solution.isMatch(s == null ? "" : s, p));
    }

}
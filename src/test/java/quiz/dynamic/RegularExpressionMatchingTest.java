package quiz.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
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
            "true,a,a",
            "false,a,c",
            "false,a,ab",
            "false,a,aa",
            "false,a,bb",
            "false,ab,a",
            "false,aa,a",
            "false,bb,a",
            "true,aa,aa",
            "true,bb,bb"
    })
    public void custom_pure(boolean expected, String s, String p) {
        assertEquals(expected, solution.isMatch(s, p));
    }

    @ParameterizedTest
    @CsvSource({
            "true,a,a*",
            "true,aa,a*",
            "true,aaa,a*",
            "false,b,a*",
            "true,aaaba,a*aa*a*",
            "true,aaabaa,a*aa*a*",
            "true,aaabaaa,a*aa*a*"
    })
    public void custom_endsWithAsterisk(boolean expected, String s, String p) {
        assertEquals(expected, solution.isMatch(s, p));
    }

    @ParameterizedTest
    @CsvSource({
            "true,a,.",
            "true,ab,a.",
            "true,ab,.b",
            "true,ab,..",
            "false,ab,.",
            "false,a,..",
            "true,aba,.b.",
            "true,abbaba,a..a.a",
            "false,abbaba,a..a.b"
    })
    public void custom_dot(boolean expected, String s, String p) {
        assertEquals(expected, solution.isMatch(s, p));
    }

    @ParameterizedTest
    @CsvSource({
            "true,aaaaaab,a*a...*ab*",
            "true,aabbbab,a*a...*ab*",
            "true,ababbbaab,a*a...*ab*",
            "true,aaaaaaaab,a*a...*ab*",
            "true,aaaaaabcc,a*a...*ab*",
            "true,aabbbabcc,a*a...*ab*",
            "true,ababbbaabcc,a*a...*ab*",
            "true,aaaaaaaabcc,a*a...*ab*",
            "false,abbbbab,a*a...*ab*",
    })
    public void complicated(boolean expected, String s, String p) {
        assertEquals(expected, solution.isMatch(s, p));
    }

    @ParameterizedTest
    @CsvSource({
            "true,aab,c*a*b"
    })
    void wrong(boolean expected, String s, String p) {
        assertEquals(expected, solution.isMatch(s, p));
    }

}
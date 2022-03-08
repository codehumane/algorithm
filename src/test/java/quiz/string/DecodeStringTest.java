package quiz.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class DecodeStringTest {

    private final DecodeString solution = new DecodeString();

    @ParameterizedTest
    @CsvSource({
            " 3[a]2[bc]     , aaabcbc ",
            " 3[a2[c]]      , accaccacc ",
            " 2[abc]3[cd]ef , abcabccdcdcdef "
    })
    void examples(String input, String expected) {
        assertEquals(expected, solution.decodeString(input));
    }

    @ParameterizedTest
    @CsvSource({
            " a                , a ",
            " aa               , aa ",
            " 1[a]             , a ",
            " 11[ab]           , ababababababababababab ",
            " 1[a]bb10[a]      , abbaaaaaaaaaa ",
            " 2[a3[bb]]        , abbbbbbabbbbbb ",
            " 2[aa2[b]a2[b]]aa , aabbabbaabbabbaa"
    })
    void customs(String input, String expected) {
        assertEquals(expected, solution.decodeString(input));
    }

}
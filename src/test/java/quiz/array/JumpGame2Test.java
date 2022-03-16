package quiz.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JumpGame2Test {

    private final JumpGame2 solution = new JumpGame2();

    @ParameterizedTest
    @CsvSource(value = {
            " 2,3,1,1,4 | 2 ",
            " 2,3,0,1,4 | 2 "
    }, delimiter = '|')
    void examples(String input, int expected) {
        var result = solution.jump(toIntArray(input));
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            " 2,4,0,9     | 2 ",
            " 3,2,1,1,1,0 | 3 "
    }, delimiter = '|')
    void custom(String input, int expected) {
        var result = solution.jump(toIntArray(input));
        assertEquals(expected, result);
    }

    private int[] toIntArray(String input) {
        return Arrays
                .stream(input.split(","))
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}
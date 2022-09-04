package quiz.etc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrappingRainWaterTest {

    private final TrappingRainWater solution = new TrappingRainWater();

    @ParameterizedTest
    @CsvSource(value = {

            // examples
            "0,1,0,2,1,0,1,3,2,1,2,1 | 6",
            "4,2,0,3,2,5 | 9",

            // custom
            "1     | 0",
            "1,1   | 0",
            "2,1   | 0",
            "1,2   | 0",
            "1,2,1 | 0",
            "1,2,2 | 0",
            "2,2,1 | 0",
            "2,1,2 | 1",
            "3,1,2 | 1",
            "2,1,3 | 1",
            "3,1,3 | 2",
            "4,1,3 | 2",
            "4,1,3,3 | 2",
            "4,1,3,3,3,3,3,1 | 2",
            "4,1,3,3,3,3,3,1,5 | 11",

            // wrong
            "5,4,1,2 | 1",
            "5,3,7,7 | 2"

    }, delimiter = '|')
    void examples(String input, int output) {
        assertEquals(output, solution.trap(toIntArray(input)));
    }

    private int[] toIntArray(String input) {

        return Arrays
                .stream(input.split(","))
                .mapToInt(Integer::valueOf)
                .toArray();
    }

}
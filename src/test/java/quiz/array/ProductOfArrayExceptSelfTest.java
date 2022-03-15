package quiz.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductOfArrayExceptSelfTest {

    private final ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

    @ParameterizedTest
    @CsvSource(value = {
            " 1,2,3,4 | 24,12,8,6 ",
            " -1,1,0,-3,3 | 0,0,9,0,0 "
    }, delimiter = '|')
    void examples(String input, String output) {
        var expected = toIntArray(output);
        var result = solution.productExceptSelf(toIntArray(input));
        assertArrayEquals(expected, result);
    }

    private int[] toIntArray(String input) {
        return Arrays
                .stream(input.split(","))
                .mapToInt(Integer::valueOf)
                .toArray();
    }

}
package quiz.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumSizeSubarraySumTest {

    private final MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();

    @ParameterizedTest
    @CsvSource(value = {
            " 7     | 2,3,1,2,4,3       | 2 ",
            " 4     | 1,4,4             | 1 ",
            " 11    | 1,1,1,1,1,1,1,1   | 0 ",
    }, delimiter = '|')
    void examples(int target, String nums, int expected) {

        var input = Arrays
                .stream(nums.split(","))
                .mapToInt(Integer::valueOf)
                .toArray();

        var result = solution.minSubArrayLen(target, input);
        assertEquals(expected, result);
    }

}
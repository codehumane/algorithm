package quiz.dynamic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSubarrayTest {

    @ParameterizedTest
    @CsvSource(value = {

            // custom
            " 11 | -2,-3,4,5,-1,3,-20,1 ",
            "  7 | -2,-3,4,-1,-2,1,5,-3 ",
            " -1 | -1 ",
            " -1 | -1,-2 ",
            " -1 | -2,-1 ",
            "  1 | -1,1 ",
            "  0 | -1,0 ",
            "  0 | 0 ",

            // example
            "  6 | -2,1,-3,4,-1,2,1,-5,4 ",
            "  1 | 1 ",
            " 23 | 5,4,-1,7,8 "

    }, delimiter = '|')
    void maxSubArray(int expected, String nums) {

        // given
        var input = Arrays
                .stream(nums.split(","))
                .mapToInt(Integer::valueOf)
                .toArray();

        // when
        var result = new MaximumSubarray().maxSubArray(input);

        // then
        assertEquals(expected, result);
    }

}
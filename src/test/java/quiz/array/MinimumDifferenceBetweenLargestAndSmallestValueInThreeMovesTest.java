package quiz.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMovesTest {

    private final MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves solution =
            new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves();

    @ParameterizedTest
    @CsvSource(value = {
            " 5,3,2,4 | 0 ",
            " 1,5,0,10,14 | 1 ",
    }, delimiter = '|')
    void examples(String nums, String output) {
        verify(nums, output);
    }

    @ParameterizedTest
    @CsvSource(value = {
            " 6,6,0,1,1,4,6 | 2 ",
    }, delimiter = '|')
    void wrong(String nums, String output) {
        verify(nums, output);
    }

    private void verify(String nums, String output) {
        var input = Arrays
                .stream(nums.split(","))
                .mapToInt(Integer::valueOf)
                .toArray();

        var expected = Integer.valueOf(output);
        var result = solution.minDifference(input);
        assertEquals(expected, result);
    }

}

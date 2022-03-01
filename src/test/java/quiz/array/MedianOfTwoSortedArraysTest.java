package quiz.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianOfTwoSortedArraysTest {

    private final MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();

    @ParameterizedTest
    @CsvSource(value = {

            // example
            "   2 | 1,3   | 2       ",
            " 2.5 | 1,2   | 3,4     ",

            // custom
            " 2   | 1     | 2,3     ",
            " 2.5 | 1     | 2,3,4   ",
            " 2   | 2,3   | 1       ",
            " 2.5 | 2,3,4 | 1       ",
            " 2   | 2     | 1,3     ",
            " 1   | 1     |         ",
            " 1   |       | 1       ",
            " 1.5 |       | 1,2     ",
            " 0   |       |         "

    }, delimiter = '|')
    public void verify(double expected, String nums1, String nums2) {
        assertEquals(expected, solution.findMedianSortedArrays(toArray(nums1), toArray(nums2)));
    }

    private int[] toArray(String source) {
        if (source == null) return new int[0];

        return Arrays
                .stream(source.split(","))
                .mapToInt(Integer::valueOf)
                .toArray();
    }

}
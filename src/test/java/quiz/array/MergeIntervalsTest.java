package quiz.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MergeIntervalsTest {

    private final MergeIntervals solution = new MergeIntervals();

    @Test
    void example1() {
        var intervals = new int[][]{
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{15, 18},
        };

        var expected = new int[][]{
                new int[]{1, 6},
                new int[]{8, 10},
                new int[]{15, 18}
        };

        verify(intervals, expected);
    }

    @Test
    void example2() {
        var intervals = new int[][]{
                new int[]{1, 4},
                new int[]{4, 5}
        };

        var expected = new int[][]{
                new int[]{1, 5}
        };

        verify(intervals, expected);
    }

    private void verify(int[][] input, int[][] expected) {
        var result = solution.merge(input);

        for (int[] x : result) {
            assertTrue(Arrays.stream(expected).anyMatch(y -> Arrays.equals(x, y)));
        }
    }

}
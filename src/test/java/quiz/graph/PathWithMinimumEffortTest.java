package quiz.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PathWithMinimumEffortTest {

    private final PathWithMinimumEffort solution = new PathWithMinimumEffort();

    @Test
    public void example1() {

        // given
        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        int output = 2;

        // when
        int result = solution.minimumEffortPath(heights);

        // then
        assertEquals(output, result);
    }

    @Test
    public void example2() {

        // given
        int[][] heights = {
                {1, 2, 3},
                {3, 8, 4},
                {5, 3, 5}
        };
        int output = 1;

        // when
        int result = solution.minimumEffortPath(heights);

        // then
        assertEquals(output, result);
    }

    @Test
    public void example3() {

        // given
        int[][] heights = {
                {1, 2, 1, 1, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 1, 1, 2, 1}
        };
        int output = 0;

        // when
        int result = solution.minimumEffortPath(heights);

        // then
        assertEquals(output, result);
    }

}
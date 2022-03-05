package quiz.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumNumberOfPointsWithCostTest {

    private final MaximumNumberOfPointsWithCost solution = new MaximumNumberOfPointsWithCost();

    @Test
    void example1() {

        // given
        var expected = 9;
        var points = new int[][]{
                new int[]{1, 2, 3},
                new int[]{1, 5, 1},
                new int[]{3, 1, 1}
        };

        // when
        var result = solution.maxPoints(points);

        // then
        assertEquals(expected, result);
    }

    @Test
    void example2() {

        // given
        var expected = 11;
        var points = new int[][]{
                new int[]{1, 5},
                new int[]{2, 3},
                new int[]{4, 2}
        };

        // when
        var result = solution.maxPoints(points);

        // then
        assertEquals(expected, result);
    }

    @Test
    void custom1() {

        // given
        var expected = 4;
        var points = new int[][]{
                new int[]{1, 0, 0, 0, 2},
                new int[]{3, 0, 0, 0, 0}
        };

        // when
        var result = solution.maxPoints(points);

        // then
        assertEquals(expected, result);
    }

    @Test
    void custom2() {

        // given
        var expected = 5;
        var points = new int[][]{
                new int[]{1, 3, 0, 0, 2},
                new int[]{3, 0, 0, 0, 0}
        };

        // when
        var result = solution.maxPoints(points);

        // then
        assertEquals(expected, result);
    }

    @Test
    void custom3() {

        // given
        var expected = Integer.MAX_VALUE * 2L;
        var points = new int[][]{
                new int[]{Integer.MAX_VALUE},
                new int[]{Integer.MAX_VALUE}
        };

        // when
        var result = solution.maxPoints(points);

        // then
        assertEquals(expected, result);
    }

}
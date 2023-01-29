package quiz.etc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainerWithMostWaterTest {

    private final ContainerWithMostWater solution = new ContainerWithMostWater();

    @Test
    void example1() {
        var height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        var result = solution.maxArea(height);
        assertEquals(49, result);
    }

    @Test
    void example2() {
        var height = new int[]{1, 1};
        var result = solution.maxArea(height);
        assertEquals(1, result);
    }

    @Test
    void customs() {
        assertEquals(9, solution.maxArea(new int[]{1, 0, 0, 0, 0, 0, 8, 6, 0, 1}));
        assertEquals(9, solution.maxArea(new int[]{1, 0, 0, 0, 0, 0, 9, 10, 0, 1}));
        assertEquals(9, solution.maxArea(new int[]{1, 0, 0, 0, 0, 0, 10, 9, 0, 1}));
        assertEquals(10, solution.maxArea(new int[]{1, 0, 0, 0, 0, 0, 11, 10, 0, 1}));
        assertEquals(11, solution.maxArea(new int[]{1, 0, 0, 0, 0, 0, 11, 11, 0, 1}));
    }

}
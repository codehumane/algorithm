package quiz.etc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeSumClosestTest {

    private final ThreeSumClosest solution = new ThreeSumClosest();

    @Test
    void example1() {
        var target = 1;
        var nums = new int[]{-1, 2, 1, -4};
        var result = solution.threeSumClosest(nums, target);
        assertEquals(2, result);
    }

    @Test
    void example2() {
        var target = 1;
        var nums = new int[]{0, 0, 0};
        var result = solution.threeSumClosest(nums, target);
        assertEquals(0, result);
    }

    @Test
    void custom1() {
        var target = 1;
        var nums = new int[]{-7, -5, -1, 0, 2, 3};
        var result = solution.threeSumClosest(nums, target);
        assertEquals(1, result);
    }

    @Test
    void custom2() {
        var target = 4;
        var nums = new int[]{1, 5, 6, 7};
        var result = solution.threeSumClosest(nums, target);
        assertEquals(12, result);
    }

    @Test
    void wrong1() {
        var target = -101;
        var nums = new int[]{-100, -98, -2, -1};
        var result = solution.threeSumClosest(nums, target);
        assertEquals(-101, result);
    }

}
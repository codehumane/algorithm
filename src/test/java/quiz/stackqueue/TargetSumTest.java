package quiz.stackqueue;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TargetSumTest {

    private final TargetSum solution = new TargetSum();

    @Test
    public void custom1() {
        val nums = new int[]{1, 1};
        val target = 0;
        val expected = 2;
        val count = solution.findTargetSumWays(nums, target);
        assertEquals(expected, count);
    }

    @Test
    public void custom2() {
        val nums = new int[]{1, 1};
        val target = 1;
        val expected = 0;
        val count = solution.findTargetSumWays(nums, target);
        assertEquals(expected, count);
    }

    @Test
    public void custom3() {
        val nums = new int[]{2, 1, 1};
        val target = 2;
        val expected = 2;
        val count = solution.findTargetSumWays(nums, target);
        assertEquals(expected, count);
    }

    @Test
    public void example1() {
        val nums = new int[]{1, 1, 1, 1, 1};
        val target = 3;
        val expected = 5;
        val count = solution.findTargetSumWays(nums, target);
        assertEquals(expected, count);
    }

    @Test
    public void example2() {
        val nums = new int[]{1};
        val target = 1;
        val expected = 1;
        val count = solution.findTargetSumWays(nums, target);
        assertEquals(expected, count);
    }

}
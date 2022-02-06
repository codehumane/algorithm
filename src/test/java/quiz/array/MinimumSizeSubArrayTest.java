package quiz.array;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumSizeSubArrayTest {

    private final MinimumSizeSubArray solution = new MinimumSizeSubArray();

    @Test
    public void example1() {

        // given
        val expected = 2;
        val target = 7;
        val nums = new int[]{2, 3, 1, 2, 4, 3};
        // 2, 3, 1, 2, 4, 3
        //             l
        //                  r
        //             7
        //             2

        // when
        val result = solution.minSubArrayLen(target, nums);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void example2() {

        // given
        val expected = 1;
        val target = 4;
        val nums = new int[]{1, 4, 4};

        // when
        val result = solution.minSubArrayLen(target, nums);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void example3() {

        // given
        val expected = 0;
        val target = 11;
        val nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};

        // when
        val result = solution.minSubArrayLen(target, nums);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void custom1() {

        // given
        val nums = new int[]{1, 1, 4, 3, 2};

        // then
        assertEquals(2, solution.minSubArrayLen(7, nums));
        assertEquals(2, solution.minSubArrayLen(6, nums));
        assertEquals(1, solution.minSubArrayLen(4, nums));
    }

}
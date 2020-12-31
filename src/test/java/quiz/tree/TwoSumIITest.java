package quiz.tree;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TwoSumIITest {

    private final TwoSumII sum = new TwoSumII();

    @Test
    public void example1() {

        // given
        final int target = 9;
        final int[] numbers = {2, 7, 11, 15};
        final int[] expected = {1, 2};

        // when
        final int[] result = sum.twoSum(numbers, target);

        // then
        assertArrayEquals(expected, result);
    }

    @Test
    public void example2() {

        // given
        final int target = 6;
        final int[] numbers = {2, 3, 4};
        final int[] expected = {1, 3};

        // when
        final int[] result = sum.twoSum(numbers, target);

        // then
        assertArrayEquals(expected, result);
    }

    @Test
    public void example3() {

        // given
        final int target = -1;
        final int[] numbers = {-1, 0};
        final int[] expected = {1, 2};

        // when
        final int[] result = sum.twoSum(numbers, target);

        // then
        assertArrayEquals(expected, result);
    }

}
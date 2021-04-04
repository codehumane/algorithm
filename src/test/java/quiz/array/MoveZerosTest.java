package quiz.array;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MoveZerosTest {

    private final MoveZeros solution = new MoveZeros();

    @Test
    public void example1() {

        // given
        val nums = new int[]{0, 1, 0, 3, 12};
        val output = new int[]{1, 3, 12, 0, 0};

        // when
        solution.moveZeroes(nums);

        // then
        assertArrayEquals(output, nums);
    }

    @Test
    public void example2() {

        // given
        val nums = new int[]{0};
        val output = new int[]{0};

        // when
        solution.moveZeroes(nums);

        // then
        assertArrayEquals(output, nums);
    }

    @Test
    public void custom1() {

        // given
        val nums = new int[]{0, 0, 0, 0, 0};
        val output = new int[]{0, 0, 0, 0, 0};

        // when
        solution.moveZeroes(nums);

        // then
        assertArrayEquals(output, nums);
    }

    @Test
    public void custom2() {

        // given
        val nums = new int[]{1, 2, 3, 4};
        val output = new int[]{1, 2, 3, 4};

        // when
        solution.moveZeroes(nums);

        // then
        assertArrayEquals(output, nums);
    }

    @Test
    public void custom3() {

        // given
        val nums = new int[]{1, 2, 3, 4, 0};
        val output = new int[]{1, 2, 3, 4, 0};

        // when
        solution.moveZeroes(nums);

        // then
        assertArrayEquals(output, nums);
    }

    @Test
    public void custom4() {

        // given
        val nums = new int[]{0, 1, 2, 3, 4};
        val output = new int[]{1, 2, 3, 4, 0};

        // when
        solution.moveZeroes(nums);

        // then
        assertArrayEquals(output, nums);
    }


}
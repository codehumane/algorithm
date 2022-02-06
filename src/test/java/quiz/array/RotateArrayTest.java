package quiz.array;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RotateArrayTest {

    private final RotateArray solution = new RotateArray();

    @Test
    public void example1() {
        val nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        val expected = new int[]{5, 6, 7, 1, 2, 3, 4};
        solution.rotate(nums, 3);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void example2() {
        val nums = new int[]{-1, -100, 3, 99};
        val expected = new int[]{3, 99, -1, -100};
        solution.rotate(nums, 2);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void edge1() {
        val nums = new int[]{1};
        val expected = new int[]{1};
        solution.rotate(nums, 0);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void edge2() {
        val nums = new int[]{1};
        val expected = new int[]{1};
        solution.rotate(nums, 1);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void edge3() {
        val nums = new int[]{1, 2};
        val expected = new int[]{1, 2};
        solution.rotate(nums, 2);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void failed1() {
        val nums = new int[]{1, 2};
        val expected = new int[]{2, 1};
        solution.rotate(nums, 3);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void failed2() {
        val nums = new int[]{1, 2, 3, 4, 5, 6};
        val expected = new int[]{3, 4, 5, 6, 1, 2};
        solution.rotate(nums, 4);
        assertArrayEquals(expected, nums);
    }
}
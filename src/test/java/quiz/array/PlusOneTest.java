package quiz.array;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PlusOneTest {

    private final PlusOne plus = new PlusOne();

    @Test
    public void example1() {
        val input = new int[]{1, 2, 3};
        val output = new int[]{1, 2, 4};
        assertArrayEquals(output, plus.plusOne(input));
    }

    @Test
    public void example2() {
        val input = new int[]{4, 3, 2, 1};
        val output = new int[]{4, 3, 2, 2};
        assertArrayEquals(output, plus.plusOne(input));
    }

    @Test
    public void example3() {
        val input = new int[]{0};
        val output = new int[]{1};
        assertArrayEquals(output, plus.plusOne(input));
    }

    @Test
    public void custom1() {
        val input = new int[]{9, 9};
        val output = new int[]{1, 0, 0};
        assertArrayEquals(output, plus.plusOne(input));
    }
}
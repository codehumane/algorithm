package quiz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    private Fibonacci fibonacci;

    @Before
    public void setup() {
        fibonacci = new Fibonacci();
    }

    @Test
    public void run_1을_입력하면_1을_반환한다() throws Exception {
        // Given
        int[] expected = {1};

        // Whens
        int[] result = fibonacci.run(1);

        // Then
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void run_2를_입력하면_11을_반환한다() throws Exception {
        // Given
        int[] expected = {1, 1};

        // Whens
        int[] result = fibonacci.run(2);

        // Then
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void run_3을_입력하면_112를_반환한다() throws Exception {
        // Given
        int[] expected = {1, 1, 2};

        // Whens
        int[] result = fibonacci.run(3);

        // Then
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void run_10을_입력하면_1_1_2_3_5_8_13_21_34_55를_반환한다() throws Exception {
        // Given
        int[] expected = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};

        // Whens
        int[] result = fibonacci.run(10);

        // Then
        Assert.assertArrayEquals(expected, result);
    }
}
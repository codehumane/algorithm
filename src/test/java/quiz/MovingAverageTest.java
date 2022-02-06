package quiz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovingAverageTest {

    private MovingAverage movingAverage = new MovingAverage();

    @Test
    public void normal_case_1() throws Exception {
        // Given
        double[] input = {1, 3, 2, 4};
        double[] expected = {2.0, 2.5, 3};

        // When
        double[] result = movingAverage.computeByLinearTime(input, 2);

        // Then
        Assertions.assertArrayEquals(expected, result, 0.00001);
    }

    @Test
    public void normal_case_2() throws Exception {
        // Given
        double[] input = {3, 1, 6, 0, 2, 5};
        double[] expected = {2, 3.5, 3, 1, 3.5};

        // When
        double[] result = movingAverage.computeByLinearTime(input, 2);

        // Then
        Assertions.assertArrayEquals(expected, result, 0.01);
    }
}

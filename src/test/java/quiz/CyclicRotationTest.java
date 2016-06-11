package quiz;

import org.junit.Assert;
import org.junit.Test;

public class CyclicRotationTest {

    private CyclicRotation rotation = new CyclicRotation();

    @Test
    public void empty_array() throws Exception {
        // Given
        int[] input = new int[0];
        int[] expected = new int[0];

        // When
        int[] result = rotation.execute(input, 3);

        // Then
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void single_element() throws Exception {
        // Given
        int[] input = {1};
        int[] expected = {1};

        // When
        int[] result = rotation.execute(input, 3);

        // Then
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void five_elements_with_index_smaller_than_size() throws Exception {
        // Given
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {3, 4, 5, 1, 2};

        // When
        int[] result = rotation.execute(input, 3);

        // Then
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void five_elements_with_index_bigger_than_size() throws Exception {
        // Given
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {4, 5, 1, 2, 3};

        // When
        int[] result = rotation.execute(input, 7);

        // Then
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void five_elements_with_index_multiples_of_size() throws Exception {
        // Given
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        // When
        int[] result = rotation.execute(input, 20);

        // Then
        Assert.assertArrayEquals(expected, result);
    }
}

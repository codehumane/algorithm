package quiz.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveElementTest {

    private final RemoveElement removeElement = new RemoveElement();

    @Test
    public void example1() {
        final int value = 3;
        final int[] nums = {3, 2, 2, 3};
        final int result = removeElement.removeElement(nums, value);

        assertEquals(2, result);

        for (int i = 0; i < result; i++) {
            assertTrue(Arrays
                    .stream(nums)
                    .boxed()
                    .collect(Collectors.toSet())
                    .contains(nums[i]));
        }
    }

    @Test
    public void example2() {
        final int value = 2;
        final int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        final int result = removeElement.removeElement(nums, value);

        assertEquals(5, result);

        for (int i = 0; i < result; i++) {
            assertTrue(Arrays
                    .stream(nums)
                    .boxed()
                    .collect(Collectors.toSet())
                    .contains(nums[i]));
        }
    }

    @Test
    public void failed1() {
        final int value = 1;
        final int[] nums = {1};
        final int result = removeElement.removeElement(nums, value);

        assertEquals(0, result);

        for (int i = 0; i < result; i++) {
            assertTrue(Arrays
                    .stream(nums)
                    .boxed()
                    .collect(Collectors.toSet())
                    .contains(nums[i]));
        }
    }
}
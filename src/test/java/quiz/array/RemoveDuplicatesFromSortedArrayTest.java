package quiz.array;

import lombok.val;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.collect.Sets.newHashSet;
import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesFromSortedArrayTest {

    private final RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();

    @Test
    public void example1() {
        val nums = new int[]{1, 1, 2};
        val result = solution.removeDuplicates(nums);
        val expectedLength = 2;

        assertEquals(expectedLength, result);
        assertEquals(newHashSet(1, 2), toSet(nums, expectedLength));
    }

    @Test
    public void example2() {
        val nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        val result = solution.removeDuplicates(nums);
        val expectedLength = 5;

        assertEquals(expectedLength, result);
        assertEquals(newHashSet(0, 1, 2, 3, 4), toSet(nums, expectedLength));
    }

    @Test
    public void edges() {
        assertEquals(0, solution.removeDuplicates(new int[]{}));
        assertEquals(1, solution.removeDuplicates(new int[]{1}));
        assertEquals(1, solution.removeDuplicates(new int[]{2}));
    }

    private Set<Integer> toSet(int[] nums, int length) {
        final int[] copy = Arrays.copyOf(nums, length);

        return Arrays
                .stream(copy)
                .boxed()
                .collect(Collectors.toSet());
    }

}
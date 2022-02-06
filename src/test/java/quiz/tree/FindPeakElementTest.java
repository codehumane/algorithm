package quiz.tree;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;
import quiz.tree.FindPeakElement;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindPeakElementTest {

    private final FindPeakElement finder = new FindPeakElement();

    @Test
    public void example1() {
        final int expected = 2;
        final int[] nums = {1, 2, 3, 1};
        final int result = finder.findPeakElement(nums);
        assertEquals(expected, result);
    }

    @Test
    public void example2() {
        final int[] nums = {1, 2, 1, 3, 5, 6, 4};
        final Set<Integer> expected = Sets.newHashSet(1, 5);
        final int result = finder.findPeakElement(nums);
        assertTrue(expected.contains(result));
    }

    @Test
    public void custom1() {
        final int expected = 1;
        final int[] nums = {1, 2};
        final int result = finder.findPeakElement(nums);
        assertEquals(expected, result);
    }

    @Test
    public void custom2() {
        final int expected = 0;
        final int[] nums = {2, 1};
        final int result = finder.findPeakElement(nums);
        assertEquals(expected, result);
    }

    @Test
    public void custom3() {
        final int expected = 0;
        final int[] nums = {3, 2, 1};
        final int result = finder.findPeakElement(nums);
        assertEquals(expected, result);
    }

    @Test
    public void custom4() {
        final int expected = 2;
        final int[] nums = {1, 2, 3};
        final int result = finder.findPeakElement(nums);
        assertEquals(expected, result);
    }

}

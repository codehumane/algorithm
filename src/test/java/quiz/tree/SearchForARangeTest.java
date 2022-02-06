package quiz.tree;

import org.junit.jupiter.api.Test;
import quiz.tree.SearchForARange;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchForARangeTest {

    private final SearchForARange range = new SearchForARange();

    @Test
    public void example1() {

        // given
        final int target = 8;
        final int[] nums = {5, 7, 7, 8, 8, 10};
        final int[] expected = {3, 4};

        // when
        final int[] result = range.searchRange(nums, target);

        // then
        assertArrayEquals(expected, result);
    }

    @Test
    public void example2() {

        // given
        final int target = 6;
        final int[] nums = {5, 7, 7, 8, 8, 10};
        final int[] expected = {-1, -1};

        // when
        final int[] result = range.searchRange(nums, target);

        // then
        assertArrayEquals(expected, result);
    }

    @Test
    public void example3() {

        // given
        final int target = 0;
        final int[] nums = {};
        final int[] expected = {-1, -1};

        // when
        final int[] result = range.searchRange(nums, target);

        // then
        assertArrayEquals(expected, result);
    }

    @Test
    public void failed1() {

        // given
        final int target = 0;
        final int[] nums = {1};
        final int[] expected = {-1, -1};

        // when
        final int[] result = range.searchRange(nums, target);

        // then
        assertArrayEquals(expected, result);
    }

    @Test
    public void findStart() {
        final int[] nums = {5, 7, 7, 8, 8, 10};
        assertEquals(0, range.searchEdge(nums, 0, nums.length - 1, 5, true));
        assertEquals(1, range.searchEdge(nums, 0, nums.length - 1, 7, true));
        assertEquals(3, range.searchEdge(nums, 0, nums.length - 1, 8, true));
        assertEquals(5, range.searchEdge(nums, 0, nums.length - 1, 10, true));
        assertEquals(-1, range.searchEdge(nums, 0, nums.length - 1, 9, true));
    }

    @Test
    public void findEnd() {
        final int[] nums = {5, 7, 7, 8, 8, 10};
        assertEquals(0, range.searchEdge(nums, 0, nums.length - 1, 5, false));
        assertEquals(2, range.searchEdge(nums, 0, nums.length - 1, 7, false));
        assertEquals(4, range.searchEdge(nums, 0, nums.length - 1, 8, false));
        assertEquals(5, range.searchEdge(nums, 0, nums.length - 1, 10, false));
        assertEquals(-1, range.searchEdge(nums, 0, nums.length - 1, 9, false));
    }

}
package data.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {

    private final BinarySearch bs = new BinarySearch();

    @Test
    public void example1() {

        // given
        final int[] nums = {-1, 0, 3, 5, 9, 12};
        final int target = 9;
        final int expected = 4;

        // when
        final int index = bs.search(nums, target);

        // then
        assertEquals(expected, index);
    }

    @Test
    public void example2() {

        // given
        final int[] nums = {-1, 0, 3, 5, 9, 12};
        final int target = 2;
        final int expected = -1;

        // when
        final int index = bs.search(nums, target);

        // then
        assertEquals(expected, index);
    }

}
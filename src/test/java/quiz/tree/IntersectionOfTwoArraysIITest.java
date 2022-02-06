package quiz.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class IntersectionOfTwoArraysIITest {

    private final IntersectionOfTwoArraysII intersection = new IntersectionOfTwoArraysII();

    @Test
    public void example1() {

        // given
        final int[] nums1 = {1, 2, 2, 1};
        final int[] nums2 = {2, 2};
        final int[] expected = {2, 2};

        // when
        final int[] result = intersection.intersect(nums1, nums2);

        // then
        assertArrayEquals(expected, result);
    }

    @Test
    public void example2() {

        // given
        final int[] nums1 = {4, 9, 5};
        final int[] nums2 = {9, 4, 9, 8, 4};
        final int[] expected = {4, 9};

        // when
        final int[] result = intersection.intersect(nums1, nums2);

        // then
        assertArrayEquals(expected, result);
    }

}
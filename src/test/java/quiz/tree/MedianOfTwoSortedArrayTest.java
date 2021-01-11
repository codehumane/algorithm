package quiz.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedianOfTwoSortedArrayTest {

    public static final double DELTA = 0.000001;
    private final MedianOfTwoSortedArray median = new MedianOfTwoSortedArray();

    @Test
    public void example1() {
        // given
        final int[] nums1 = {1, 3};
        final int[] nums2 = {2};
        final double expected = 2.00000;

        // when
        final double result = median.findMedianSortedArrays(nums1, nums2);

        // then
        assertEquals(expected, result, DELTA);
    }

    @Test
    public void example2() {
        // given
        final int[] nums1 = {1, 2};
        final int[] nums2 = {3, 4};
        final double expected = 2.50000;

        // when
        final double result = median.findMedianSortedArrays(nums1, nums2);

        // then
        assertEquals(expected, result, DELTA);
    }

    @Test
    public void example3() {
        // given
        final int[] nums1 = {0, 0};
        final int[] nums2 = {0, 0};
        final double expected = 0.00000;

        // when
        final double result = median.findMedianSortedArrays(nums1, nums2);

        // then
        assertEquals(expected, result, DELTA);
    }

    @Test
    public void example4() {
        // given
        final int[] nums1 = {};
        final int[] nums2 = {1};
        final double expected = 1.00000;

        // when
        final double result = median.findMedianSortedArrays(nums1, nums2);

        // then
        assertEquals(expected, result, DELTA);
    }

    @Test
    public void example5() {
        // given
        final int[] nums1 = {2};
        final int[] nums2 = {};
        final double expected = 2.00000;

        // when
        final double result = median.findMedianSortedArrays(nums1, nums2);

        // then
        assertEquals(expected, result, DELTA);
    }

    @Test
    public void custom1() {
        // given
        final int[] nums1 = {4, 20, 32, 50, 55, 61};
        final int[] nums2 = {1, 15, 22, 30, 70};
        final double expected = 30.00000;

        // when
        final double result = median.findMedianSortedArrays(nums1, nums2);

        // then
        assertEquals(expected, result, DELTA);
    }

    @Test
    public void custom2() {
        // given
        final int[] nums1 = {3,7};
        final int[] nums2 = {1,4,6};
        final double expected = 4.00000;

        // when
        final double result = median.findMedianSortedArrays(nums1, nums2);

        // then
        assertEquals(expected, result, DELTA);
    }
}

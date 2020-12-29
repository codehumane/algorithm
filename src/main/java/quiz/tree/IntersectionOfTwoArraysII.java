package quiz.tree;

import java.util.Arrays;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p></p>
 * Note:
 * <p></p>
 * - Each element in the result should appear as many times as it shows in both arrays.<br/>
 * - The result can be in any order.
 * <p></p>
 * Follow up:
 * <p></p>
 * - What if the given array is already sorted? How would you optimize your algorithm?<br/>
 * - What if nums1's size is small compared to nums2's size? Which algorithm is better?<br/>
 * - What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        final int[] intersection = new int[nums1.length];
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] == nums2[idx2]) {
                intersection[idx++] = nums1[idx1];
                idx1++;
                idx2++;
            } else if (nums1[idx1] > nums2[idx2]) {
                idx2++;
            } else {
                idx1++;
            }
        }

        return Arrays.copyOf(intersection, idx);
    }
}

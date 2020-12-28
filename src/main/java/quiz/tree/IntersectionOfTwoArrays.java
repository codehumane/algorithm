package quiz.tree;

import java.util.Arrays;

/**
 * Given two arrays,
 * write a function to compute their intersection.
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        final int[] intersection = new int[nums1.length];
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] == nums2[idx2]) {
                if (idx == 0 || intersection[idx - 1] != nums1[idx1]) {
                    intersection[idx++] = nums1[idx1];
                }

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

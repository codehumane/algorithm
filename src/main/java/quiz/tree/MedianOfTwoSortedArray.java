package quiz.tree;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 * <br/><br/>
 * Follow up: The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // A <= B 보장
        int[] A = nums1.length <= nums2.length ? nums1 : nums2;
        int[] B = nums1.length <= nums2.length ? nums2 : nums1;

        final int m = A.length;
        final int n = B.length;
        int iMin = 0;
        int iMax = m;

        while (true) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;

            if (i > 0 && j < n && A[i - 1] > B[j]) {
                iMax = i - 1;
            } else if (j > 0 && i < m && B[j - 1] > A[i]) {
                iMin = i + 1;
            } else {
                int leftMax;
                if (j == 0) leftMax = A[i - 1];
                else if (i == 0) leftMax = B[j - 1];
                else leftMax = Math.max(A[i - 1], B[j - 1]);

                if ((m + n) % 2 == 1) return leftMax;

                int rightMin;
                if (i == m) rightMin = B[j];
                else if (j == n) rightMin = A[i];
                else rightMin = Math.min(A[i], B[j]);

                return (leftMax + rightMin) / 2.0;
            }
        }
    }

}

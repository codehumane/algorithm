package quiz.array;

public class MedianOfTwoSortedArrays {

    /**
     * O(N)
     * O(N)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) return 0;

        int[] m = halfMerge(nums1, nums2);
        return medianOfHalfMerged(nums1, nums2, m);
    }

    private int[] halfMerge(int[] nums1, int[] nums2) {
        var merged = new int[(nums1.length + nums2.length) / 2 + 1];

        var idx1 = 0;
        var idx2 = 0;

        while (idx1 + idx2 < merged.length) {
            if (idx1 >= nums1.length ||
                    (0 < nums2.length && idx2 < nums2.length && nums1[idx1] > nums2[idx2])) {

                merged[idx1 + idx2] = nums2[idx2++];
            } else {
                merged[idx1 + idx2] = nums1[idx1++];
            }
        }

        return merged;
    }

    private float medianOfHalfMerged(int[] n1, int[] n2, int[] m) {
        if ((n1.length + n2.length) % 2 == 0) {
            return (m[m.length - 1] + m[m.length - 2]) / 2f;
        } else {
            return m[m.length - 1];
        }
    }

}

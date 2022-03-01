package quiz.array;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var firstApproach = new FirstApproach().findMedianSortedArrays(nums1, nums2);
        var spaceImproved = new SpaceComplexityImproved().findMedianSortedArrays(nums1, nums2);

        assert firstApproach == spaceImproved;
        return firstApproach;
    }

    /**
     * O(N)
     * O(N)
     */
    static class FirstApproach {

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

    /**
     * O(N)
     * O(1)
     */
    static class SpaceComplexityImproved {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length == 0 && nums2.length == 0) return 0;
            var total = nums1.length + nums2.length;

            return calculate(
                    total,
                    collectMedians(
                            nums1,
                            nums2,
                            total
                    )
            );
        }

        private int[] collectMedians(int[] nums1, int[] nums2, int total) {
            var medians = new int[2];

            var i1 = 0;
            var i2 = 0;

            while (i1 + i2 <= total / 2) {
                medians[0] = medians[1];

                if (i1 >= nums1.length ||
                        (0 < nums2.length && i2 < nums2.length && nums1[i1] > nums2[i2])) {
                    medians[1] = nums2[i2++];
                } else {
                    medians[1] = nums1[i1++];
                }
            }

            return medians;
        }

        private float calculate(int total, int[] medians) {
            if (total % 2 == 0) return (medians[0] + medians[1]) / 2f;
            else return medians[1];
        }
    }

}

package quiz.dynamic;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        var memoization = new Memoization().maxSubArray(nums);
        var dac = new DAC().maxSubArray(nums);
        assert memoization == dac;
        return memoization;
    }

    /**
     * O(N)
     */
    static class Memoization {
        public int maxSubArray(int[] nums) {

            var max = nums[0];
            var sum = nums[0];

            for (int i = 1; i < nums.length; i++) {

                if (sum >= 0 && sum + nums[i] >= 0) {
                    sum += nums[i];
                } else {
                    sum = nums[i];
                }

                max = Math.max(max, sum);
            }

            return max;
        }
    }

    /**
     * O(N·logN)
     */
    static class DAC {

        public int maxSubArray(int[] nums) {
            return max(nums, 0, nums.length - 1);
        }

        private int max(int[] nums, int from, int to) {
            if (from == to) return nums[from];

            var mid = (from + to) / 2;
            var left = max(nums, from, mid);
            var right = max(nums, mid + 1, to);

            return Math.max(
                    Math.max(left, right),
                    maxConnection(nums, from, mid, to)
            );
        }

        private int maxConnection(int[] nums, int from, int mid, int to) {

            var left = nums[mid];
            var leftMax = left;
            for (int i = mid - 1; i >= from; i--) {
                left += nums[i];
                leftMax = Math.max(leftMax, left);
            }

            var right = nums[mid + 1];
            var rightMax = right;
            for (int i = mid + 2; i <= to; i++) {
                right += nums[i];
                rightMax = Math.max(rightMax, right);
            }

            return leftMax + rightMax;
        }

    }

}

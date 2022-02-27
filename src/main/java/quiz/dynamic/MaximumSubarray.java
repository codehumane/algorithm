package quiz.dynamic;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        return new Memoization().maxSubArray(nums);
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

}

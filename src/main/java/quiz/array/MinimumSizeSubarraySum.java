package quiz.array;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {

        var sum = 0;
        var from = 0;
        var length = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) {
                length = Math.min(length, i - from + 1);
                sum -= nums[from++];
            }
        }

        // 1 <= nums.length <= 10^5 제약이 있어서 가능
        return length == Integer.MAX_VALUE ? 0 : length;
    }

}

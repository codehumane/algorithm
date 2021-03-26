package quiz.array;

/**
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
 * of which the sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 * <p>
 * https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1299/
 */
public class MinimumSizeSubArray {

    private final int MAX_LENGTH = (int) Math.pow(10, 5);

    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int right = 0;
        int sum = 0;
        int min = MAX_LENGTH + 1;

        while (left < nums.length && right <= nums.length) {
            if (sum >= target) {
                min = Math.min(min, right - left);
                sum -= nums[left];
                left++;
            } else {
                if (right < nums.length) {
                    sum += nums[right];
                }
                right++;
            }
        }

        return min > MAX_LENGTH ? 0 : min;
    }

}

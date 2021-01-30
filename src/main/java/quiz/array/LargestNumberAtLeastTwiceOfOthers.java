package quiz.array;

import java.util.Arrays;

/**
 * In a given integer array nums,
 * there is always exactly one largest element.
 * <br/><br/>
 * Find whether the largest element in the array
 * is at least twice as much as every other number in the array.
 * <br/><br/>
 * If it is, return the index of the largest element, otherwise return -1.
 * <br/><br/>
 * - nums will have a length in the range [1, 50].<br/>
 * - Every nums[i] will be an integer in the range [0, 99].
 */
public class LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex(int[] nums) {
        final int maxIndex = findMaxIndex(nums);
        final boolean dominant = isDominant(nums, nums[maxIndex]);
        return dominant ? maxIndex : -1;
    }

    private int findMaxIndex(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    private boolean isDominant(int[] nums, int max) {
        return Arrays
                .stream(nums)
                .allMatch(num -> num == max || num * 2 <= max);
    }

}

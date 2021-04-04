package quiz.array;

/**
 * Given an integer array nums,
 * move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.<br/>
 * <br/>
 * Note that you must do this in-place without making a copy of the array.<br/>
 * <br/>
 * https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1174/
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int zero = -1; // 0이 시작되는 인덱스

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && zero < 0) zero = i;
            if (nums[i] != 0 && zero >= 0) swap(nums, zero++, i);
        }
    }

    private void swap(int[] nums, int i1, int i2) {
        final int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

}

package quiz.array;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/
 * <br/><br/>
 * Given an array of integers nums,
 * write a method that returns the "pivot" index of this array.
 * <br/><br/>
 * We define the pivot index as the index where
 * the sum of all the numbers to the left of the index is
 * equal to the sum of all the numbers to the right of the index.
 * <br/><br/>
 * If no such index exists, we should return -1.
 * If there are multiple pivot indexes, you should return the left-most pivot index.
 */
public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int leftSum = 0;

        final int total = Arrays
                .stream(nums)
                .sum();

        for (int i = 0; i < nums.length; i++) {
            if (total - nums[i] == 2 * leftSum) return i;
            leftSum += nums[i];
        }

        return -1;
    }

}

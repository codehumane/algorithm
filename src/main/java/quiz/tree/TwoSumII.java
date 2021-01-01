package quiz.tree;

/**
 * https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1035/
 * <p><br/>
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 * <br/><br/>
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 * <br/><br/>
 * Note:
 * <br/><br/>
 * - Your returned answers (both index1 and index2) are not zero-based.<br/>
 * - You may assume that each input would have exactly one solution and you may not use the same element twice.<br/>
 */
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (true) {
            final int sum = numbers[left] + numbers[right];

            if (sum > target) right--;
            else if (sum < target) left++;
            else return new int[]{left + 1, right + 1};
        }
    }

}

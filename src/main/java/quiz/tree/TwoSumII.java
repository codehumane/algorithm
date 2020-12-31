package quiz.tree;

import java.util.HashMap;
import java.util.Map;

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
        final Map<Integer, Integer> indices = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            final int num = numbers[i];

            if (indices.containsKey(target - num)) {
                return new int[]{indices.get(target - num), i + 1};
            }

            indices.put(num, i + 1);
        }

        throw new IllegalStateException();
    }

}

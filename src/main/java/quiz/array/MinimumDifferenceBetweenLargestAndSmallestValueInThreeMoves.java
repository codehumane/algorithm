package quiz.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 */
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {

    public int minDifference(int[] nums) {
        if (nums.length < 5) return 0;

        var sorted = sort(nums);
        return findMinimumDiff(nums, sorted);
    }

    private List<Integer> sort(int[] nums) {
        return Arrays
                .stream(nums)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
    }

    private int findMinimumDiff(int[] nums, List<Integer> sorted) {
        var min = Integer.MAX_VALUE;

        for (int i = 0; i <= 3; i++) {
            var diff = sorted.get(nums.length - 1 - i) - sorted.get(3 - i);
            min = Math.min(min, diff);
        }

        return min;
    }

}

package quiz.math;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/3sum/
 * <p>
 * 3 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 */
@Slf4j
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        var sumOfTwoIndices = sumOfTwoIndices(nums);
        var threeSumIndices = threeSumIndices(nums, sumOfTwoIndices);
        return mapToValueAndDistinct(nums, threeSumIndices);
    }

    private Map<Integer, Set<Set<Integer>>> sumOfTwoIndices(int[] nums) {
        final Map<Integer, Set<Set<Integer>>> sums = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                var sum = nums[i] + nums[j];
                var indices = Set.of(i, j);
                sums.putIfAbsent(sum, new HashSet<>());
                sums.get(sum).add(indices);
            }
        }

        return sums;
    }

    private Set<Set<Integer>> threeSumIndices(int[] nums, Map<Integer, Set<Set<Integer>>> sumOfTwoIndices) {
        var indices = new HashSet<Set<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            var candidates = sumOfTwoIndices.getOrDefault(-nums[i], Set.of());

            for (Set<Integer> candidate : candidates) {
                var threeSum = new HashSet<>(candidate);
                threeSum.add(i);

                if (threeSum.size() == 3) {
                    indices.add(threeSum);
                }
            }
        }

        return indices;
    }

    private List<List<Integer>> mapToValueAndDistinct(int[] nums, Set<Set<Integer>> threeSumIndices) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Set<Integer>> distinct = new HashSet<>();

        for (Set<Integer> indices : threeSumIndices) {
            final List<Integer> values = indices
                    .stream()
                    .map(i -> nums[i])
                    .collect(Collectors.toList());

            final HashSet<Integer> identity = new HashSet<>(values);
            if (distinct.contains(identity)) continue;

            distinct.add(identity);
            result.add(values);
        }

        return result;
    }

}

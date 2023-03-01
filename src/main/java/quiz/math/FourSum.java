package quiz.math;

import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return List.of();

        Arrays.sort(nums);
        return collect(nums, target);
    }

    private List<List<Integer>> collect(int[] nums, int target) {
        final Set<List<Integer>> sums = new HashSet<>();

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                collect(sums, nums, i, j, target);
            }
        }

        return new ArrayList<>(sums);
    }

    private void collect(Set<List<Integer>> sums, int[] nums, int first, int second, int target) {
        int three = second + 1;
        int four = nums.length - 1;

        while (three < four) {

            long leftSum = (long) nums[first] + nums[second] + nums[three];
            if (leftSum > 0 && leftSum > target) {
                return;
            }

            long sum = leftSum + nums[four];
            if (sum == target) {
                sums.add(List.of(nums[first], nums[second], nums[three], nums[four]));
                three++;
            } else if (sum < target) {
                three++;
            } else {
                four--;
            }
        }
    }

}

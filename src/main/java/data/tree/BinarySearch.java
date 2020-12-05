package data.tree;

/**
 * Given a sorted (in ascending order) integer array nums of n elements and a target value,
 * write a function to search target in nums.
 * If target exists, then return its index, otherwise return -1.
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        return searchIteratively(nums, target);
//        return searchRecursive(nums, target, 0, nums.length - 1);
    }

    private int searchIteratively(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            final int half = (left + right) / 2;
            if (target < nums[half]) right = half - 1;
            else if (nums[half] < target) left = half + 1;
            else return half;
        }

        return index;
    }

    private int searchRecursively(int[] nums, int target, int left, int right) {
        if (right < left) return -1;

        final int half = (right + left) / 2;
        if (nums[half] > target) return searchRecursively(nums, target, left, half - 1);
        if (nums[half] < target) return searchRecursively(nums, target, half + 1, right);
        return half;
    }
}

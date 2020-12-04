package data.tree;

/**
 * Given a sorted (in ascending order) integer array nums of n elements and a target value,
 * write a function to search target in nums.
 * If target exists, then return its index, otherwise return -1.
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        if (right < left) return -1;

        final int half = (right + left) / 2;
        if (nums[half] > target) return search(nums, target, left, half - 1);
        if (nums[half] < target) return search(nums, target, half + 1, right);
        return half;
    }
}

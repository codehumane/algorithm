package data.tree;

/**
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 */
public class SearchForARange {

    public int[] searchRange(int[] nums, int target) {
        final int start = findStart(nums, 0, nums.length - 1, target);
        final int end = findEnd(nums, 0, nums.length - 1, target);
        return new int[]{start, end};
    }

    int findStart(int[] nums, int l, int r, int target) {
        if (nums.length == 0 || l > r) return -1;

        final int m = l + (r - l) / 2;
        if (nums[m] < target) return findStart(nums, m + 1, r, target);
        if (nums[m] > target) return findStart(nums, l, m - 1, target);
        if (m != 0 && nums[m - 1] == target) return findStart(nums, l, m - 1, target);

        return m;
    }

    int findEnd(int[] nums, int l, int r, int target) {
        if (nums.length == 0 || l > r) return -1;

        final int m = l + (r - l) / 2;
        if (nums[m] < target) return findEnd(nums, m + 1, r, target);
        if (nums[m] > target) return findEnd(nums, l, m - 1, target);
        if (m != nums.length - 1 && nums[m + 1] == target) return findEnd(nums, m + 1, r, target);

        return m;
    }

}

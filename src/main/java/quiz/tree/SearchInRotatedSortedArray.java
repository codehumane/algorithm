package quiz.tree;

/**
 * You are given an integer array nums sorted in ascending order (with distinct values), and an integer target.
 * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * If target is found in the array return its index, otherwise, return -1.
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        if (left > right) return -1;

        final int mid = left + (right - left) / 2;

        if (nums[mid] == target) return mid;
        if (isInLeft(nums, target, left, right, mid)) return search(nums, target, left, mid - 1);
        return search(nums, target, mid + 1, right);
    }

    private boolean isInLeft(int[] nums, int target, int left, int right, int mid) {
        if (nums[left] < nums[mid]) return nums[left] <= target && target < nums[mid];
        if (nums[mid] < nums[right]) return !(nums[mid] < target && target <= nums[right]);
        return false;
    }

}

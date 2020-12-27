package quiz.tree;

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
        final int start = searchEdge(nums, 0, nums.length - 1, target, true);
        if (start == -1) return new int[]{-1, -1};

        final int end = searchEdge(nums, start, nums.length - 1, target, false);
        return new int[]{start, end};
    }

    int searchEdge(int[] nums, int l, int r, int t, boolean leftmost) {
        if (nums.length == 0 || l > r) return -1;

        final int m = l + (r - l) / 2;
        if (nums[m] < t) return searchEdge(nums, m + 1, r, t, leftmost);
        if (nums[m] > t) return searchEdge(nums, l, m - 1, t, leftmost);
        if (leftmost && m != 0 && nums[m - 1] == t) return searchEdge(nums, l, m - 1, t, true);
        if (!leftmost && m != nums.length - 1 && nums[m + 1] == t) return searchEdge(nums, m + 1, r, t, false);

        return m;
    }

}

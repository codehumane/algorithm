package quiz.tree;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    private int find(int[] nums, int l, int r) {
        if (l == r) return nums[l];

        final int m = l + (r - l) / 2;
        if (nums[m] > nums[r]) return find(nums, m + 1, r);
        else return find(nums, l, m);
    }

}

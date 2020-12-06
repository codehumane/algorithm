package data.tree;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        return findBS(nums, 0, nums.length - 1);
//        return findLinear(nums);
    }

    /**
     * if mid rising then check mid ~ right
     * else (falling or remaining) then check left ~ mid - 1
     */
    private int findBS(int[] nums, int left, int right) {
        if (left >= right) return left;

        final int mid = left + (right - left) / 2;
        if (nums[mid] > nums[mid + 1]) return findBS(nums, left, mid);
        else return findBS(nums, mid + 1, right);
    }

    private int findLinear(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) return i;
        }
        return nums.length - 1;
    }

}

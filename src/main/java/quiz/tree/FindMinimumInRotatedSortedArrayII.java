package quiz.tree;

public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    private int find(int[] nums, int left, int right) {
        if (right - left <= 1) return Math.min(nums[left], nums[right]);

        final int mid = left + (right - left) / 2;

        if (nums[left] == nums[right] || nums[left] == nums[mid] || nums[right] == nums[mid]) {
            final int leftMin = find(nums, left, mid - 1);
            final int rightMin = find(nums, mid, right);
            return Math.min(leftMin, rightMin);
        }

        if (nums[left] < nums[right]) return nums[left];
        else if (nums[left] > nums[mid]) return find(nums, left, mid);
        else return find(nums, mid + 1, right);
    }

}

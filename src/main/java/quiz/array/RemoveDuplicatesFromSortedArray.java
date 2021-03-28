package quiz.array;

/**
 * Given a sorted array nums,
 * remove the duplicates in-place
 * such that each element appears only once
 * and returns the new length.<br/>
 * <br/>
 * Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.<br/>
 * <br/>
 * Constraints:<br/>
 * 1. 0 <= nums.length <= 3 * 104<br/>
 * 2. -104 <= nums[i] <= 104<br/>
 * 3. nums is sorted in ascending order.<br/>
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                swap(nums, ++slow, fast);
            }
        }

        return slow + 1;
    }

    private void swap(int[] nums, int i1, int i2) {
        final int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

}

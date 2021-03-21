package quiz.array;

/**
 * Given an array nums and a value val,
 * remove all instances of that value in-place and return the new length.<br/>
 * <br/>
 * Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.<br/>
 * <br/>
 * The order of elements can be changed.
 * It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == val) {
                swap(nums, left, right);
                right--;
            } else {
                left++;
            }
        }

        return right + 1;
    }

    private void swap(int[] nums, int left, int right) {
        final int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}

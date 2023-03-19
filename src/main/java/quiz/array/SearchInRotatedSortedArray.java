package quiz.array;

import java.util.Arrays;

public class SearchInRotatedSortedArray {

    /**
     * @param nums   sorted in ascending order (with distinct values),
     *               and possibly rotated at an unknown pivot index k (1 <= k < nums.length).
     *               (1 <= nums.length <= 5000)
     *               (-104 <= nums[i] <= 104)
     * @param target search target
     * @return the index of target if it is in nums, or -1 if it is not in nums.
     */
    public int search(int[] nums, int target) {
        var first = nums[0];
        Arrays.sort(nums);
        var targetIndex = indexOf(nums, target);
        var rotation = nums.length - indexOf(nums, first);

        if (targetIndex == -1) return -1;
        else return (targetIndex + rotation) % nums.length;
    }

    private int indexOf(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

}

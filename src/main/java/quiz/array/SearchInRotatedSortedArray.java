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
        var rotation = beforeRotation(nums);
        var index = indexOf(nums, target);

        if (index == -1) return index;
        return (index + rotation) % nums.length;
    }

    private int beforeRotation(int[] nums) {
        var index = indexOf(nums, min(nums));

        reverse(nums, 0, index - 1);
        reverse(nums, index, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

        return index;
    }

    private int indexOf(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }

        return -1;
    }

    private int min(int[] nums) {
        return Arrays
                .stream(nums)
                .min()
                .orElseThrow();
    }

    private void reverse(int[] nums, int from, int to) {
        while (from < to) {
            var tmp = nums[from];
            nums[from] = nums[to];
            nums[to] = tmp;
            from++;
            to--;
        }
    }

}

package data.tree;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            final boolean greaterThanLeft = (i - 1 < 0) || nums[i - 1] < nums[i];
            final boolean greaterThanRight = (i + 1 >= nums.length) || nums[i] > nums[i + 1];
            if (greaterThanLeft && greaterThanRight) return i;
        }

        throw new IllegalStateException();
    }

}

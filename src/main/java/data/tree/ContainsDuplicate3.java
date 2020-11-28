package data.tree;

/**
 * Given an array of integers,
 * find out whether there are two distinct indices i and j in the array
 * such that the absolute difference between nums[i] and nums[j] is at most t
 * and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicate3 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        return byBruteForce(nums, k, t);
    }

    private boolean byBruteForce(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; (j <= i + k) && (j < nums.length); j++) {
                final long diff = (long) nums[i] - (long) nums[j];
                if (Math.abs(diff) <= t) return true;
            }
        }

        return false;
    }

}

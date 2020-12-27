package quiz.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Given an array of integers,
 * find out whether there are two distinct indices i and j in the array
 * such that the absolute difference between nums[i] and nums[j] is at most t
 * and the absolute difference between i and j is at most k.
 */
@Slf4j
public class ContainsDuplicate3 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        return bySortedSet(nums, k, t);
//        return byBruteForce(nums, k, t);
    }

    private boolean bySortedSet(int[] nums, int k, int t) {
        final SortedSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.subSet((long) nums[i] - t, (long) nums[i] + t + 1).size() > 0) return true;

            set.add((long) nums[i]);
            if (i >= k) set.remove((long) nums[i - k]);
        }

        return false;
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

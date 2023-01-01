package quiz.math;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * <p>
 * 3 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 */
@Slf4j
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        return new ByHashSet().threeSum(nums);
    }

    static class ByHashSet {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);

            var res = new ArrayList<List<Integer>>();
            for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    collect(nums, i, res);
                }
            }

            return res;
        }

        void collect(int[] nums, int i, List<List<Integer>> res) {
            var complements = new HashSet<Integer>();

            for (int j = i + 1; j < nums.length; ++j) {
                int complement = -(nums[i] + nums[j]);

                if (complements.contains(complement)) {
                    res.add(List.of(nums[i], nums[j], complement));
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                        ++j;
                    }
                }

                complements.add(nums[j]);
            }
        }
    }
}

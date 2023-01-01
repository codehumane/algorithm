package quiz.math;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 * <p>
 * 3 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 */
@Slf4j
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        return new NoSort().threeSum(nums);
    }

    static class ByTwoPointers {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);

            var res = new ArrayList<List<Integer>>();
            for (int i = 0; i < nums.length - 2 && nums[i] <= 0; ++i) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    collect(nums, i, res);
                }
            }

            return res;
        }

        private void collect(int[] nums, int i, List<List<Integer>> res) {
            var l = i + 1;
            var r = nums.length - 1;

            while (l < r) {
                var sum = nums[i] + nums[l] + nums[r];

                if (sum == 0) {
                    res.add(List.of(nums[i], nums[l], nums[r]));

                    l++;
                    r--;

                    while (l > i + 1 && l < r && nums[l] == nums[l - 1]) l++;
                    while (r < nums.length - 1 && l < r && nums[r] == nums[r + 1]) r--;

                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

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

    static class NoSort {
        public List<List<Integer>> threeSum(int[] nums) {
            var triplets = new HashSet<List<Integer>>();
            var duplicated = new HashSet<Integer>();
            var complements = new HashMap<Integer, Integer>(); // num to current index

            for (int i = 0; i < nums.length; i++) {
                if (duplicated.contains(nums[i])) continue;
                duplicated.add(nums[i]);

                for (int j = i + 1; j < nums.length; j++) {
                    var comp = -(nums[i] + nums[j]);

                    if (complements.getOrDefault(nums[j], -1) == i) {
                        var triplet = Arrays.asList(comp, nums[i], nums[j]);
                        Collections.sort(triplet);
                        triplets.add(triplet);
                    }

                    complements.put(comp, i);
                }
            }

            return new ArrayList<>(triplets);
        }
    }
}

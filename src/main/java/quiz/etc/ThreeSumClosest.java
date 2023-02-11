package quiz.etc;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        var closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i + 2 < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > target) {
                break;
            }

            var l = i + 1;
            var r = nums.length - 1;

            while (l < r) {
                var sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - closest) > Math.abs(target - sum)) {
                    closest = sum;
                }

                if (target < sum) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return closest;
    }

}

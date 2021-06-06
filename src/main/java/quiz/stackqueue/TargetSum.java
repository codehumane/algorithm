package quiz.stackqueue;

/**
 * You are given an integer array nums and an integer target.<br/>
 * You want to build an expression out of nums
 * by adding one of the symbols '+' and '-' before each integer in nums
 * and then concatenate all the integers.<br/>
 * <br/>
 * For example,
 * if nums = [2, 1],
 * you can add a '+' before 2 and a '-' before 1
 * and concatenate them to build the expression "+2-1".<br/>
 * <br/>
 * Return the number of different expressions that you can build, which evaluates to target.<br/>
 * <br/>
 * Constraints:<br/>
 * 1. 1 <= nums.length <= 20<br/>
 * 2. 0 <= nums[i] <= 1000<br/>
 * 3. 0 <= sum(nums[i]) <= 1000<br/>
 * 4. -1000 <= target <= 1000<br/>
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        return find(nums, target, 0, 0);
    }

    private int find(int[] nums, int target, int sum, int index) {
        int count = 0;

        if (index < nums.length - 1) {
            count += find(
                    nums,
                    target,
                    nums[index] + sum,
                    index + 1
            );
            count += find(
                    nums,
                    target,
                    -nums[index] + sum,
                    index + 1
            );
        } else {
            if (sum + nums[index] == target) count++;
            if (sum - nums[index] == target) count++;
        }

        return count;
    }

}

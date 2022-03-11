package quiz.array;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        var sum = 0;
        var sumStart = 0;
        var sumLength = nums.length;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (target > sum) continue;

            var simSum = sum;
            var simStart = sumStart;
            while (simStart <= i && simSum >= target) {
                simSum -= nums[simStart++];
            }

            sumStart = simStart - 1;
            sum = simSum + nums[simStart - 1];
            sumLength = Math.min(sumLength, i - sumStart + 1);
        }

        return sum >= target ? sumLength : 0;
    }

}

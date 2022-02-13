package quiz.dynamic;

/**
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        final boolean dp = new DP().canJump(nums);
        final boolean efficientDp = new EfficientDP().canJump(nums);
        assert dp == efficientDp;
        return efficientDp;
    }

    static class DP {
        public boolean canJump(int[] nums) {
            if (nums.length < 2) return true;

            final var dp = new boolean[nums.length][nums.length];

            for (int from = 0; from < nums.length - 1; from++) {
                if (from == 0 || dp[from - 1][from]) {

                    for (int to = from + 1; to < nums.length; to++) {
                        dp[from][to] = (to <= from + nums[from]) || (from > 0 && dp[from - 1][to]);

                        if (to == nums.length - 1 && dp[from][to]) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }

    static class EfficientDP {
        public boolean canJump(int[] nums) {
            if (nums.length < 2) return true;

            var end = 0;

            for (int start = 0; start < nums.length - 1; start++) {
                if (start <= end) {
                    end = Math.min(
                            Math.max(end, start + nums[start]),
                            nums.length - 1
                    );

                    if (end == nums.length - 1) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

}

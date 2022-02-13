package quiz.dynamic;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

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

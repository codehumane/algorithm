package quiz.array;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
@Slf4j
public class JumpGame2 {

    public int jump(int[] nums) {
        var counts = new int[nums.length];
        Arrays.fill(counts, Integer.MAX_VALUE);
        counts[0] = 0;

        for (int i = 0; i + 1 < nums.length; i++) {
            var j = i;

            while (j < nums.length && j <= i + nums[i]) {
                counts[j] = Math.min(counts[j], counts[i] + 1);
                j++;
            }

        }

        return counts[nums.length - 1];
    }

}

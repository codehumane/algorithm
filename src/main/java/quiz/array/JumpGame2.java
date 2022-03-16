package quiz.array;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
@Slf4j
public class JumpGame2 {

    public int jump(int[] nums) {
//        var dp = new DynamicProgramming().jump(nums);
        var greedy = new Greedy().jump(nums);
//        assert dp == greedy;
        return greedy;
    }

    /**
     * Greedy
     * <p>
     * O(N)
     * O(1)
     */
    static class Greedy {
        public int jump(int[] nums) {
            var end = 0;
            var candidate = 0;
            var count = 0;

            for (int i = 0; i < nums.length - 1; i++) {
                candidate = Math.max(candidate, i + nums[i]);

                if (i == end) {
                    end = candidate;
                    count++;
                }
            }

            return count;
        }
    }

    /**
     * DP
     * <p>
     * O(N^2)
     * O(N)
     */
    static class DynamicProgramming {
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

}

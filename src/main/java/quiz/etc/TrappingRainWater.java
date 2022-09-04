package quiz.etc;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
@Slf4j
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length == 0) return 0;

        var area = 0;
        var max = max(height);

        for (int i = 0; i < height.length; i++) {
            area += max[i] - height[i];
        }

        return area;
    }

    private int[] max(int[] height) {
        var max = new int[height.length];
        var maxToRight = maxToRight(height);
        var maxToLeft = maxToLeft(height);

        for (int i = 0; i < max.length; i++) {
            max[i] = Math.min(maxToRight[i], maxToLeft[i]);
        }

        return max;
    }

    private int[] maxToRight(int[] height) {
        var max = new int[height.length];

        max[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            max[i] = Math.max(max[i - 1], height[i]);
        }

        return max;
    }

    private int[] maxToLeft(int[] height) {
        var max = new int[height.length];

        max[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], height[i]);
        }

        return max;
    }

}

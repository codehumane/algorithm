package quiz.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */
public class MaximumPointsYouCanObtainFromCards {

    public int maxScore(int[] cardPoints, int k) {
        var dp = new DP().maxScore(cardPoints, k);
        var slidingWindow = new SlidingWindow().maxScore(cardPoints, k);
        assert dp == slidingWindow;
        return slidingWindow;
    }

    static class DP {
        public int maxScore(int[] cardPoints, int k) {

            // 왼쪽합
            var sum = 0;
            for (int i = 0; i < k; i++) {
                sum += cardPoints[i];
            }

            var i = 0;
            var max = sum;
            var n = cardPoints.length;

            if (k == n) return max;

            // 하나씩 이동하며 비교
            while (i < k && i < n - 1) {
                sum -= cardPoints[k - 1 - i];
                sum += cardPoints[n - 1 - i];
                max = Math.max(max, sum);
                i++;
            }

            return max;
        }
    }

    static class SlidingWindow {
        public int maxScore(int[] cardPoints, int k) {
            var windowSize = cardPoints.length - k;
            var total = Arrays.stream(cardPoints).sum();
            var sum = 0;

            for (int i = 0; i < windowSize; i++) {
                sum += cardPoints[i];
            }

            var min = sum;
            for (int i = 0; i < cardPoints.length - windowSize; i++) {
                sum -= cardPoints[i];
                sum += cardPoints[windowSize + i];
                min = Math.min(min, sum);
            }

            return total - min;
        }
    }

}

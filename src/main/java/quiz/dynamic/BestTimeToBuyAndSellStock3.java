package quiz.dynamic;

/**
 * You are given an array prices
 * where prices[i] is the price of a given stock on the ith day.<br/>
 * <br/>
 * Find the maximum profit you can achieve.
 * You may complete at most two transactions.<br/>
 * <br/>
 * Note: You may not engage in multiple transactions simultaneously
 * (i.e., you must sell the stock before you buy again).<br/>
 * <br/>
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/">https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/</a>
 * <br/>
 * <br/>
 * Constraints:
 * <br/>
 * - 1 <= prices.length <= 105<br/>
 * - 0 <= prices[i] <= 105<br/>
 */
public class BestTimeToBuyAndSellStock3 {

    public int maxProfit(int[] prices) {
        final int[] left = left(prices);
        final int[] right = right(prices);
        return profit(prices, left, right);
    }

    private int[] left(int[] prices) {
        int min = prices[0];
        final int[] left = new int[prices.length];
        left[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        return left;
    }

    private int[] right(int[] prices) {
        int max = prices[prices.length - 1];
        final int[] right = new int[prices.length];
        right[right.length - 1] = 0;

        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        return right;
    }

    private int profit(int[] prices, int[] left, int[] right) {

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }

        return profit;
    }

}

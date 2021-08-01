package dynamic;

import com.google.common.base.Predicate;
import com.google.common.base.Supplier;

import java.util.function.BooleanSupplier;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;

/**
 * You are given an array prices
 * where prices[i] is the price of a given stock on the ith day.<br/>
 * <br/>
 * Find the maximum profit you can achieve.
 * You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).<br/>
 * <br/>
 * Note: You may not engage in multiple transactions simultaneously
 * (i.e., you must sell the stock before you buy again).<br/>
 * <br/>
 * Constraints:
 * <br/>
 * - 1 <= prices.length <= 3 * 104<br/>
 * - 0 <= prices[i] <= 104<br/>
 * <br/>
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/</a>
 */
public class BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int stockPrice = 0;
        boolean hasStock = false;
        int beforePrice = prices[0];
        int profit = 0;

        for (int price : prices) {
            if (beforePrice < price && !hasStock) {
                // 이전 값이 최저값이므로 구매!
                stockPrice = beforePrice;
                hasStock = true;
            }

            if (beforePrice > price && hasStock) {
                // 이전 값이 최고값이므로 판매!
                profit += beforePrice - stockPrice;
                hasStock = false;
            }

            beforePrice = price;
        }

        // 마지막 재고 처리
        if (hasStock) {
            profit += beforePrice - stockPrice;
        }

        return profit;
    }

    public int maxProfitV2(int[] prices) {
        if (prices.length == 0) return 0;

        int profit = 0;
        int low;
        int high;
        int i = 0;

        while (i < prices.length - 1) {

            // 저점 찾기
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
            low = prices[i];

            // 고점 찾기
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
            high = prices[i];

            profit += high - low;
        }

        return profit;
    }

    public int maxProfitV3(int[] prices) {
        int profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }

        return profit;
    }

}

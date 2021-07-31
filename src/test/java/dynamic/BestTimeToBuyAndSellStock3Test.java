package dynamic;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BestTimeToBuyAndSellStock3Test {

    private final BestTimeToBuyAndSellStock3 solution = new BestTimeToBuyAndSellStock3();

    @Test
    public void example1() {

        // given
        val prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        val expected = 6;

        // when
        val result = solution.maxProfit(prices);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void example2() {

        // given
        val prices = new int[]{1, 2, 3, 4, 5};
        val expected = 4;

        // when
        val result = solution.maxProfit(prices);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void example3() {

        // given
        val prices = new int[]{7, 6, 4, 3, 1};
        val expected = 0;

        // when
        val result = solution.maxProfit(prices);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void example4() {

        // given
        val prices = new int[]{1};
        val expected = 0;

        // when
        val result = solution.maxProfit(prices);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void custom1() {

        // given
        val prices = new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        val expected = 13;

        // when
        val result = solution.maxProfit(prices);

        // then
        assertEquals(expected, result);
    }

}
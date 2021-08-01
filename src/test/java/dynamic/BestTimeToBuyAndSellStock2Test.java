package dynamic;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BestTimeToBuyAndSellStock2Test {

    private final BestTimeToBuyAndSellStock2 solution = new BestTimeToBuyAndSellStock2();

    @Test
    public void example1() {

        // given
        val input = new int[]{7, 1, 5, 3, 6, 4};
        val expected = 7;

        // when
        val result = solution.maxProfit(input);
        val result2 = solution.maxProfitV2(input);
        val result3 = solution.maxProfitV3(input);

        // then
        assertEquals(expected, result);
        assertEquals(expected, result2);
        assertEquals(expected, result3);
    }

    @Test
    public void example2() {

        // given
        val input = new int[]{1, 2, 3, 4, 5};
        val expected = 4;

        // when
        val result = solution.maxProfit(input);
        val result2 = solution.maxProfitV2(input);
        val result3 = solution.maxProfitV3(input);

        // then
        assertEquals(expected, result);
        assertEquals(expected, result2);
        assertEquals(expected, result3);
    }

    @Test
    public void example3() {

        // given
        val input = new int[]{7, 6, 4, 3, 1};
        val expected = 0;

        // when
        val result = solution.maxProfit(input);
        val result2 = solution.maxProfitV2(input);
        val result3 = solution.maxProfitV3(input);

        // then
        assertEquals(expected, result);
        assertEquals(expected, result2);
        assertEquals(expected, result3);
    }

}
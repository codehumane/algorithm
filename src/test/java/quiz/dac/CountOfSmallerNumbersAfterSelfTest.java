package quiz.dac;

import lombok.val;
import org.junit.jupiter.api.Test;
import quiz.dac.CountOfSmallerNumbersAfterSelf;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountOfSmallerNumbersAfterSelfTest {

    private final CountOfSmallerNumbersAfterSelf solution = new CountOfSmallerNumbersAfterSelf();

    @Test
    public void example1() {

        // given
        val nums = new int[]{5, 2, 6, 1};
        val expected = asList(2, 1, 1, 0);

        // when
        val result = solution.countSmaller(nums);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void example2() {

        // given
        val nums = new int[]{-1};
        val expected = singletonList(0);

        // when
        val result = solution.countSmaller(nums);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void example3() {

        // given
        val nums = new int[]{-1, -1};
        val expected = asList(0, 0);

        // when
        val result = solution.countSmaller(nums);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void custom1() {

        // given
        val nums = new int[]{5, 2, 5, 1};
        val expected = asList(2, 1, 1, 0);

        // when
        val result = solution.countSmaller(nums);

        // then
        assertEquals(expected, result, "중복 고려");
    }

    @Test
    public void custom2() {

        // given
        val nums = new int[]{5, 2, 5, 5, 5, 6, 1};
        val expected = asList(2, 1, 1, 1, 1, 1, 0);

        // when
        val result = solution.countSmaller(nums);

        // then
        assertEquals(expected, result, "중복 고려");
    }

}
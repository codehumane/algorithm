package quiz;

import com.google.common.collect.Lists;
import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindEventualSafeStatesTest {

    private final FindEventualSafeStates solution = new FindEventualSafeStates();

    @Test
    public void example1() {

        // given
        val expected = Lists.newArrayList(2, 4, 5, 6);
        val input = new int[][]{
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{5},
                new int[]{0},
                new int[]{5},
                new int[]{},
                new int[]{}
        };

        // when
        val result = solution.eventualSafeNodes(input);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void example2() {

        // given
        val expected = Lists.newArrayList(4);
        val input = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{1, 2},
                new int[]{3, 4},
                new int[]{0, 4},
                new int[]{}
        };

        // when
        val result = solution.eventualSafeNodes(input);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void failed1() {

        // given
        val expected = Lists.newArrayList(0, 1, 2, 3, 4);
        val input = new int[][]{
                new int[]{},
                new int[]{0, 2, 3, 4},
                new int[]{3},
                new int[]{4},
                new int[]{}
        };

        // when
        val result = solution.eventualSafeNodes(input);

        // then
        assertEquals(expected, result);
    }
}
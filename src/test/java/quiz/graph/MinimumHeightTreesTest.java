package quiz.graph;

import com.google.common.collect.Lists;
import lombok.val;
import org.junit.jupiter.api.Test;
import quiz.graph.MinimumHeightTrees;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumHeightTreesTest {

    private final MinimumHeightTrees solution = new MinimumHeightTrees();

    @Test
    public void example1() {

        // given
        val n = 4;
        val expected = Lists.newArrayList(1);
        val edges = new int[][]{
                new int[]{1, 0},
                new int[]{1, 2},
                new int[]{1, 3}
        };

        // when
        val result = solution.findMinHeightTrees(n, edges);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void example2() {

        // given
        val n = 6;
        val expected = Lists.newArrayList(3, 4);
        val edges = new int[][]{
                new int[]{3, 0},
                new int[]{3, 1},
                new int[]{3, 2},
                new int[]{3, 4},
                new int[]{5, 4}
        };

        // when
        val result = solution.findMinHeightTrees(n, edges);

        // then
        assertEquals(expected, result);
    }

}
package hackerrank.search;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SwapNodesTest {

    @Test
    public void swapNodesCase1() {

        // given
        final int[] expected = {2, 1, 3};
        final int[] queries = {1, 1};
        final int[][] indexes = {
                new int[]{2, 3},
                new int[]{-1, -1},
                new int[]{-1, -1}
        };

        // when
        final int[][] actual = SwapNodes.swapNodes(indexes, queries);

        // then
        assertArrayEquals(expected, actual[0]); // 임시 인덱스
    }

    @Test
    public void swapNodesCase2() {

        // given
        final int[] expected = {2, 4, 1, 3, 5};
        final int[] queries = {2};
        final int[][] indexes = {
                new int[]{2, 3},
                new int[]{-1, 4},
                new int[]{-1, 5},
                new int[]{-1, -1},
                new int[]{-1, -1}
        };

        // when
        final int[][] actual = SwapNodes.swapNodes(indexes, queries);

        // then
        assertArrayEquals(expected, actual[0]); // 임시 인덱스
    }

    @Test
    public void swapNodesCase3() {

        // given
        final int[] expected = {6, 9, 4, 2, 1, 7, 5, 10, 8, 11, 3};
        final int[] queries = {2, 4};
        final int[][] indexes = {
                new int[]{2, 3},
                new int[]{4, -1},
                new int[]{5, -1},
                new int[]{6, -1},
                new int[]{7, 8},
                new int[]{-1, 9},
                new int[]{-1, -1},
                new int[]{10, 11},
                new int[]{-1, -1},
                new int[]{-1, -1},
                new int[]{-1, -1}
        };

        // when
        final int[][] actual = SwapNodes.swapNodes(indexes, queries);

        // then
        assertArrayEquals(expected, actual[0]); // 임시 인덱스
    }

}
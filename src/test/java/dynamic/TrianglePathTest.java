package dynamic;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * {@link TrianglePath} test
 */
public class TrianglePathTest {

    @Test
    public void 숫자_하나만_주어진_경우() throws Exception {
        final int[][] input = {{1}};
        final int[] expected = {1};
        final int expectedSum = 1;

        assertArrayEquals(expected, TrianglePath.path(input));
        assertEquals(expectedSum, TrianglePath.sum(input));
    }

    @Test
    public void 숫자가_2행이고_첫번째_숫자들의_합이_최대인_경우() throws Exception {
        final int[][] input = {{1}, {3, 2}};
        final int[] expected = {1, 3};
        final int expectedSum = 4;

        assertArrayEquals(expected, TrianglePath.path(input));
        assertEquals(expectedSum, TrianglePath.sum(input));
    }

    @Test
    public void 숫자가_2행이고_1행에서는_첫번째_2행에서는_두번째_수의_합이_최대인_경우() throws Exception {
        final int[][] input = {{1}, {2, 4}};
        final int[] expected = {1, 4};
        final int expectedSum = 5;

        assertArrayEquals(expected, TrianglePath.path(input));
        assertEquals(expectedSum, TrianglePath.sum(input));
    }

    @Test
    public void 숫자가_3행이고_경로_인덱스가_0_0_0인_경우() throws Exception {
        final int[][] input = {{1}, {4, 3}, {6, 5, 4}};
        final int[] expected = {1, 4, 6};
        final int expectedSum = 11;

        assertArrayEquals(expected, TrianglePath.path(input));
        assertEquals(expectedSum, TrianglePath.sum(input));
    }

    @Test
    public void 숫자가_3행이고_경로_인덱스가_0_0_1인_경우() throws Exception {
        final int[][] input = {{1}, {2, 4}, {10, 2, 1}};
        final int[] expected = {1, 2, 10};
        final int expectedSum = 13;

        assertArrayEquals(expected, TrianglePath.path(input));
        assertEquals(expectedSum, TrianglePath.sum(input));
    }

    @Test
    public void 숫자가_3행이고_경로_인덱스가_0_1_1인_경우() throws Exception {
        final int[][] input = {{1}, {2, 4}, {3, 5, 4}};
        final int[] expected = {1, 4, 5};
        final int expectedSum = 10;

        assertArrayEquals(expected, TrianglePath.path(input));
        assertEquals(expectedSum, TrianglePath.sum(input));
    }

    @Test
    public void 숫자가_3행이고_경로_인덱스가_0_1_2인_경우() throws Exception {
        final int[][] input = {{1}, {2, 4}, {3, 6, 9}};
        final int[] expected = {1, 4, 9};
        final int expectedSum = 14;

        assertArrayEquals(expected, TrianglePath.path(input));
        assertEquals(expectedSum, TrianglePath.sum(input));
    }

    @Test
    public void 숫자가_5행이고_경로_인덱스가_0_1_2_2_2인_경우() throws Exception {
        final int[][] input = {{1}, {2, 4}, {3, 6, 9}, {1, 2, 3, 2}, {1, 2, 3, 2, 1}};
        final int[] expected = {1, 4, 9, 3, 3};
        final int expectedSum = 20;

        assertArrayEquals(expected, TrianglePath.path(input));
        assertEquals(expectedSum, TrianglePath.sum(input));
    }
}
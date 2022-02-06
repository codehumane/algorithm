package dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * {@link TrianglePath} test
 */
public class TrianglePathTest {

    @Test
    public void 숫자_하나만_주어진_경우() throws Exception {
        final int[][] input = {{1}};
        final int expected = 1;

        assertEquals(expected, TrianglePath.sum(input));
    }

    @Test
    public void 숫자가_2행이고_첫번째_숫자들의_합이_최대인_경우() throws Exception {
        final int[][] input = {{1}, {3, 2}};
        final int expected = 4;

        assertEquals(expected, TrianglePath.sum(input));
    }

    @Test
    public void 숫자가_2행이고_1행에서는_첫번째_2행에서는_두번째_수의_합이_최대인_경우() throws Exception {
        final int[][] input = {{1}, {2, 4}};
        final int expected = 5;

        assertEquals(expected, TrianglePath.sum(input));
    }

    @Test
    public void 숫자가_3행이고_경로_인덱스가_0_0_0인_경우() throws Exception {
        final int[][] input = {{1}, {4, 3}, {6, 5, 4}};
        final int expected = 11;

        assertEquals(expected, TrianglePath.sum(input));
    }

    @Test
    public void 숫자가_3행이고_경로_인덱스가_0_0_1인_경우() throws Exception {
        final int[][] input = {{1}, {2, 4}, {10, 2, 1}};
        final int expected = 13;

        assertEquals(expected, TrianglePath.sum(input));
    }

    @Test
    public void 숫자가_3행이고_경로_인덱스가_0_1_1인_경우() throws Exception {
        final int[][] input = {{1}, {2, 4}, {3, 5, 4}};
        final int expected = 10;

        assertEquals(expected, TrianglePath.sum(input));
    }

    @Test
    public void 숫자가_3행이고_경로_인덱스가_0_1_2인_경우() throws Exception {
        final int[][] input = {{1}, {2, 4}, {3, 6, 9}};
        final int expected = 14;

        assertEquals(expected, TrianglePath.sum(input));
    }

    @Test
    public void 숫자가_5행이고_경로_인덱스가_0_1_2_2_2인_경우() throws Exception {
        final int[][] input = {{1}, {2, 4}, {3, 6, 9}, {1, 2, 3, 2}, {1, 2, 3, 2, 1}};
        final int expected = 20;

        assertEquals(expected, TrianglePath.sum(input));
    }
}
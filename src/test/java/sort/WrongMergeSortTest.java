package sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WrongMergeSortTest {

    private WrongMergeSort sort = new WrongMergeSort();

    @Test
    public void run_값이_하나만_주어진_경우() throws Exception {

        // given
        final int[] input = {1};
        final int[] expected = {1};

        // when
        sort.run(input);

        // then
        assertArrayEquals(expected, input);
    }

    @Test
    public void run_값이_두개가_주어지고_순서가_뒤바뀐_경우() throws Exception {

        // given
        final int[] input = {2, 1};
        final int[] expected = {1, 2};

        // when
        sort.run(input);

        // then
        assertArrayEquals(expected, input);
    }

    @Test
    public void run_값이_3개인_경우() throws Exception {

        assertArrayEquals(new int[]{1, 2, 3}, sort.run(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{1, 2, 3}, sort.run(new int[]{1, 3, 2}));
        assertArrayEquals(new int[]{1, 2, 3}, sort.run(new int[]{2, 1, 3}));
        assertArrayEquals(new int[]{1, 2, 3}, sort.run(new int[]{2, 3, 1}));
        assertArrayEquals(new int[]{1, 2, 3}, sort.run(new int[]{3, 1, 2}));
        assertArrayEquals(new int[]{1, 2, 3}, sort.run(new int[]{3, 2, 1}));

        assertArrayEquals(new int[]{1, 2, 2}, sort.run(new int[]{2, 1, 2}));
        assertArrayEquals(new int[]{1, 2, 2}, sort.run(new int[]{2, 2, 1}));
        assertArrayEquals(new int[]{1, 2, 2}, sort.run(new int[]{1, 2, 2}));
    }

    @Test
    public void run_값이_4개인_경우() throws Exception {
        assertArrayEquals(new int[]{1, 2, 3, 4}, sort.run(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{1, 2, 3, 4}, sort.run(new int[]{1, 2, 4, 3}));
        assertArrayEquals(new int[]{1, 2, 3, 4}, sort.run(new int[]{1, 3, 2, 4}));
        assertArrayEquals(new int[]{1, 2, 3, 4}, sort.run(new int[]{1, 3, 4, 2}));
        assertArrayEquals(new int[]{1, 2, 3, 4}, sort.run(new int[]{1, 4, 2, 3}));
        assertArrayEquals(new int[]{1, 2, 3, 4}, sort.run(new int[]{1, 4, 3, 2}));
        assertArrayEquals(new int[]{1, 2, 3, 4}, sort.run(new int[]{2, 1, 3, 4}));
        assertArrayEquals(new int[]{1, 2, 3, 4}, sort.run(new int[]{2, 1, 4, 3}));
        assertArrayEquals(new int[]{1, 2, 3, 4}, sort.run(new int[]{2, 3, 1, 4}));
        assertArrayEquals(new int[]{1, 2, 3, 4}, sort.run(new int[]{2, 3, 4, 1}));
        assertArrayEquals(new int[]{1, 2, 3, 4}, sort.run(new int[]{2, 4, 1, 3}));
        assertArrayEquals(new int[]{1, 2, 3, 4}, sort.run(new int[]{2, 4, 3, 1}));
        assertArrayEquals(new int[]{1, 2, 3, 4}, sort.run(new int[]{4, 3, 2, 1}));
        assertArrayEquals(new int[]{1, 2, 3, 4}, sort.run(new int[]{4, 1, 3, 2}));
        assertArrayEquals(new int[]{1, 2, 3, 4}, sort.run(new int[]{4, 1, 2, 3}));
    }

    @Test
    public void run_값이_5개인_경우() throws Exception {
        assertArrayEquals(new int[]{1, 2, 2, 3, 5}, sort.run(new int[]{2, 1, 2, 5, 3}));
        assertArrayEquals(new int[]{1, 2, 2, 3, 5}, sort.run(new int[]{2, 1, 5, 3, 2}));
        assertArrayEquals(new int[]{1, 2, 2, 3, 5}, sort.run(new int[]{5, 2, 3, 2, 1}));
    }
}
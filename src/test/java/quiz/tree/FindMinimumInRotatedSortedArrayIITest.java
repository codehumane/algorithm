package quiz.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindMinimumInRotatedSortedArrayIITest {

    private final FindMinimumInRotatedSortedArrayII finder = new FindMinimumInRotatedSortedArrayII();

    @Test
    public void examples() {
        assertEquals(1, finder.findMin(new int[]{1, 3, 5}));
        assertEquals(0, finder.findMin(new int[]{2, 2, 2, 0, 1}));
    }

    @Test
    public void customs() {
        assertEquals(2, finder.findMin(new int[]{2, 2, 2}));
        assertEquals(2, finder.findMin(new int[]{2, 2, 2, 2}));
        assertEquals(0, finder.findMin(new int[]{0, 0, 0, 2}));
        assertEquals(0, finder.findMin(new int[]{0, 1, 2, 2}));
        assertEquals(0, finder.findMin(new int[]{0, 2, 2, 2}));
    }

    @Test
    public void customs_이진_분할_불가한_경우() {
        assertEquals(0, finder.findMin(new int[]{0, 2, 0}));
        assertEquals(0, finder.findMin(new int[]{2, 0, 2}));
    }

    @Test
    public void failed1() {
        assertEquals(1, finder.findMin(new int[]{1, 1}));
    }

    @Test
    public void failed2() {
        assertEquals(1, finder.findMin(new int[]{3, 1, 3}));
    }

    @Test
    public void failed3() {
        assertEquals(0, finder.findMin(new int[]{2, 0, 1, 1, 1}));
    }

    @Test
    public void failed4() {
        final int[] nums = {
                10, 10, 10, -10, -10, -10, -10, -9, -9, -9,
                -9, -9, -9, -9, -8, -8, -8, -8, -8, -8,
                -8, -8, -7, -7, -7, -7, -6, -6, -6, -5,
                -5, -5, -4, -4, -4, -4, -3, -3, -2, -2,
                -2, -2, -2, -2, -2, -2, -1, -1, -1, -1,
                -1, 0, 0, 0, 0, 0, 0, 0, 1, 1,
                1, 1, 2, 2, 2, 2, 2, 2, 2, 3,
                3, 3, 4, 4, 4, 5, 5, 5, 5, 6,
                6, 6, 7, 7, 7, 7, 7, 8, 8, 8,
                8, 9, 9, 9, 9, 9, 9, 9, 10, 10
        };
        assertEquals(-10, finder.findMin(nums));
    }
}
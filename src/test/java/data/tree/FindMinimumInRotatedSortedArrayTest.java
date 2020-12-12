package data.tree;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindMinimumInRotatedSortedArrayTest {

    private final FindMinimumInRotatedSortedArray min = new FindMinimumInRotatedSortedArray();

    @Test
    public void example1() {
        assertEquals(1, min.findMin(new int[]{3, 4, 5, 1, 2}));
    }

    @Test
    public void example2() {
        assertEquals(0, min.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    @Test
    public void example3() {
        assertEquals(11, min.findMin(new int[]{11, 13, 15, 17}));
    }

    @Test
    public void custom1() {
        assertEquals(1, min.findMin(new int[]{5, 1, 2, 3, 4}));
        assertEquals(1, min.findMin(new int[]{4, 5, 1, 2, 3}));
        assertEquals(1, min.findMin(new int[]{3, 4, 5, 1, 2}));
        assertEquals(1, min.findMin(new int[]{2, 3, 4, 5, 1}));
        assertEquals(1, min.findMin(new int[]{1, 2, 3, 4, 5}));
    }


}
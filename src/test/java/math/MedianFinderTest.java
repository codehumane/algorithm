package math;

import org.junit.Test;

import static org.junit.Assert.*;

public class MedianFinderTest {

    @Test
    public void run() throws Exception {
        assertEquals(3, MedianFinder.run(new int[]{3}));
        assertEquals(1, MedianFinder.run(new int[]{1, 3}));
        assertEquals(1, MedianFinder.run(new int[]{3, 1}));
        assertEquals(2, MedianFinder.run(new int[]{1, 2, 3}));
        assertEquals(2, MedianFinder.run(new int[]{3, 1, 2}));
        assertEquals(2, MedianFinder.run(new int[]{3, 2, 1}));
        assertEquals(2, MedianFinder.run(new int[]{3, 1, 3, 2}));
        assertEquals(3, MedianFinder.run(new int[]{3, 1, 3, 2, 3}));
        assertEquals(3, MedianFinder.run(new int[]{3, 1, 2, 4, 5}));
        assertEquals(4, MedianFinder.run(new int[]{3, 1, 7, 8, 9, 2, 4, 5}));
    }
}
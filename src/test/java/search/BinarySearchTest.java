package search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

    @Test
    public void search_x의_크기가_1이고_t가_x에_포함되지_않은_경우() throws Exception {
        assertEquals(-1, BinarySearch.search(new int[]{3}, 4));
    }

    @Test
    public void search_x의_크기가_1이고_t가_x에_포함된_경우() throws Exception {
        assertEquals(0, BinarySearch.search(new int[]{3}, 3));
    }

    @Test
    public void search_x의_크기가_4인_경우() throws Exception {
        assertEquals(0, BinarySearch.search(new int[]{2, 3, 4, 5}, 2));
        assertEquals(1, BinarySearch.search(new int[]{2, 3, 4, 5}, 3));
        assertEquals(2, BinarySearch.search(new int[]{2, 3, 4, 5}, 4));
        assertEquals(3, BinarySearch.search(new int[]{2, 3, 4, 5}, 5));
        assertEquals(-1, BinarySearch.search(new int[]{2, 3, 4, 5}, 777));
    }

    @Test
    public void search_x의_크기가_3인_경우() throws Exception {
        assertEquals(0, BinarySearch.search(new int[]{1, 2, 3}, 1));
        assertEquals(1, BinarySearch.search(new int[]{1, 2, 3}, 2));
        assertEquals(2, BinarySearch.search(new int[]{1, 2, 3}, 3));
        assertEquals(-1, BinarySearch.search(new int[]{1, 2, 3}, 999));
    }

    @Test
    public void search_x의_크기가_2인_경우() throws Exception {
        assertEquals(0, BinarySearch.search(new int[]{1, 2}, 1));
        assertEquals(1, BinarySearch.search(new int[]{1, 2}, 2));
        assertEquals(-1, BinarySearch.search(new int[]{1, 2}, 999));
    }
}
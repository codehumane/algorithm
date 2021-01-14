package quiz.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchInRotatedSortedArrayTest {

    private final SearchInRotatedSortedArray searcher = new SearchInRotatedSortedArray();

    @Test
    public void examples() {
        assertEquals(4, searcher.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(-1, searcher.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        assertEquals(-1, searcher.search(new int[]{1}, 0));
    }
}
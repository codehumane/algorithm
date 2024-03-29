package hackerrank.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumTimeRequiredTest {

    @Test
    public void minTime() {
        assertEquals(6, MinimumTimeRequired.minTime(new long[]{2, 3}, 5));
        assertEquals(8, MinimumTimeRequired.minTime(new long[]{2, 3, 2}, 10));
        assertEquals(7, MinimumTimeRequired.minTime(new long[]{1, 3, 4}, 10));
        assertEquals(20, MinimumTimeRequired.minTime(new long[]{4, 5, 6}, 12));
    }

}
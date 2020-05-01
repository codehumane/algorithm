package hackerrank.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TripleSumTest {

    @Test
    public void triplets() {

        assertEquals(
                4, // 1x0 + 2x2
                TripleSum.triplets(
                        new int[]{3, 5, 7},
                        new int[]{3, 6},
                        new int[]{4, 6, 9}
                )
        );

        assertEquals(
                8, // 1x2 + 2x3
                TripleSum.triplets(
                        new int[]{1, 3, 5},
                        new int[]{2, 3},
                        new int[]{1, 2, 3}
                )
        );

        assertEquals(
                5, // 1x2 + 1x3
                TripleSum.triplets(
                        new int[]{1, 4, 5},
                        new int[]{2, 3, 3},
                        new int[]{1, 2, 3}
                )
        );

        assertEquals(
                12, // 3x0 + 4x1 + 4x2
                TripleSum.triplets(
                        new int[]{1, 3, 5, 7},
                        new int[]{5, 7, 9},
                        new int[]{7, 9, 11, 13}
                )
        );

    }
}
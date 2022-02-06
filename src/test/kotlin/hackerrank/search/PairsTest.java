package hackerrank.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PairsTest {

    @Test
    public void test() {
        assertEquals(3, Pairs.pairs(2, new int[]{1, 5, 3, 4, 2}));
        assertEquals(3, Pairs.pairs(1, new int[]{1, 2, 3, 4}));
    }
}
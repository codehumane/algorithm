package math;

import math.EuclidExtended.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EuclidExtendedTest {

    @Test
    public void get() throws Exception {
        assertEquals(Result.of(-7, 10, 3), EuclidExtended.get(81, 57));
        assertEquals(Result.of(7, -4, 1), EuclidExtended.get(15, 26));
        assertEquals(Result.of(8, -17, 29), EuclidExtended.get(1914, 899));
    }
}
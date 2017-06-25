package math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EuclidGcdTest {

    @Test
    public void run() throws Exception {
        assertEquals(2, EuclidGcd.run(2, 4));
        assertEquals(3, EuclidGcd.run(3, 6));
        assertEquals(2, EuclidGcd.run(4, 6));
        assertEquals(4*7, EuclidGcd.run(4*3*7, 4*2*7));
        assertEquals(5*3*2, EuclidGcd.run(5*5*3*2, 5*3*2*7));
    }
}
package math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GCDTest {

    @Test
    public void run() throws Exception {
        assertEquals(2, GCD.run(2, 4));
        assertEquals(3, GCD.run(3, 6));
        assertEquals(2, GCD.run(4, 6));
        assertEquals(4*7, GCD.run(4*3*7, 4*2*7));
        assertEquals(5*3*2, GCD.run(5*5*3*2, 5*3*2*7));
    }
}
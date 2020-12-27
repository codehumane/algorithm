package quiz.tree;

import org.junit.Test;
import quiz.tree.Pow;

import static org.junit.Assert.*;

public class PowTest {

    private final Pow pow = new Pow();

    @Test
    public void example1() {
        assertEquals(1024.00000, pow.myPow(2.00000, 10), 0.0000000001);
    }

    @Test
    public void example2() {
        assertEquals(9.26100, pow.myPow(2.10000, 3), 0.0000000001);
    }

    @Test
    public void example3() {
        assertEquals(0.25000, pow.myPow(2.00000, -2), 0);
    }

    @Test
    public void failed1() {
        assertEquals(1.00000, pow.myPow(1.00000, -2147483648), 0);
    }
}
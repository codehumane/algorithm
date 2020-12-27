package quiz.tree;

import org.junit.Test;
import quiz.tree.ValidPerfectSquare;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidPerfectSquareTest {

    private final ValidPerfectSquare square = new ValidPerfectSquare();

    @Test
    public void example1() {
        assertTrue(square.isPerfectSquare(16));
    }

    @Test
    public void example2() {
        assertFalse(square.isPerfectSquare(14));
    }

    @Test
    public void failed1() {
        assertFalse(square.isPerfectSquare(2147483647));
    }
}
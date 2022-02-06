package quiz.tree;

import org.junit.jupiter.api.Test;
import quiz.tree.ValidPerfectSquare;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
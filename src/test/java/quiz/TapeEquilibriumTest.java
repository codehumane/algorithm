package quiz;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TapeEquilibriumTest {

    @Test
    public void solution() throws Exception {
        val tape = new TapeEquilibrium();

        assertEquals(1, tape.solution(new int[]{3, 1, 2, 4, 3}));
        assertEquals(1, tape.solution(new int[]{6, 1, 1, 4, 3}));
        assertEquals(199, tape.solution(new int[]{1, 200}));
        assertEquals(3, tape.solution(new int[]{-1, 0, 2}));
        assertEquals(1, tape.solution(new int[]{-1, 2, -4}));
        assertEquals(1, tape.solution(new int[]{-1, -4, 2}));
    }
}
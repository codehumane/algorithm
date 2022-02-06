package quiz;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FrogJumpTest {

    @Test
    public void solution() throws Exception {
        val jump = new FrogJump();

        assertEquals(3, jump.solution(10, 85, 30));
        assertEquals(3, jump.solution(10, 99, 30));
        assertEquals(3, jump.solution(10, 100, 30));
        assertEquals(4, jump.solution(10, 101, 30));
    }
}
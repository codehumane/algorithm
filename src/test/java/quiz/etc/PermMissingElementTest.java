package quiz.etc;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermMissingElementTest {

    @Test
    public void solution() throws Exception {
        val el = new PermMissingElement();

        assertEquals(4, el.solution(new int[]{2, 3, 1, 5}));
        assertEquals(1, el.solution(new int[]{2, 3, 4, 5}));
        assertEquals(1, el.solution(new int[]{2}));
        assertEquals(2, el.solution(new int[]{1}));
        assertEquals(1, el.solution(new int[]{}));
    }

}
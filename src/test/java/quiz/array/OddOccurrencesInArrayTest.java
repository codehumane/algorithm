package quiz.array;

import lombok.val;
import org.junit.jupiter.api.Test;
import quiz.array.OddOccurrencesInArray;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OddOccurrencesInArrayTest {

    @Test
    public void solution() throws Exception {
        val odd = new OddOccurrencesInArray();
        assertEquals(1, odd.solution(new int[]{1}));
        assertEquals(3, odd.solution(new int[]{1, 3, 1}));
        assertEquals(1, odd.solution(new int[]{1, 7, 7, 7, 7}));
        assertEquals(7, odd.solution(new int[]{1, 7, 3, 1, 3}));
        assertEquals(7, odd.solution(new int[]{1, 7, 3, 1, 3, 5, 9, 9, 5, 1, 3, 1, 3}));

        // 사실 짝수여도 상관 없다. 트릭인 듯.
        assertEquals(2, odd.solution(new int[]{1, 2, 1}));
        assertEquals(8, odd.solution(new int[]{1, 7, 8, 7, 1}));
    }

}
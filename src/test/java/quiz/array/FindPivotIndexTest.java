package quiz.array;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindPivotIndexTest {

    private final FindPivotIndex finder = new FindPivotIndex();

    @Test
    public void example1() {
        val input = new int[]{1, 7, 3, 6, 5, 6};
        val result = finder.pivotIndex(input);
        assertEquals(3, result);
    }

    @Test
    public void example2() {
        val input = new int[]{1, 2, 3};
        val result = finder.pivotIndex(input);
        assertEquals(-1, result);
    }

    @Test
    public void custom1() {
        val input = new int[]{1};
        val result = finder.pivotIndex(input);
        assertEquals(0, result);
    }

    @Test
    public void custom2() {
        val input = new int[]{1, 2};
        val result = finder.pivotIndex(input);
        assertEquals(-1, result);
    }

    @Test
    public void custom3() {
        val input = new int[]{1, 0};
        val result = finder.pivotIndex(input);
        assertEquals(0, result);
    }

    @Test
    public void custom4() {
        val input = new int[]{1, 0, 1};
        val result = finder.pivotIndex(input);
        assertEquals(1, result);
    }

    /**
     * custom3과 반대 케이스 (반대쪽 에지 케이스 고려 못 함)
     */
    @Test
    public void failed1() {
        val input = new int[]{-1, -1, 0, 1, 1, 0};
        val result = finder.pivotIndex(input);
        assertEquals(5, result);
    }
}
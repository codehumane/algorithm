package quiz.array;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LargestNumberAtLeastTwiceOfOthersTest {

    private final LargestNumberAtLeastTwiceOfOthers dominant = new LargestNumberAtLeastTwiceOfOthers();

    @Test
    public void example1() {
        val input = new int[]{3, 6, 1, 0};
        val output = dominant.dominantIndex(input);
        assertEquals(1, output);
    }

    @Test
    public void example2() {
        val input = new int[]{1, 2, 3, 4};
        val output = dominant.dominantIndex(input);
        assertEquals(-1, output);
    }

    @Test
    public void custom1() {
        val input = new int[]{1};
        val output = dominant.dominantIndex(input);
        assertEquals("원소가 1개인 경우는 0 반환", 0, output);
    }

    @Test
    public void custom2() {
        val input = new int[]{1, 2};
        val output = dominant.dominantIndex(input);
        assertEquals("딱 2배인 경우도 dominant로 판단해야 한다", 1, output);
    }

    @Test
    public void custom3() {
        val input = new int[]{2, 1};
        val output = dominant.dominantIndex(input);
        assertEquals("첫 번째 원소가 대상인 경우", 0, output);
    }

    @Test
    public void failed1() {
        val input = new int[]{0, 0, 3, 2};
        val output = dominant.dominantIndex(input);
        assertEquals(-1, output);
    }
}
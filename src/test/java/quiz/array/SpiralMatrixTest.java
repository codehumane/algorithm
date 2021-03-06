package quiz.array;

import com.google.common.collect.Lists;
import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpiralMatrixTest {

    private final SpiralMatrix matrix = new SpiralMatrix();

    @Test
    public void example1() {

        // given
        val expected = Lists.newArrayList(1, 2, 3, 6, 9, 8, 7, 4, 5);
        val input = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };

        // when
        val output = matrix.spiralOrder(input);

        // then
        assertEquals(expected, output);
    }

    @Test
    public void example2() {
        // given
        val expected = Lists.newArrayList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
        val input = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12}
        };

        // when
        val output = matrix.spiralOrder(input);

        // then
        assertEquals(expected, output);
    }
}
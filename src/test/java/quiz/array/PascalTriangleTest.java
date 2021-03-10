package quiz.array;

import com.google.common.collect.ImmutableList;
import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PascalTriangleTest {

    private final PascalTriangle pascal = new PascalTriangle();

    @Test
    public void row1() {
        val expected = ImmutableList.of(ImmutableList.of(1));
        assertEquals(expected, pascal.generate(1));
    }

    @Test
    public void row2() {
        val expected = ImmutableList.of(
                ImmutableList.of(1),
                ImmutableList.of(1, 1)
        );

        assertEquals(expected, pascal.generate(2));
    }

    @Test
    public void row3() {
        val expected = ImmutableList.of(
                ImmutableList.of(1),
                ImmutableList.of(1, 1),
                ImmutableList.of(1, 2, 1)
        );

        assertEquals(expected, pascal.generate(3));
    }

    @Test
    public void row4() {
        val expected = ImmutableList.of(
                ImmutableList.of(1),
                ImmutableList.of(1, 1),
                ImmutableList.of(1, 2, 1),
                ImmutableList.of(1, 3, 3, 1)
        );

        assertEquals(expected, pascal.generate(4));
    }

    @Test
    public void row5() {
        val expected = ImmutableList.of(
                ImmutableList.of(1),
                ImmutableList.of(1, 1),
                ImmutableList.of(1, 2, 1),
                ImmutableList.of(1, 3, 3, 1),
                ImmutableList.of(1, 4, 6, 4, 1)
        );

        assertEquals(expected, pascal.generate(5));
    }

    @Test
    public void row6() {
        val expected = ImmutableList.of(
                ImmutableList.of(1),
                ImmutableList.of(1, 1),
                ImmutableList.of(1, 2, 1),
                ImmutableList.of(1, 3, 3, 1),
                ImmutableList.of(1, 4, 6, 4, 1),
                ImmutableList.of(1, 5, 10, 10, 5, 1)
        );

        assertEquals(expected, pascal.generate(6));
    }

}
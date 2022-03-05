package quiz.etc;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class TwoZeroFourEightTest {

    @Test
    public void play() {

        // given
        val expected = 16;
        val input = new int[][]{
                new int[]{2, 2, 2},
                new int[]{4, 4, 4},
                new int[]{8, 8, 8}
        };

        // when
        val output = TwoZeroFourEight.play(input);

        // then
        assertEquals(expected, output);
    }

    @Test
    public void play2() {

        // given
        val expected = 4;
        val input = new int[][]{
                new int[]{0, 0, 2, 0},
                new int[]{0, 0, 0, 0},
                new int[]{2, 0, 0, 0},
                new int[]{0, 0, 0, 0}
        };

        // when
        val output = TwoZeroFourEight.play(input);

        // then
        assertEquals(expected, output);
    }

    @Test
    public void play3() {

        // given
        val expected = 8;
        val input = new int[][]{
                new int[]{4, 2, 0, 0},
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 0, 0},
                new int[]{2, 0, 0, 0}
        };

        // when
        val output = TwoZeroFourEight.play(input);

        // then
        assertEquals(expected, output);
    }

    @Test
    public void play4() {

        // given
        val expected = 16;
        val input = new int[][]{
                new int[]{2, 0, 2, 8},
                new int[]{0, 0, 2, 2},
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 0, 0}
        };

        // when
        val output = TwoZeroFourEight.play(input);

        // then
        assertEquals(expected, output);
    }

    @Test
    public void play5() {

        // given
        val expected = 2;
        val input = new int[][]{
                new int[]{2}
        };

        // when
        val output = TwoZeroFourEight.play(input);

        // then
        assertEquals(expected, output);
    }

    @Test
    public void up() {
        val output = TwoZeroFourEight.up(new int[][]{
                new int[]{2, 2, 0, 2},
                new int[]{2, 2, 4, 4},
                new int[]{2, 8, 4, 2},
                new int[]{2, 8, 4, 4}
        });
        assertArrayEquals(
                new int[][]{
                        new int[]{4, 4, 8, 2},
                        new int[]{4, 16, 4, 4},
                        new int[]{0, 0, 0, 2},
                        new int[]{0, 0, 0, 4}
                },
                output
        );
    }

    @Test
    public void down() {
        val output = TwoZeroFourEight.down(new int[][]{
                new int[]{2, 2, 0, 2},
                new int[]{2, 2, 4, 4},
                new int[]{2, 8, 4, 2},
                new int[]{2, 8, 4, 4}
        });
        assertArrayEquals(
                new int[][]{
                        new int[]{0, 0, 0, 2},
                        new int[]{0, 0, 0, 4},
                        new int[]{4, 4, 4, 2},
                        new int[]{4, 16, 8, 4}
                },
                output
        );
    }

    @Test
    public void right() {
        val output = TwoZeroFourEight.right(new int[][]{
                new int[]{2, 2, 0, 2},
                new int[]{2, 2, 4, 4},
                new int[]{2, 8, 4, 2},
                new int[]{2, 8, 4, 4}
        });
        assertArrayEquals(
                new int[][]{
                        new int[]{0, 0, 2, 4},
                        new int[]{0, 0, 4, 8},
                        new int[]{2, 8, 4, 2},
                        new int[]{0, 2, 8, 8}
                },
                output
        );
    }

    @Test
    public void left() {
        val output = TwoZeroFourEight.left(new int[][]{
                new int[]{2, 2, 0, 2},
                new int[]{2, 2, 4, 4},
                new int[]{2, 8, 4, 2},
                new int[]{2, 8, 4, 4}
        });
        assertArrayEquals(
                new int[][]{
                        new int[]{4, 2, 0, 0},
                        new int[]{4, 8, 0, 0},
                        new int[]{2, 8, 4, 2},
                        new int[]{2, 8, 8, 0}
                },
                output
        );
    }

    @Test
    public void down5() {

        // given
        val input = new int[][]{
                new int[]{0, 0, 2, 0},
                new int[]{0, 0, 0, 0},
                new int[]{2, 0, 0, 0},
                new int[]{0, 0, 0, 0}
        };

        // when
        final int[][] down1 = TwoZeroFourEight.down(input);
        final int[][] down2 = TwoZeroFourEight.down(down1);
        final int[][] down3 = TwoZeroFourEight.down(down2);
        final int[][] down4 = TwoZeroFourEight.down(down3);
        final int[][] down5 = TwoZeroFourEight.down(down4);

        // then
        log.info("{}", Arrays.deepToString(down5));
    }

}
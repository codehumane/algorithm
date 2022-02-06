package quiz.array;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class DiagonalTraverseTest {

    private final DiagonalTraverse traverse = new DiagonalTraverse();

    @Test
    public void example() {
        final int[][] input = {
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };
        final int[] output = new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9};
        final int[] result = traverse.findDiagonalOrder(input);
        Assertions.assertArrayEquals(output, result);
    }

    @Test
    public void bigger() {
        final int[][] input = {
                new int[]{1, 2, 3, 4, 5},
                new int[]{6, 7, 8, 9, 10},
                new int[]{11, 12, 13, 14, 15},
                new int[]{16, 17, 18, 19, 20},
                new int[]{21, 22, 23, 24, 25}
        };
        final int[] output = new int[]{1, 2, 6, 11, 7, 3, 4, 8, 12, 16, 21, 17, 13, 9, 5, 10, 14, 18, 22, 23, 19, 15, 20, 24, 25};
        final int[] result = traverse.findDiagonalOrder(input);
        Assertions.assertArrayEquals(output, result);
    }

    @Test
    public void horizontal() {
        final int[][] input = {
                new int[]{1, 2, 3, 4, 5},
                new int[]{6, 7, 8, 9, 10}
        };

        final int[] output = new int[]{1, 2, 6, 7, 3, 4, 8, 9, 5, 10};
        final int[] result = traverse.findDiagonalOrder(input);
        Assertions.assertArrayEquals(output, result);
    }

    @Test
    public void vertical() {
        final int[][] input = {
                new int[]{1, 2},
                new int[]{3, 4},
                new int[]{5, 6},
                new int[]{7, 8},
                new int[]{9, 10}
        };

        final int[] output = new int[]{1, 2, 3, 5, 4, 6, 7, 9, 8, 10};
        final int[] result = traverse.findDiagonalOrder(input);
        Assertions.assertArrayEquals(output, result);
    }
}

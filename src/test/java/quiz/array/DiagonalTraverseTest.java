package quiz.array;

import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertArrayEquals(output, result);
    }

    @Test
    public void custom1() {
        final int[][] input = {
                new int[]{1, 2, 3, 4, 5},
                new int[]{6, 7, 8, 9, 10},
                new int[]{11, 12, 13, 14, 15},
                new int[]{16, 17, 18, 19, 20},
                new int[]{21, 22, 23, 24, 25}
        };
        final int[] output = new int[]{1, 2, 6, 11, 7, 3, 4, 8, 12, 16, 21, 17, 13, 9, 5, 10, 14, 18, 22, 23, 19, 15, 20, 24, 25};
        final int[] result = traverse.findDiagonalOrder(input);
        Assert.assertArrayEquals(output, result);
    }

}

package quiz.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a matrix of M x N elements (M rows, N columns),
 * return all elements of the matrix in diagonal order as shown in the below image.
 */
public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        final int[] first = firstVersion(matrix);
        final int[] reverse = byReverse(matrix);

        if (!Arrays.equals(first, reverse)) {
            throw new IllegalStateException();
        }
        
        return reverse;
    }

    private int[] byReverse(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[]{};

        final int M = matrix.length; // rows
        final int N = matrix[0].length; // columns

        int index = 0;
        final int[] result = new int[M * N];
        final List<Integer> temp = new ArrayList<>();

        for (int step = 0; step < M + N - 1; step++) {
            int row = (step < N) ? 0 : step - N + 1;
            int col = (step < N) ? step : N - 1;
            temp.clear();

            while (row < M && col >= 0) temp.add(matrix[row++][col--]);
            if (step % 2 == 0) Collections.reverse(temp);
            for (Integer t : temp) result[index++] = t;
        }

        return result;
    }

    private int[] firstVersion(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[]{};

        int x = 0;
        int y = 0;
        boolean upRight = true;
        final int xMax = matrix[0].length - 1;
        final int yMax = matrix.length - 1;
        final int[] traverse = new int[(xMax + 1) * (yMax + 1)];
        int index = 0;

        while (x + y <= xMax + yMax) {
            traverse[index++] = matrix[y][x];

            if (upRight) {
                if (x == xMax) {
                    upRight = false;
                    y++;
                } else if (y == 0) {
                    upRight = false;
                    x++;
                } else {
                    x++;
                    y--;
                }
            } else {
                if (y == yMax) {
                    upRight = true;
                    x++;
                } else if (x == 0) {
                    upRight = true;
                    y++;
                } else {
                    y++;
                    x--;
                }
            }
        }

        return traverse;
    }

}
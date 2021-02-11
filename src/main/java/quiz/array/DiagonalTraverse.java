package quiz.array;

/**
 * Given a matrix of M x N elements (M rows, N columns),
 * return all elements of the matrix in diagonal order as shown in the below image.
 */
public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[]{};

        final int xMax = matrix.length - 1;
        final int yMax = matrix[0].length - 1;
        final int[] traverse = new int[(xMax + 1) * (yMax + 1)];
        int index = 0;

        for (int i = 0; i <= xMax + yMax; i++) {

            final boolean even = i % 2 == 0;
            int x = even ? Math.max(0, i - yMax) : Math.min(i, xMax);
            int y = even ? Math.min(i, yMax) : Math.max(0, i - xMax);

            if (even) {
                for (int j = y; j >= x; j--) {
                    traverse[index++] = matrix[j][x + y - j];
                }
            } else {
                for (int j = x; j >= y; j--) {
                    traverse[index++] = matrix[x + y - j][j];
                }
            }

        }

        return traverse;
    }

}
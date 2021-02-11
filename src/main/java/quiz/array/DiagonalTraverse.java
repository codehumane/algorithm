package quiz.array;

/**
 * Given a matrix of M x N elements (M rows, N columns),
 * return all elements of the matrix in diagonal order as shown in the below image.
 */
public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {
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
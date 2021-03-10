package quiz.array;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 * https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1168/
 */
@Slf4j
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        final int rows = matrix.length;
        final int cols = matrix[0].length;
        final List<Integer> order = new ArrayList<>(rows * cols);

        int colFrom = 0;
        int rowFrom = 0;
        int colTo = cols - 1;
        int rowTo = rows - 1;

        while (order.size() < rows * cols) {

            for (int i = colFrom; i <= colTo; i++) {
                order.add(matrix[rowFrom][i]);
            }

            rowFrom++;

            for (int i = rowFrom; i <= rowTo; i++) {
                order.add(matrix[i][colTo]);
            }

            colTo--;

            for (int i1 = colTo; i1 >= colFrom; i1--) {
                order.add(matrix[rowTo][i1]);
            }

            rowTo--;

            for (int i = rowTo; i >= rowFrom; i--) {
                order.add(matrix[i][colFrom]);
            }

            colFrom++;
        }

        return order;
    }

}

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
        final TraceState state = new TraceState(0, 0, cols - 1, rows - 1, Direction.RIGHT);
        final List<Integer> order = new ArrayList<>(rows * cols);

        while (order.size() < rows * cols) {
            trace(matrix, order, state);
        }

        return order;
    }

    private void trace(int[][] matrix, List<Integer> order, TraceState state) {
        switch (state.direction) {
            case RIGHT:
                traceToRight(matrix, order, state);
                break;
            case DOWN:
                traceToDown(matrix, order, state);
                break;
            case LEFT:
                traceToLeft(matrix[state.rowTo], order, state);
                break;
            case UP:
                traceToUp(matrix, order, state);
                break;
        }
    }

    private void traceToUp(int[][] matrix, List<Integer> order, TraceState state) {
        for (int i = state.rowTo; i >= state.rowFrom; i--) {
            order.add(matrix[i][state.colFrom]);
        }
        state.direction = Direction.RIGHT;
        state.colFrom++;
    }

    private void traceToLeft(int[] matrix, List<Integer> order, TraceState state) {
        for (int i = state.colTo; i >= state.colFrom; i--) {
            order.add(matrix[i]);
        }
        state.direction = Direction.UP;
        state.rowTo--;
    }

    private void traceToDown(int[][] matrix, List<Integer> order, TraceState state) {
        for (int i = state.rowFrom; i <= state.rowTo; i++) {
            order.add(matrix[i][state.colTo]);
        }
        state.direction = Direction.LEFT;
        state.colTo--;
    }

    private void traceToRight(int[][] matrix, List<Integer> order, TraceState state) {
        for (int i = state.colFrom; i <= state.colTo; i++) {
            order.add(matrix[state.rowFrom][i]);
        }
        state.direction = Direction.DOWN;
        state.rowFrom++;
    }

    static class TraceState {

        int colFrom;
        int rowFrom;
        int colTo;
        int rowTo;
        Direction direction;

        public TraceState(int colFrom, int rowFrom, int colTo, int rowTo, Direction direction) {
            this.colFrom = colFrom;
            this.rowFrom = rowFrom;
            this.colTo = colTo;
            this.rowTo = rowTo;
            this.direction = direction;
        }
    }

    enum Direction {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }

}

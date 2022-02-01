package quiz.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/path-with-minimum-effort/
 */
public class PathWithMinimumEffort {

    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;
        final Set<Position> visited = new HashSet<>();
        final Map<Position, Integer> efforts = initEfforts(rows, cols);
        final Map<Position, Position> froms = new HashMap<>();
        final Position goal = new Position(rows - 1, cols - 1);

        efforts.put(new Position(0, 0), 0);

        while (visited.size() < rows * cols) {
            Position position = findMinEffortPosition(efforts, visited);
            visited.add(position);

            updateEffort(position, -1, 0, efforts, heights, froms, visited);
            updateEffort(position, +1, 0, efforts, heights, froms, visited);
            updateEffort(position, 0, -1, efforts, heights, froms, visited);
            updateEffort(position, 0, +1, efforts, heights, froms, visited);
        }

        return calculateFinalEffort(efforts, froms, goal);
    }

    private Map<Position, Integer> initEfforts(int rows, int cols) {
        final Map<Position, Integer> efforts = new HashMap<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                efforts.put(new Position(r, c), Integer.MAX_VALUE);
            }
        }

        return efforts;
    }

    private Position findMinEffortPosition(Map<Position, Integer> efforts,
                                           Set<Position> visited) {

        Position min = null;

        for (Map.Entry<Position, Integer> e : efforts.entrySet()) {
            if (visited.contains(e.getKey())) continue;

            if (min == null) {
                min = e.getKey();
            }

            if (efforts.get(min) > e.getValue()) {
                min = e.getKey();
            }
        }

        return min;
    }

    private void updateEffort(Position me,
                              int moveRow,
                              int moveCol,
                              Map<Position, Integer> efforts,
                              int[][] heights,
                              Map<Position, Position> froms,
                              Set<Position> visited) {

        Position target = me.move(moveRow, moveCol);

        if (target.row < 0) return;
        if (target.col < 0) return;
        if (target.row >= heights.length) return;
        if (target.col >= heights[0].length) return;
        if (visited.contains(target)) return;

        final int meHeight = heights[me.row][me.col];
        final int targetHeight = heights[target.row][target.col];
        final int effort = Math.abs(meHeight - targetHeight);

        if (effort < efforts.get(target)) {
            efforts.put(target, effort);
            froms.put(target, me);
        }
    }

    private int calculateFinalEffort(Map<Position, Integer> efforts,
                                     Map<Position, Position> froms,
                                     Position goal) {

        int maxEffort = efforts.get(goal);
        Position start = froms.get(goal);

        while (start != null) {
            maxEffort = Math.max(efforts.get(start), maxEffort);
            start = froms.get(start);
        }

        return maxEffort;
    }

    private static class Position {
        final int row;
        final int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        Position move(int rowStep, int colStep) {
            return new Position(row + rowStep, col + colStep);
        }

        @Override
        public String toString() {
            return "Position{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return row == position.row && col == position.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}

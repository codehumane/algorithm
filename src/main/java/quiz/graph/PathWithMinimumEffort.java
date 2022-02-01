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
        final PriorityQueue<Effort> efforts = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        final Map<Position, Effort> froms = new HashMap<>();
        final Position goal = new Position(rows - 1, cols - 1);

        efforts.offer(new Effort(new Position(0, 0), 0));

        while (!efforts.isEmpty()) {
            final Effort effort = efforts.remove();

            if (visited.contains(effort.position)) continue;
            visited.add(effort.position);

            updateEffort(effort.position, -1, 0, efforts, heights, froms, visited);
            updateEffort(effort.position, +1, 0, efforts, heights, froms, visited);
            updateEffort(effort.position, 0, -1, efforts, heights, froms, visited);
            updateEffort(effort.position, 0, +1, efforts, heights, froms, visited);
        }

        return calculateFinalEffort(froms, goal);
    }

    private void updateEffort(Position me,
                              int moveRow,
                              int moveCol,
                              Queue<Effort> efforts,
                              int[][] heights,
                              Map<Position, Effort> froms,
                              Set<Position> visited) {

        Position target = me.move(moveRow, moveCol);

        if (target.row < 0) return;
        if (target.col < 0) return;
        if (target.row >= heights.length) return;
        if (target.col >= heights[0].length) return;
        if (visited.contains(target)) return;

        final int meHeight = heights[me.row][me.col];
        final int targetHeight = heights[target.row][target.col];
        final int diff = Math.abs(meHeight - targetHeight);

        efforts.offer(new Effort(target, diff));

        froms.computeIfPresent(target, (x, e) -> e.value < diff ? e : new Effort(me, diff));
        froms.putIfAbsent(target, new Effort(me, diff));
    }

    private int calculateFinalEffort(Map<Position, Effort> froms,
                                     Position goal) {

        int maxEffort = 0;
        Effort start = froms.get(goal);

        while (start != null) {
            maxEffort = Math.max(start.value, maxEffort);
            start = froms.get(start.position);
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

    private static class Effort {
        final Position position;
        final int value;

        Effort(Position position, int value) {
            this.position = position;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Effort effort = (Effort) o;
            return value == effort.value && Objects.equals(position, effort.position);
        }

        @Override
        public int hashCode() {
            return Objects.hash(position, value);
        }
    }
}

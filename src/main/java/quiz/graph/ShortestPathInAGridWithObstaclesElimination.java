package quiz.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ShortestPathInAGridWithObstaclesElimination {

    public int shortestPath(int[][] grid, int k) {

        var shortest = -1;
        var obstacles = obstacles(grid);
        var maxRemoval = Math.min(obstacles.size(), k);

        for (int n = 1; n <= maxRemoval; n++) {
            var removals = combinations(obstacles, n);

            for (Coordinate[] r : removals) {
                var simulation = simluateObstacleRemomved(grid, r);
                var path = explore(simulation);

                if (path != -1) {
                    shortest = (shortest == -1) ? path : Math.min(shortest, path);
                }
            }
        }

        return shortest;
    }

    private List<Coordinate> obstacles(int[][] grid) {
        var obstacles = new ArrayList<Coordinate>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    obstacles.add(new Coordinate(r, c));
                }
            }
        }

        return obstacles;
    }

    List<Coordinate[]> combinations(List<Coordinate> obstacles, int n) {
        var combination = new ArrayList<Coordinate[]>();

        if (n == 0) {
            combination.add(new Coordinate[0]);
            return combination;
        }

        combine(
                obstacles,
                combination,
                new Coordinate[n],
                0,
                0,
                n
        );

        return combination;
    }

    private void combine(List<Coordinate> candidate,
                         List<Coordinate[]> combination,
                         Coordinate[] temp,
                         int from,
                         int ordinal,
                         int count) {


        if (ordinal == count) {
            combination.add(temp.clone());
            return;
        }

        var to = candidate.size() - count + ordinal;

        for (int i = from; i <= to; i++) {
            temp[ordinal] = candidate.get(i);

            combine(
                    candidate,
                    combination,
                    temp,
                    i + 1,
                    ordinal + 1,
                    count
            );
        }
    }

    private int[][] simluateObstacleRemomved(int[][] grid, Coordinate[] r) {
        var simulation = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            simulation[i] = grid[i].clone();
        }

        for (Coordinate c : r) {
            simulation[c.row][c.col] = 0;
        }

        return simulation;
    }

    private int explore(int[][] grid) {
        var start = new Coordinate(0, 0);
        var goal = new Coordinate(grid.length - 1, grid[0].length - 1);
        var visit = new HashMap<Coordinate, Integer>();

        explore(start, visit, 0, grid);
        return visit.getOrDefault(goal, -1);
    }

    private void explore(Coordinate now,
                         Map<Coordinate, Integer> visit,
                         int pathLength,
                         int[][] grid) {

        if (now.row < 0 || now.row >= grid.length) return;
        if (now.col < 0 || now.col >= grid[0].length) return;
        if (visit.containsKey(now) && visit.get(now) <= pathLength) return;
        if (grid[now.row][now.col] == 1) return;

        visit.put(now, pathLength);

        explore(now.up(), visit, pathLength + 1, grid);
        explore(now.down(), visit, pathLength + 1, grid);
        explore(now.left(), visit, pathLength + 1, grid);
        explore(now.right(), visit, pathLength + 1, grid);
    }

    static class Coordinate {

        int row;
        int col;

        Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        Coordinate up() {
            return new Coordinate(row - 1, col);
        }

        Coordinate down() {
            return new Coordinate(row + 1, col);
        }

        Coordinate left() {
            return new Coordinate(row, col - 1);
        }

        Coordinate right() {
            return new Coordinate(row, col + 1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Coordinate that = (Coordinate) o;

            if (row != that.row) return false;
            return col == that.col;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            return result;
        }

        @Override
        public String toString() {
            return String.format("(%d,%d)", row, col);
        }
    }

}

package quiz.graph;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathInAGridWithObstaclesElimination {

    public int shortestPath(int[][] grid, int k) {
        return -1;
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

    static class Coordinate {

        int row;
        int col;

        Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
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

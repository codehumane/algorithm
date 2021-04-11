package quiz.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an m x n 2D binary grid grid
 * which represents a map of '1's (land) and '0's (water),
 * return the number of islands.<br/>
 * <br/>
 * An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.<br/>
 * <br/>
 * https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1374/
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        final Set<Coordinate> visited = new HashSet<>();
        int islands = 0;

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                final boolean isIsland = visitIsland(grid, x, y, visited);
                if (isIsland) islands++;
            }
        }

        return islands;
    }

    private boolean visitIsland(char[][] grid,
                                int x,
                                int y,
                                Set<Coordinate> visited) {

        final Coordinate root = new Coordinate(x, y);
        if (visited.contains(root)) return false;
        if (grid[y][x] == '0') return false;

        final Deque<Coordinate> queue = new ArrayDeque<>();
        queue.offer(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            final Coordinate coordinate = queue.poll();

            offerQueue(queue, visited, grid, new Coordinate(coordinate.x, coordinate.y - 1));
            offerQueue(queue, visited, grid, new Coordinate(coordinate.x, coordinate.y + 1));
            offerQueue(queue, visited, grid, new Coordinate(coordinate.x - 1, coordinate.y));
            offerQueue(queue, visited, grid, new Coordinate(coordinate.x + 1, coordinate.y));
        }

        return true;
    }

    private void offerQueue(Deque<Coordinate> queue,
                            Set<Coordinate> visited,
                            char[][] grid,
                            Coordinate coordinate) {

        if (coordinate.x < 0) return;
        if (coordinate.y < 0) return;
        if (coordinate.x >= grid[0].length) return;
        if (coordinate.y >= grid.length) return;
        if (grid[coordinate.y][coordinate.x] == '0') return;
        if (visited.contains(coordinate)) return;

        queue.offer(coordinate);
        visited.add(coordinate);
    }

    static class Coordinate {
        final int x;
        final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            if (x != that.x) return false;
            return y == that.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return "Coordinate{x=" + x + ", y=" + y + '}';
        }
    }

}

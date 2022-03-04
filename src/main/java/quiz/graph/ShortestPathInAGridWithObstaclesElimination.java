package quiz.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class ShortestPathInAGridWithObstaclesElimination {

    public int shortestPath(int[][] grid, int k) {
//        return new FirstApproach().shortestPath(grid, k);
        return new BfsWithQuota().shortestPath(grid, k);
    }

    static class BfsWithQuota {

        public int shortestPath(int[][] grid, int k) {

            var start = new Coordinate(0, 0);
            var goal = new Coordinate(grid.length - 1, grid[0].length - 1);
            var deque = new ArrayDeque<Moving>();
            var visit = new HashSet<Moving>();

            if (k >= goal.row + goal.col) {
                return goal.row + goal.col;
            }

            deque.offer(new Moving(start, 0, 0));
            visit.add(deque.peek());

            while (!deque.isEmpty()) {

                var cur = deque.poll();
                if (cur.coordinate.equals(goal)) {
                    return cur.step;
                }

                var neighbors = List.of(
                        cur.coordinate.up(),
                        cur.coordinate.down(),
                        cur.coordinate.left(),
                        cur.coordinate.right()
                );

                for (Coordinate n : neighbors) {
                    if (n.row < 0) continue;
                    if (n.col < 0) continue;
                    if (n.row >= grid.length) continue;
                    if (n.col >= grid[0].length) continue;

                    var nextQuota = cur.quota + (grid[n.row][n.col] == 1 ? 1 : 0);
                    var nextMoving = new Moving(n, cur.step + 1, nextQuota);

                    if (visit.contains(nextMoving)) continue;
                    if (nextQuota > k) continue;

                    deque.offer(nextMoving);
                    visit.add(nextMoving);
                }
            }

            return -1;
        }

        static class Moving {

            final Coordinate coordinate;
            final int step;
            final int quota;

            Moving(Coordinate coordinate, int step, int quota) {
                this.coordinate = coordinate;
                this.step = step;
                this.quota = quota;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                var moving = (Moving) o;

                if (quota != moving.quota) return false;
                return Objects.equals(coordinate, moving.coordinate);
            }

            @Override
            public int hashCode() {
                var result = coordinate != null ? coordinate.hashCode() : 0;
                result = 31 * result + quota;
                return result;
            }

        }

    }

    /**
     * 제거될 수 있는 장애물의 조합을 구하고,
     * 각 조합 별로 시뮬레이션 한 뒤,
     * 시뮬레이션 결과 중 가장 최소 거리를 반환하기.
     */
    static class FirstApproach {
        public int shortestPath(int[][] grid, int k) {

            var shortest = -1;
            var obstacles = obstacles(grid);
            var maxRemoval = Math.min(obstacles.size(), k);
            var removals = combinations(obstacles, maxRemoval);

            for (Coordinate[] r : removals) {
                var simulation = simulateObstacleRemoved(grid, r);
                var path = explore(simulation);

                if (path != -1) {
                    shortest = (shortest == -1) ? path : Math.min(shortest, path);
                }

                if (shortest == grid.length + grid[0].length - 2) {
                    return shortest;
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

        private int[][] simulateObstacleRemoved(int[][] grid, Coordinate[] r) {
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
            var deque = new ArrayDeque<Move>();

            deque.offer(new Move(start, 0));

            while (!deque.isEmpty()) {
                var now = deque.poll();
                var c = now.coordinate;
                var s = now.step;

                if (c.row < 0 || c.row >= grid.length) continue;
                if (c.col < 0 || c.col >= grid[0].length) continue;
                if (visit.containsKey(c) && visit.get(c) <= s) continue;
                if (grid[c.row][c.col] == 1) continue;

                visit.putIfAbsent(c, s);
                visit.computeIfPresent(c, (x, old) -> Math.min(old, s));

                deque.offer(new Move(c.up(), s + 1));
                deque.offer(new Move(c.down(), s + 1));
                deque.offer(new Move(c.left(), s + 1));
                deque.offer(new Move(c.right(), s + 1));
            }


            return visit.getOrDefault(goal, -1);
        }

        static class Move {

            final Coordinate coordinate;
            final int step;

            Move(Coordinate coordinate, int step) {
                this.coordinate = coordinate;
                this.step = step;
            }
        }

    }

    static class Coordinate {

        final int row;
        final int col;

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

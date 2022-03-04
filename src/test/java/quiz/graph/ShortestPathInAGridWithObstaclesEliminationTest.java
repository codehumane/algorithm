package quiz.graph;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import quiz.graph.ShortestPathInAGridWithObstaclesElimination.Coordinate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class ShortestPathInAGridWithObstaclesEliminationTest {

    private final ShortestPathInAGridWithObstaclesElimination solution = new ShortestPathInAGridWithObstaclesElimination();

    @Test
    void example1() {

        // given
        var grid = new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        };

        // when
        var result = solution.shortestPath(grid, 1);

        // then
        assertEquals(6, result);
    }

    @Test
    void example2() {

        // given
        var grid = new int[][]{
                {0, 1, 1},
                {1, 1, 1},
                {1, 0, 0}
        };

        // when
        var result = solution.shortestPath(grid, 1);

        // then
        assertEquals(-1, result);
    }

    @Nested
    class Combination {

        private final ShortestPathInAGridWithObstaclesElimination.FirstApproach firstApproach =
                new ShortestPathInAGridWithObstaclesElimination.FirstApproach();

        private final Coordinate c1 = new Coordinate(1, 0);
        private final Coordinate c2 = new Coordinate(1, 1);
        private final Coordinate c3 = new Coordinate(3, 1);
        private final Coordinate c4 = new Coordinate(3, 2);

        private final List<Coordinate> coordinates = List.of(
                c1,
                c2,
                c3,
                c4
        );

        @Test
        @DisplayName("n이 0인 경우")
        void n0() {

            // given
            var n = 0;

            // when
            var result = firstApproach.combinations(coordinates, n);

            // then
            assertEquals(1, result.size());
            assertEquals(0, result.get(0).length);
        }


        @Test
        @DisplayName("n이 1인 경우")
        void n1() {

            // given
            var n = 1;
            var expected = List.of(
                    new Coordinate[]{c1},
                    new Coordinate[]{c2},
                    new Coordinate[]{c3},
                    new Coordinate[]{c4}
            );

            // when
            var result = firstApproach.combinations(coordinates, n);

            // then
            verify(expected, result);
        }

        @Test
        @DisplayName("n이 2인 경우")
        void n2() {

            // given
            var n = 2;
            var expected = List.of(
                    new Coordinate[]{c1, c2},
                    new Coordinate[]{c1, c3},
                    new Coordinate[]{c1, c4},
                    new Coordinate[]{c2, c3},
                    new Coordinate[]{c2, c4},
                    new Coordinate[]{c3, c4}
            );

            // when
            var result = firstApproach.combinations(coordinates, n);

            // then
            verify(expected, result);
        }

        @Test
        @DisplayName("n이 3인 경우")
        void n3() {

            // given
            var n = 3;
            var expected = List.of(
                    new Coordinate[]{c1, c2, c3},
                    new Coordinate[]{c1, c2, c4},
                    new Coordinate[]{c1, c3, c4},
                    new Coordinate[]{c2, c3, c4}
            );

            // when
            var result = firstApproach.combinations(coordinates, n);

            // then
            verify(expected, result);
        }

        @Test
        @DisplayName("n이 4인 경우")
        void n4() {

            // given
            var n = 4;
            var expected = List.<Coordinate[]>of(
                    new Coordinate[]{c1, c2, c3, c4}
            );

            // when
            var result = firstApproach.combinations(coordinates, n);

            // then
            verify(expected, result);
        }

        private void verify(List<Coordinate[]> expected, List<Coordinate[]> actual) {
            assertEquals(expected.size(), actual.size());

            for (int i = 0; i < expected.size(); i++) {
                assertArrayEquals(expected.get(i), actual.get(i));
            }
        }

    }


}
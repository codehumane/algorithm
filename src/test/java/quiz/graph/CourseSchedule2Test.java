package quiz.graph;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CourseSchedule2Test {

    private final CourseSchedule2 solution = new CourseSchedule2();

    @Test
    public void example1() {

        // given
        val numCourses = 2;
        val expected = new int[]{0, 1};
        val prerequisites = new int[][]{
                new int[]{1, 0}
        };

        // when
        val result = solution.findOrder(numCourses, prerequisites);

        // then
        assertArrayEquals(expected, result);
    }

    @Test
    public void example2() {

        // given
        val numCourses = 4;
        val expected1 = new int[]{0, 2, 1, 3};
        val expected2 = new int[]{0, 1, 2, 3};
        val prerequisites = new int[][]{
                new int[]{1, 0},
                new int[]{2, 0},
                new int[]{3, 1},
                new int[]{3, 2}
        };

        // when
        val result = solution.findOrder(numCourses, prerequisites);

        // then
        assertTrue(Arrays.equals(expected1, result) || Arrays.equals(expected2, result));
    }

    @Test
    public void example3() {

        // given
        val numCourses = 1;
        val expected = new int[]{0};
        val prerequisites = new int[][]{};

        // when
        val result = solution.findOrder(numCourses, prerequisites);

        // then
        assertArrayEquals(expected, result);
    }

    @Test
    public void custom1_살짝_꼬아둔_경우() {

        // given
        val numCourses = 5;
        val expected1 = new int[]{0, 2, 1, 3, 4};
        val expected2 = new int[]{0, 1, 2, 3, 4};
        val prerequisites = new int[][]{
                new int[]{1, 0},
                new int[]{2, 0},
                new int[]{3, 1},
                new int[]{3, 2},
                new int[]{4, 3},
                new int[]{4, 2}
        };

        // when
        val result = solution.findOrder(numCourses, prerequisites);

        // then
        assertTrue(Arrays.equals(expected1, result) || Arrays.equals(expected2, result));
    }

    @Test
    public void custom2_순환_있는_경우() {

        // given
        val numCourses = 5;
        val prerequisites = new int[][]{
                new int[]{1, 0},
                new int[]{2, 0},
                new int[]{3, 1},
                new int[]{3, 2},
                new int[]{4, 3},
                new int[]{4, 2},
                new int[]{3, 4}
        };

        // when
        val result = solution.findOrder(numCourses, prerequisites);

        // then
        assertEquals(0, result.length);
    }

    @Test
    public void failed1() {

        // given
        val numCourses = 2;
        val prerequisites = new int[][]{};
        val expected1 = new int[]{0, 1};
        val expected2 = new int[]{1, 0};

        // when
        val result = solution.findOrder(numCourses, prerequisites);

        // then
        assertTrue(Arrays.equals(expected1, result) || Arrays.equals(expected2, result));
    }

    @Test
    public void failed2() {

        // given
        val numCourses = 7;
        val prerequisites = new int[][]{
                new int[]{1, 0},
                new int[]{0, 3},
                new int[]{0, 2},
                new int[]{3, 2},
                new int[]{2, 5},
                new int[]{4, 5},
                new int[]{5, 6},
                new int[]{2, 4}
        };
        val expected = new int[]{6, 5, 4, 2, 3, 0, 1};

        // when
        val result = solution.findOrder(numCourses, prerequisites);

        // then
        assertArrayEquals(expected, result);
    }

}
package quiz.graph;

import lombok.val;
import org.junit.Test;
import quiz.graph.CourseSchedule;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CourseScheduleTest {

    private final CourseSchedule solution = new CourseSchedule();

    @Test
    public void example1() {

        val numCourses = 2;
        val prerequisites = new int[][]{
                new int[]{1, 0}
        };

        // Explanation: There are a total of 2 courses to take.
        // To take course 1 you should have finished course 0.
        // So it is possible.
        assertTrue(solution.canFinish(numCourses, prerequisites));
    }

    @Test
    public void example2() {

        val numCourses = 2;
        val prerequisites = new int[][]{
                new int[]{1, 0},
                new int[]{0, 1}
        };

        // There are a total of 2 courses to take.
        // To take course 1 you should have finished course 0,
        // and to take course 0 you should also have finished course 1.
        // So it is impossible.
        assertFalse(solution.canFinish(numCourses, prerequisites));
    }

    @Test
    public void custom1() {

        val numCourses = 3;
        val prerequisites = new int[][]{
                new int[]{1, 0},
                new int[]{2, 1},
                new int[]{0, 2}
        };

        assertFalse(solution.canFinish(numCourses, prerequisites));
    }

    @Test
    public void custom2() {

        val numCourses = 4;
        val prerequisites = new int[][]{
                new int[]{1, 0},
                new int[]{2, 1},
                new int[]{2, 0},
                new int[]{3, 2},
                new int[]{0, 3}
        };

        assertFalse(solution.canFinish(numCourses, prerequisites));
    }

    @Test
    public void custom3() {

        val numCourses = 4;
        val prerequisites = new int[][]{
                new int[]{1, 0},
                new int[]{2, 1},
                new int[]{2, 0},
                new int[]{3, 2},
                new int[]{3, 0}
        };

        assertTrue(solution.canFinish(numCourses, prerequisites));
    }
}
package quiz.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MeetingRooms2Test {

    private MeetingRooms2 solution = new MeetingRooms2();

    @Test
    void example1() {
        var intervals = new int[][]{
                new int[]{0, 30},
                new int[]{5, 10},
                new int[]{15, 20}
        };

        assertEquals(2, solution.minMeetingRooms(intervals));
    }

    @Test
    void example2() {
        var intervals = new int[][]{
                new int[]{7, 10},
                new int[]{2, 4}
        };

        assertEquals(1, solution.minMeetingRooms(intervals));
    }

    @Test
    void custom1() {
        var intervals = new int[][]{
                new int[]{0, 11},
                new int[]{10, 15},
                new int[]{0, 10},
                new int[]{11, 15}
        };

        assertEquals(2, solution.minMeetingRooms(intervals));
    }

    @Test
    void custom2() {
        var intervals = new int[][]{
                new int[]{0, 11},
                new int[]{10, 15},
                new int[]{0, 10},
                new int[]{10, 15}
        };

        assertEquals(3, solution.minMeetingRooms(intervals));
    }

    @Test
    void custom3() {
        var intervals = new int[][]{
                new int[]{0, 10},
                new int[]{0, 10},
                new int[]{20, 25},
                new int[]{15, 25},
                new int[]{13, 14},
                new int[]{13, 19}
        };

        assertEquals(2, solution.minMeetingRooms(intervals));
    }

}
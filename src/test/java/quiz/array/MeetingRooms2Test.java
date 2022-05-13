package quiz.array;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MeetingRooms2Test {

    private final MeetingRooms2 solution = new MeetingRooms2();

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

    @Test
    void custom4() {
        var intervals = new int[][]{
                new int[]{1, 10},
                new int[]{2, 7},
                new int[]{3, 19},
                new int[]{8, 12},
                new int[]{10, 20},
                new int[]{11, 30}
        };

        assertEquals(4, solution.minMeetingRooms(intervals));
    }

    @Test
    void custom5() {
        var intervals = new int[][]{
                new int[]{13, 15},
                new int[]{1, 13},
                new int[]{6, 9}
        };

        assertEquals(2, solution.minMeetingRooms(intervals));
    }

    @Nested
    class RoomTest {

        @Test
        void comparable() {

            // given
            var r1 = new MeetingRooms2.Room();
            var r2 = new MeetingRooms2.Room();
            var r3 = new MeetingRooms2.Room();

            r1.append(new MeetingRooms2.Interval(1, 5));
            r1.append(new MeetingRooms2.Interval(6, 7));
            r2.append(new MeetingRooms2.Interval(2, 4));
            r3.append(new MeetingRooms2.Interval(5, 8));

            var rooms = new ArrayList<MeetingRooms2.Room>();
            rooms.add(r1);
            rooms.add(r2);
            rooms.add(r3);

            // when
            Collections.sort(rooms);

            // then
            assertEquals(r2, rooms.get(0));
            assertEquals(r1, rooms.get(1));
            assertEquals(r3, rooms.get(2));
        }

    }

}
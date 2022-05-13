package quiz.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
public class MeetingRooms2 {

    public int minMeetingRooms(int[][] input) {
        return new Naive().minMeetingRooms(input);
    }

    static class Naive {

        public int minMeetingRooms(int[][] input) {
            var rooms = new ArrayList<Room>();
            var intervals = toIntervals(input);

            for (Interval interval : intervals) {
                schedule(rooms, interval);
            }

            return rooms.size();
        }

        private void schedule(List<Room> rooms, Interval interval) {
            var room = rooms
                    .stream()
                    .filter(r -> r.isAppendable(interval))
                    .findAny();

            room.ifPresentOrElse(
                    r -> r.append(interval),
                    () -> rooms.add(Room.with(interval))
            );
        }

        private List<Interval> toIntervals(int[][] input) {
            return Arrays
                    .stream(input)
                    .map(x -> new Interval(x[0], x[1]))
                    .sorted()
                    .collect(Collectors.toList());
        }

    }

    static class Room {

        static Room with(Interval interval) {
            var room = new Room();
            room.append(interval);
            return room;
        }

        List<Interval> intervals = new ArrayList<>();

        /**
         * 일일이 room의 빈 공간까지 체크는 하지 않고,
         * 주어진 interval이 현재 room 마지막 interval 보다 이후인지만 검사.
         */
        void append(Interval interval) {
            intervals.add(interval);
        }

        boolean isAppendable(Interval interval) {
            if (intervals.isEmpty()) {
                return true;
            }

            var last = intervals.get(intervals.size() - 1);
            return last.end <= interval.start;
        }

    }

    static class Interval implements Comparable<Interval> {

        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            var compared = Integer.compare(this.start, o.start);
            if (compared != 0) return compared;
            return Integer.compare(this.end, o.end);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            if (start != interval.start) return false;
            return end == interval.end;
        }

        @Override
        public int hashCode() {
            int result = start;
            result = 31 * result + end;
            return result;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

}

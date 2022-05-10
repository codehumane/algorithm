package quiz.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        var sorted = sort(intervals);
        var merged = merge(sorted);
        return toResult(merged);
    }

    private List<Interval> sort(int[][] intervals) {
        return Arrays
                .stream(intervals)
                .map(i -> new Interval(i[0], i[1]))
                .sorted()
                .collect(Collectors.toList());
    }

    private Set<Interval> merge(List<Interval> sorted) {
        var merged = new HashSet<Interval>();
        var current = sorted.remove(0);

        for (Interval interval : sorted) {
            if (interval.isOverlapping(current)) {
                current.merge(interval);
            } else {
                merged.add(current);
                current = interval;
            }
        }

        merged.add(current);
        return merged;
    }

    private int[][] toResult(Set<Interval> merged) {
        var result = new int[merged.size()][2];

        var i = 0;
        for (Interval m : merged) {
            result[i++] = new int[]{m.start, m.end};
        }

        return result;
    }

    static class Interval implements Comparable<Interval> {

        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean isOverlapping(Interval other) {
            return this.start <= other.end && this.end >= other.start;
        }

        public void merge(Interval other) {
            if (this.start > other.start) this.start = other.start;
            if (this.end < other.end) this.end = other.end;
        }

        @Override
        public int compareTo(Interval o) {
            var startCompared = Integer.compare(this.start, o.start);
            if (startCompared != 0) return startCompared;
            return Integer.compare(this.end, o.end);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            if (start != interval.start) return false;
            else return end == interval.end;
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

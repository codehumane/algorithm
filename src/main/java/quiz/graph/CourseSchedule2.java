package quiz.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * There are a total of numCourses courses you have to take,
 * labeled from 0 to numCourses - 1.
 * You are given an array prerequisites
 * where prerequisites[i] = [ai, bi] indicates that
 * you must take course bi first if you want to take course ai.<br/>
 * <br/>
 * Return the ordering of courses you should take to finish all courses.
 * If there are many valid answers, return any of them.
 * If it is impossible to finish all courses, return an empty array.<br/>
 * <br/>
 * https://leetcode.com/problems/course-schedule-ii/
 */
@Slf4j
public class CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        final List<Node> tops = connectNodes(numCourses, prerequisites);
        final List<Node> schedule = schedule(tops);

        if (schedule.size() != numCourses) {
            return new int[]{};
        }

        return schedule
                .stream()
                .mapToInt(n -> n.value)
                .toArray();
    }

    private List<Node> schedule(List<Node> tops) {
        final List<Node> schedule = new ArrayList<>();

        for (Node top : tops) {
            schedule.add(top);

            for (Node child : top.children) {
                schedule(child, schedule);
            }
        }

        return schedule;
    }

    private void schedule(Node node, List<Node> schedule) {

        node.parentCount--;
        if (node.parentCount > 0) {
            return;
        }

        schedule.add(node);
        for (Node child : node.children) {
            schedule(child, schedule);
        }
    }

    private List<Node> connectNodes(int numCourses, int[][] prerequisites) {

        final List<Node> nodes = IntStream
                .range(0, numCourses)
                .mapToObj(Node::new)
                .collect(Collectors.toList());

        for (int[] prerequisite : prerequisites) {
            final Node child = nodes.get(prerequisite[0]);
            final Node parent = nodes.get(prerequisite[1]);
            parent.addChild(child);
        }

        return nodes
                .stream()
                .filter(n -> n.parentCount == 0)
                .collect(Collectors.toList());
    }

    static class Node {

        final int value;
        final Set<Node> children;
        int parentCount;

        public Node(int value) {
            this.value = value;
            this.children = new HashSet<>();
            this.parentCount = 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            return value == ((Node) o).value;
        }

        @Override
        public int hashCode() {
            return value;
        }

        @Override
        public String toString() {
            final Set<Integer> childValues = children
                    .stream()
                    .map(x -> x.value)
                    .collect(Collectors.toSet());

            return String.format(
                    "Node{value=%d, children=%s, parentCount=%d}",
                    value,
                    childValues,
                    parentCount
            );
        }

        public void addChild(Node child) {
            if (children.add(child)) {
                child.parentCount++;
            }
        }
    }

}

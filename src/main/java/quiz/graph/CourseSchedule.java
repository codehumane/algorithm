package quiz.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        final List<Node> nodes = toNodes(numCourses, prerequisites);
        final Set<Node> visited = new HashSet<>();
        final Set<Node> tracking = new HashSet<>();

        return nodes
                .stream()
                .noneMatch(node -> detectCycle(node, visited, tracking));
    }

    private List<Node> toNodes(int numCourses, int[][] prerequisites) {

        final List<Node> nodes = IntStream
                .range(0, numCourses)
                .mapToObj(Node::new)
                .collect(Collectors.toList());

        for (int[] prerequisite : prerequisites) {
            final Node parent = nodes.get(prerequisite[1]);
            final Node child = nodes.get(prerequisite[0]);
            parent.vertices.add(child);
        }

        return nodes;
    }

    private boolean detectCycle(Node node, Set<Node> visited, Set<Node> tracking) {
        if (visited.contains(node)) {
            return tracking.contains(node);
        }

        visited.add(node);
        tracking.add(node);

        for (Node vertex : node.vertices) {
            if (detectCycle(vertex, visited, tracking)) {
                return true;
            }
        }

        tracking.remove(node);
        return false;
    }

    static class Node {

        final int value;
        final Set<Node> vertices;

        public Node(int value) {
            this.value = value;
            this.vertices = new HashSet<>();
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
            return "Node{" +
                    "value=" + value +
                    ", vertices=" + vertices.stream().map(x -> x.value).collect(Collectors.toSet()) +
                    '}';
        }
    }
}

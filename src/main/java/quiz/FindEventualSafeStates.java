package quiz;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/find-eventual-safe-states/
 */
@Slf4j
public class FindEventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        final Set<Node> visited = new HashSet<>();
        final Set<Node> tracking = new HashSet<>();

        return toNodes(graph)
                .stream()
                .filter(node -> isSafe(node, visited, tracking))
                .map(node -> node.value)
                .collect(Collectors.toList());
    }

    private List<Node> toNodes(int[][] graph) {
        final List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            nodes.add(new Node(i));
        }

        for (int i = 0; i < graph.length; i++) {
            for (int to : graph[i]) {
                nodes.get(i).vertices.add(nodes.get(to));
            }
        }

        return nodes;
    }

    // 재귀보다 루프를 도는 게 보통 이점이 많은데, `tracking` 관리 떄문에 재귀 사용
    private boolean isSafe(Node node, Set<Node> visited, Set<Node> tracking) {
        if (visited.contains(node)) {
            // back edge만 판단하면 안 되고,
            // 이미 방문한 경우는 바로 참을 응답.
            // 그렇지 않으면 Time Limit Exceeded
            return !tracking.contains(node);
        }

        visited.add(node);
        tracking.add(node);

        for (Node vertex : node.vertices) {
            if (!isSafe(vertex, visited, tracking)) {
                return false;
            }
        }

        tracking.remove(node);
        return true;
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

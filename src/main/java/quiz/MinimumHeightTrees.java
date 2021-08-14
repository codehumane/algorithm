package quiz;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        final List<Node> nodes = toNodes(n, edges);
        final List<Node> minNodes = minNodes(nodes);

        return minNodes
                .stream()
                .map(node -> node.value)
                .collect(Collectors.toList());
    }

    private List<Node> toNodes(int n, int[][] edges) {
        final List<Node> nodes = IntStream
                .range(0, n)
                .mapToObj(Node::new)
                .collect(Collectors.toList());

        for (int[] edge : edges) {
            nodes.get(edge[0]).addAdjacent(nodes.get(edge[1]));
        }

        return nodes;
    }

    private List<Node> minNodes(List<Node> nodes) {
        final List<Node> minNodes = new ArrayList<>();
        int minHeight = Integer.MAX_VALUE;

        for (Node node : nodes) {
            final int height = calculateHeight(node, 0, new HashSet<>());

            if (height < minHeight) {
                minNodes.clear();
                minNodes.add(node);
                minHeight = height;
            } else if (height == minHeight) {
                minNodes.add(node);
            }
        }

        return minNodes;
    }

    private int calculateHeight(Node node, int currentHeight, Set<Node> visited) {
        if (visited.contains(node)) return currentHeight;
        visited.add(node);

        int maxHeight = 0;
        for (Node adj : node.adjacent) {
            final int height = calculateHeight(adj, currentHeight + 1, visited);
            maxHeight = Integer.max(maxHeight, height);
        }

        return maxHeight;
    }

    static class Node {

        int value;
        Set<Node> adjacent;

        public Node(int value) {
            this.value = value;
            this.adjacent = new HashSet<>();
        }

        public void addAdjacent(Node node) {
            adjacent.add(node);
            node.adjacent.add(this);
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
                    ", adjacent=" + adjacent.stream().map(a -> a.value).collect(Collectors.toSet()) +
                    '}';
        }
    }

}

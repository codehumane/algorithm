package quiz.graph;

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
        final List<Node> centroids = extractCentroids(nodes);

        return centroids
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

    private List<Node> extractCentroids(List<Node> nodes) {
        final List<Node> centroids = new ArrayList<>(nodes);

        while (centroids.size() > 2) {
            final Set<Node> leaves = centroids
                    .stream()
                    .filter(n -> 1 == n.adjacent.size())
                    .collect(Collectors.toSet());

            leaves.forEach(leaf -> {
                final Node adjacent = leaf.adjacent.iterator().next();
                adjacent.removeAdjacent(leaf);
            });

            centroids.removeAll(leaves);
        }

        return centroids;
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

        public void removeAdjacent(Node node) {
            adjacent.remove(node);
            node.adjacent.remove(this);
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

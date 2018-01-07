package data;

import lombok.val;

import java.util.*;

class BreathFirstSearch {

    Distance getDistance(Graph graph, Vertex root) {
        if (!graph.contains(root))
            throw new IllegalArgumentException();

        val distance = new Distance();
        val queue = new ArrayDeque<Vertex>();

        queue.add(root);
        distance.set(root, 0);
        setDistanceWithBFS(distance, queue, graph.getEdges());

        return distance;
    }

    private void setDistanceWithBFS(Distance distance,
                                    ArrayDeque<Vertex> queue,
                                    LinkedHashMap<Vertex, Set<Vertex>> edges) {

        if (queue.isEmpty()) return;

        val from = queue.remove();
        val distanceOfFrom = distance.get(from) + 1;

        edges.get(from)
                .stream()
                .filter(v -> Objects.isNull(distance.get(v)))
                .forEach(v -> {
                    queue.add(v);
                    distance.set(v, distanceOfFrom);
                });

        setDistanceWithBFS(distance, queue, edges);
    }

    public static class Distance {

        private final Map<Vertex, Integer> vertexToDistance = new HashMap<>();

        Integer get(Vertex vertex) {
            return vertexToDistance.get(vertex);
        }

        private void set(Vertex vertex, Integer distance) {
            vertexToDistance.put(vertex, distance);
        }
    }
}

package data.graph;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
class DepthFirstSearch {

    ExploreResult explore(Graph graph) {

        val counter = new Counter();
        val visited = new LinkedHashSet<Vertex>();
        val visitCounts = new HashMap<Vertex, VisitCount>();

        graph.getEdges().keySet()
                .forEach(vertex -> explore(
                        graph.getEdges(),
                        visitCounts,
                        visited,
                        counter,
                        vertex
                ));

        val cyclic = detectCyclic(graph.getEdges(), visitCounts);
        visited.forEach(v -> log.info("vertex: {}, count: {}", v, visitCounts.get(v)));

        return new ExploreResult(
                visited,
                cyclic
        );
    }

    private Map<Vertex, Vertex> detectCyclic(LinkedHashMap<Vertex, Set<Vertex>> edges,
                                             HashMap<Vertex, VisitCount> counts) {

        val cyclic = new HashMap<Vertex, Vertex>();
        edges.forEach((v, adjacents) -> adjacents
                .stream()
                .filter(a -> determineBackEdge(counts, v, a))
                .forEach(a -> cyclic.put(v, a)));

        return cyclic;
    }

    private boolean determineBackEdge(HashMap<Vertex, VisitCount> visitCounts,
                                      Vertex from,
                                      Vertex to) {

        return visitCounts.get(from).getPre() > visitCounts.get(to).getPre() &&
                visitCounts.get(from).getPost() < visitCounts.get(to).getPost();
    }

    private void explore(Map<Vertex, Set<Vertex>> edges,
                         HashMap<Vertex, VisitCount> visitCounts,
                         LinkedHashSet<Vertex> visited,
                         Counter counter,
                         Vertex vertex) {

        if (visited.contains(vertex))
            return;

        preVisit(vertex, visitCounts, counter);
        visited.add(vertex);

        Optional.ofNullable(edges.get(vertex))
                .orElse(new HashSet<>())
                .forEach(adjacent -> explore(
                        edges,
                        visitCounts,
                        visited,
                        counter,
                        adjacent
                ));

        postVisit(vertex, visitCounts, counter);
    }

    private void preVisit(Vertex vertex, HashMap<Vertex, VisitCount> visitCounts, Counter counter) {
        visitCounts.computeIfAbsent(vertex, k -> new VisitCount())
                .setPre(counter.increase());
    }

    private void postVisit(Vertex vertex, HashMap<Vertex, VisitCount> visitCounts, Counter counter) {
        visitCounts.get(vertex).setPost(counter.increase());
    }

    @Getter
    private static class Counter {

        private int value = 1;

        int increase() {
            return value++;
        }
    }

    @Getter
    @Setter
    @ToString
    private static class VisitCount {
        private int pre;
        private int post;
    }

    @Value
    static class ExploreResult {
        private final LinkedHashSet<Vertex> visited;
        private final Map<Vertex, Vertex> backEdges;
    }
}

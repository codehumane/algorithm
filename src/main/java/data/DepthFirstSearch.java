package data;

import lombok.Value;
import lombok.val;

import javax.swing.text.html.Option;
import java.util.*;

class DepthFirstSearch {

    LinkedHashSet<Vertex> explore(Graph graph) {
        val visited = new LinkedHashSet<Vertex>();
        val edges = graph.getEdges();

        edges.keySet()
                .forEach(vertex -> explore(edges, visited, vertex));

        return visited;
    }

    private void explore(Map<Vertex, Set<Vertex>> edges,
                         LinkedHashSet<Vertex> visited,
                         Vertex vertex) {

        if (visited.contains(vertex))
            return;

        preVisit(vertex);
        visited.add(vertex);

        Optional.ofNullable(edges.get(vertex))
                .orElse(new HashSet<>())
                .forEach(adjacent -> explore(edges, visited, adjacent));

        postVisit(vertex);
    }

    private void preVisit(Vertex vertex) {
        // do any hook on demand
    }

    private void postVisit(Vertex vertex) {
        // do any hook on demand
    }

    @Value
    static class Graph {
        final LinkedHashMap<Vertex, Set<Vertex>> edges;
    }

    static class IndirectGraphBuilder {

        final LinkedHashMap<Vertex, Set<Vertex>> edges = new LinkedHashMap<>();

        IndirectGraphBuilder addEdge(Vertex from, Vertex to) {
            edges.computeIfAbsent(from, k -> new LinkedHashSet<>()).add(to);
            edges.computeIfAbsent(to, k -> new LinkedHashSet<>()).add(from);
            return this;
        }

        Graph build() {
            return new Graph(edges);
        }
    }

    static class DirectGraphBuilder {

        final LinkedHashMap<Vertex, Set<Vertex>> edges = new LinkedHashMap<>();

        DirectGraphBuilder addEdge(Vertex from, Vertex to) {
            edges.computeIfAbsent(from, k -> new LinkedHashSet<>()).add(to);
            return this;
        }

        Graph build() {
            return new Graph(edges);
        }
    }

    @Value
    static class Vertex {

        private final String value;

        static Vertex of(String value) {
            return new Vertex(value);
        }
    }
}

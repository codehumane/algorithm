package data;

import lombok.Value;
import lombok.val;

import java.util.*;

class DepthFirstSearch {

    LinkedHashSet<Vertex> explore(IndirectGraph graph) {
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

        edges.get(vertex)
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
    static class IndirectGraph {
        final LinkedHashMap<Vertex, Set<Vertex>> edges;
    }

    static class IndirectGraphBuilder {

        final LinkedHashMap<Vertex, Set<Vertex>> edges = new LinkedHashMap<>();

        IndirectGraphBuilder addEdge(Vertex from, Vertex to) {
            edges.computeIfAbsent(from, k -> new LinkedHashSet<>()).add(to);
            edges.computeIfAbsent(to, k -> new LinkedHashSet<>()).add(from);
            return this;
        }

        IndirectGraph build() {
            return new IndirectGraph(edges);
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

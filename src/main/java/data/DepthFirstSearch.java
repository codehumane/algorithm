package data;

import lombok.Value;
import lombok.val;

import java.util.*;

class DepthFirstSearch {

    LinkedHashSet<Vertex> explore(IndirectGraph graph) {
        val explored = new LinkedHashSet<Vertex>();
        val edges = graph.getEdges();

        edges.keySet()
                .forEach(vertex -> explore(edges, explored, vertex));

        return explored;
    }

    private void explore(Map<Vertex, Set<Vertex>> edges,
                         LinkedHashSet<Vertex> explored,
                         Vertex vertex) {

        if (explored.contains(vertex))
            return;

        explored.add(vertex);
        if (edges.get(vertex).isEmpty())
            return;

        edges.get(vertex)
                .forEach(adjacent -> explore(edges, explored, adjacent));
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

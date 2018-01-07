package data;

import java.util.*;

class IndirectGraphBuilder {

    final LinkedHashMap<Vertex, Set<Vertex>> edges = new LinkedHashMap<>();
    final Set<Vertex> nodes = new HashSet<>();

    IndirectGraphBuilder addEdge(Vertex from, Vertex to) {
        edges.computeIfAbsent(from, k -> new LinkedHashSet<>()).add(to);
        edges.computeIfAbsent(to, k -> new LinkedHashSet<>()).add(from);
        nodes.add(from);
        nodes.add(to);
        return this;
    }

    Graph build() {
        return new Graph(edges, nodes);
    }
}

package data;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

class DirectGraphBuilder {

    final LinkedHashMap<Vertex, Set<Vertex>> edges = new LinkedHashMap<>();
    final Set<Vertex> nodes = new HashSet<>();

    DirectGraphBuilder addEdge(Vertex from, Vertex to) {
        edges.computeIfAbsent(from, k -> new LinkedHashSet<>()).add(to);
        nodes.add(from);
        nodes.add(to);
        return this;
    }

    Graph build() {
        return new Graph(edges, nodes);
    }
}

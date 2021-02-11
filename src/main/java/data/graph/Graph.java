package data.graph;

import lombok.Value;

import java.util.LinkedHashMap;
import java.util.Set;

@Value
class Graph {
    
    final LinkedHashMap<Vertex, Set<Vertex>> edges;
    final Set<Vertex> vertices;

    boolean contains(Vertex node) {
        return vertices.contains(node);
    }
}

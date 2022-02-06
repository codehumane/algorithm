package data.graph;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BreathFirstSearchTest {

    private BreathFirstSearch bfs = new BreathFirstSearch();

    @Test
    public void getDistance_자기자신으로의_거리는_0이다() throws Exception {

        // given
        val a = Vertex.of("A");
        val vertices = new HashSet<Vertex>(Collections.singletonList(a));
        val edges = new LinkedHashMap<Vertex, Set<Vertex>>();
        edges.put(a, new HashSet<>());

        // given
        val graph = new Graph(edges, vertices);

        // when
        val distance = bfs.getDistance(graph, a);

        // then
        assertEquals(0, distance.get(a).intValue());
    }

    @Test
    public void getDistance_거리가_1인_경우() throws Exception {

        // given
        val a = Vertex.of("A");
        val b = Vertex.of("B");
        val graph = new IndirectGraphBuilder()
                .addEdge(a, b)
                .build();

        // when
        val distance = bfs.getDistance(graph, a);

        // then
        assertEquals(1, distance.get(b).intValue());
    }

    @Test
    public void getDistance_거리가_1인_정점이_2개인_경우() throws Exception {

        // given
        val a = Vertex.of("A");
        val b = Vertex.of("B");
        val c = Vertex.of("C");

        val graph = new IndirectGraphBuilder()
                .addEdge(a, b)
                .addEdge(a, c)
                .build();

        // when
        val distance = bfs.getDistance(graph, a);

        // then
        assertEquals(1, distance.get(b).intValue());
        assertEquals(1, distance.get(c).intValue());
    }

    @Test
    public void getDistance_거리가_2인_정점이_1개인_경우() throws Exception {

        // given
        val a = Vertex.of("A");
        val b = Vertex.of("B");
        val c = Vertex.of("C");

        val graph = new IndirectGraphBuilder()
                .addEdge(a, b)
                .addEdge(b, c)
                .build();

        // when
        val distance = bfs.getDistance(graph, a);

        // then
        assertEquals(1, distance.get(b).intValue());
        assertEquals(2, distance.get(c).intValue());
    }

    @Test
    public void getDistance_거리가_2인_정점이_2개인_경우() throws Exception {

        // given
        val a = Vertex.of("A");
        val b = Vertex.of("B");
        val c = Vertex.of("C");
        val d = Vertex.of("D");

        val graph = new IndirectGraphBuilder()
                .addEdge(a, b)
                .addEdge(b, c)
                .addEdge(b, d)
                .build();

        // when
        val distance = bfs.getDistance(graph, a);

        // then
        assertEquals(1, distance.get(b).intValue());
        assertEquals(2, distance.get(c).intValue());
        assertEquals(2, distance.get(d).intValue());
    }

    @Test
    public void getDistance_거리가_3인_정점이_1개인_경우() throws Exception {

        // given
        val a = Vertex.of("A");
        val b = Vertex.of("B");
        val c = Vertex.of("C");
        val d = Vertex.of("D");

        val graph = new IndirectGraphBuilder()
                .addEdge(a, b)
                .addEdge(b, c)
                .addEdge(c, d)
                .build();

        // when
        val distance = bfs.getDistance(graph, a);

        // then
        assertEquals(1, distance.get(b).intValue());
        assertEquals(2, distance.get(c).intValue());
        assertEquals(3, distance.get(d).intValue());
    }

    @Test
    public void getDistance_거리가_3인_정점이_3개인_경우() throws Exception {

        // given
        val a = Vertex.of("A");
        val b = Vertex.of("B");
        val c = Vertex.of("C");
        val d = Vertex.of("D");
        val e = Vertex.of("E");
        val f = Vertex.of("F");
        val g = Vertex.of("G");

        val graph = new IndirectGraphBuilder()
                .addEdge(a, b)
                .addEdge(b, c)
                .addEdge(c, d)
                .addEdge(c, e)
                .addEdge(a, f)
                .addEdge(f, g)
                .build();

        // when
        val distance = bfs.getDistance(graph, a);

        // then
        assertEquals(1, distance.get(b).intValue());
        assertEquals(2, distance.get(c).intValue());
        assertEquals(3, distance.get(d).intValue());
    }
}
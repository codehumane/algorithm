package data.graph;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepthFirstSearchTest {

    private DepthFirstSearch dfs = new DepthFirstSearch();

    @Test
    public void explore_무방향그래프_단순한_경우() throws Exception {

        // given
        val a = Vertex.of("A");
        val b = Vertex.of("B");
        val graph = new IndirectGraphBuilder().addEdge(a, b).build();

        // when
        val explored = dfs.explore(graph);

        // then
        val vertices = new ArrayList<>(explored.getVisited());
        assertEquals(2, vertices.size());
        assertEquals(a, vertices.get(0));
        assertEquals(b, vertices.get(1));
    }

    @Test
    public void explore_무방향그래프_복잡한_경우_첫번째() throws Exception {

        // given
        val a = Vertex.of("A");
        val b = Vertex.of("B");
        val e = Vertex.of("E");
        val i = Vertex.of("I");
        val j = Vertex.of("J");

        val graph = new IndirectGraphBuilder()
                .addEdge(a, b)
                .addEdge(a, e)
                .addEdge(e, i)
                .addEdge(j, e)
                .build();

        // when
        val explored = dfs.explore(graph);

        // then
        val vertices = new ArrayList<>(explored.getVisited());
        assertEquals(5, vertices.size());
        assertEquals(a, vertices.get(0));
        assertEquals(b, vertices.get(1));
        assertEquals(e, vertices.get(2));
        assertEquals(i, vertices.get(3));
        assertEquals(j, vertices.get(4));
    }

    @Test
    public void explore_무방향그래프_복잡한_경우_두번째() throws Exception {

        // given
        val c = Vertex.of("C");
        val d = Vertex.of("D");
        val h = Vertex.of("H");
        val g = Vertex.of("G");
        val l = Vertex.of("L");
        val k = Vertex.of("K");

        val graph = new IndirectGraphBuilder()
                .addEdge(c, d)
                .addEdge(c, g)
                .addEdge(c, h)
                .addEdge(d, h)
                .addEdge(h, g)
                .addEdge(h, k)
                .addEdge(h, l)
                .addEdge(g, k)
                .build();

        // when
        val explored = dfs.explore(graph);

        // then
        val vertices = new ArrayList<>(explored.getVisited());
        assertEquals(6, vertices.size());
        assertEquals(c, vertices.get(0));
        assertEquals(d, vertices.get(1));
        assertEquals(h, vertices.get(2));
        assertEquals(g, vertices.get(3));
        assertEquals(k, vertices.get(4));
        assertEquals(l, vertices.get(5));
    }

    @Test
    public void explore_유향그래프_첫번째() throws Exception {

        // given
        val a = Vertex.of("A");
        val b = Vertex.of("B");
        val c = Vertex.of("C");
        val d = Vertex.of("D");
        val e = Vertex.of("E");
        val f = Vertex.of("F");
        val g = Vertex.of("G");
        val h = Vertex.of("H");

        val graph = new DirectGraphBuilder()
                .addEdge(b, a)
                .addEdge(b, d)
                .addEdge(a, c)
                .addEdge(d, c)
                .addEdge(c, e)
                .addEdge(c, f)
                .build();

        // when
        val explored = dfs.explore(graph);

        // then
        val vertices = new ArrayList<>(explored.getVisited());
        assertEquals(6, vertices.size());
        assertEquals(b, vertices.get(0));
        assertEquals(a, vertices.get(1));
        assertEquals(c, vertices.get(2));
        assertEquals(e, vertices.get(3));
        assertEquals(f, vertices.get(4));
        assertEquals(d, vertices.get(5));
    }

    @Test
    public void explore_유향그래프_두번째() throws Exception {

        // given
        val a = Vertex.of("A");
        val b = Vertex.of("B");
        val c = Vertex.of("C");
        val d = Vertex.of("D");
        val e = Vertex.of("E");
        val f = Vertex.of("F");
        val g = Vertex.of("G");
        val h = Vertex.of("H");

        val graph = new DirectGraphBuilder()
                .addEdge(a, b)
                .addEdge(a, c)
                .addEdge(a, f)
                .addEdge(b, e)
                .addEdge(c, d)
                .addEdge(d, a)
                .addEdge(d, h)
                .addEdge(e, f)
                .addEdge(e, g)
                .addEdge(e, h)
                .addEdge(f, g)
                .addEdge(f, b)
                .addEdge(h, g)
                .build();

        // when
        val explored = dfs.explore(graph);

        // then
        val vertices = new ArrayList<>(explored.getVisited());
        assertEquals(8, vertices.size());
        assertEquals(a, vertices.get(0));
        assertEquals(b, vertices.get(1));
        assertEquals(e, vertices.get(2));
        assertEquals(f, vertices.get(3));
        assertEquals(g, vertices.get(4));
        assertEquals(h, vertices.get(5));
        assertEquals(c, vertices.get(6));
        assertEquals(d, vertices.get(7));
    }

    @Test
    public void detectCyclic() throws Exception {

        // given
        val a = Vertex.of("A");
        val b = Vertex.of("B");
        val c = Vertex.of("C");
        val d = Vertex.of("D");
        val e = Vertex.of("E");
        val f = Vertex.of("F");
        val g = Vertex.of("G");
        val h = Vertex.of("H");

        val graph = new DirectGraphBuilder()
                .addEdge(a, b)
                .addEdge(a, c)
                .addEdge(a, f)
                .addEdge(b, e)
                .addEdge(c, d)
                .addEdge(d, a)
                .addEdge(d, h)
                .addEdge(e, f)
                .addEdge(e, g)
                .addEdge(e, h)
                .addEdge(f, g)
                .addEdge(f, b)
                .addEdge(h, g)
                .build();

        // when
        val explored = dfs.explore(graph);

        // then
        val backEdges = explored.getBackEdges();
        assertEquals(2, backEdges.size());
        assertEquals(b, backEdges.get(f));
        assertEquals(a, backEdges.get(d));
    }
}
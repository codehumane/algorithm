package data;

import data.DepthFirstSearch.DirectGraphBuilder;
import data.DepthFirstSearch.IndirectGraphBuilder;
import data.DepthFirstSearch.Vertex;
import lombok.val;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import static org.junit.Assert.*;

public class DepthFirstSearchTest {

    private DepthFirstSearch dfs;

    @Before
    public void setUp() throws Exception {
        this.dfs = new DepthFirstSearch();
    }

    @Test
    public void explore_무방향그래프_단순한_경우() throws Exception {

        // given
        val a = Vertex.of("A");
        val b = Vertex.of("B");
        val graph = new IndirectGraphBuilder()
                .addEdge(a, b)
                .build();

        // when
        val explored = dfs.explore(graph);

        // then
        val vertices = new ArrayList<>(explored);
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
        val vertices = new ArrayList<>(explored);
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
        val vertices = new ArrayList<>(explored);
        assertEquals(6, vertices.size());
        assertEquals(c, vertices.get(0));
        assertEquals(d, vertices.get(1));
        assertEquals(h, vertices.get(2));
        assertEquals(g, vertices.get(3));
        assertEquals(k, vertices.get(4));
        assertEquals(l, vertices.get(5));
    }

    @Test
    public void explore_유향그래프() throws Exception {

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
        val vertices = new ArrayList<>(explored);
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
}
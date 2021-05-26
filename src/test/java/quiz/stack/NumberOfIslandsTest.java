package quiz.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfIslandsTest {

    private final NumberOfIslands solution = new NumberOfIslands();

    @Test
    public void example1() {

        // given
        final char[][] input = {
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'}
        };

        // when
        final int output = solution.numIslands(input);

        // then
        assertEquals(1, output);
    }

    @Test
    public void example2() {
        // given
        final char[][] input = {
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '1'}
        };

        // when
        final int output = solution.numIslands(input);

        // then
        assertEquals(3, output);
    }

    @Test
    public void edge() {
        assertEquals(1, solution.numIslands(new char[][]{new char[]{'1'}}));
        assertEquals(0, solution.numIslands(new char[][]{new char[]{'0'}}));
        assertEquals(1, solution.numIslands(new char[][]{new char[]{'1', '1', '1'}}));
        assertEquals(2, solution.numIslands(new char[][]{new char[]{'1', '0', '1'}}));
        assertEquals(1, solution.numIslands(new char[][]{new char[]{'1'}, new char[]{'1'}, new char[]{'1'}}));
        assertEquals(2, solution.numIslands(new char[][]{new char[]{'1'}, new char[]{'0'}, new char[]{'1'}}));
    }

}
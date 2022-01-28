package quiz.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NetworkDelayTimeTest {

    private final NetworkDelayTime time = new NetworkDelayTime();

    @Test
    public void example1() {

        // given
        int n = 4;
        int k = 2;
        int[][] times = {
                new int[]{2, 1, 1},
                new int[]{2, 3, 1},
                new int[]{3, 4, 1}
        };

        // when
        int delay = time.solution(times, n, k);

        // then
        assertEquals(2, delay);
    }

    @Test
    public void example2() {

        // given
        int n = 2;
        int k = 1;
        int[][] times = {
                new int[]{1, 2, 1}
        };

        // when
        int delay = time.solution(times, n, k);

        // then
        assertEquals(1, delay);
    }

    @Test
    public void example3() {

        // given
        int n = 2;
        int k = 2;
        int[][] times = {
                new int[]{1, 2, 1}
        };

        // when
        int delay = time.solution(times, n, k);

        // then
        assertEquals(-1, delay);
    }

    /**
     * 순환이 일어나면 StackOverflowError 발생하므로,
     * 한 번 방문한 곳은 다시 방문하지 않아야 한다.
     */
    @Test
    public void failed1_한_노드를_두_번_방문하지_않아야_한다() {

        // given
        int n = 2;
        int k = 2;
        int[][] times = {
                new int[]{1, 2, 1},
                new int[]{2, 1, 3}
        };

        // when
        int delay = time.solution(times, n, k);

        // then
        assertEquals(3, delay);
    }

    @Test
    public void failed2_여러_가능한_지연_중_가장_짧은_것을_택해야_한다() {

        // given
        int n = 3;
        int k = 1;
        int[][] times = {
                new int[]{1, 2, 1},
                new int[]{2, 3, 7},
                new int[]{1, 3, 4},
                new int[]{2, 1, 2}
        };

        // when
        int delay = time.solution(times, n, k);

        // then
        assertEquals(4, delay);
    }
}
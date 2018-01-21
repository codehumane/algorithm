package data;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayPriorityQueueTest {

    @Test
    public void poll_엘리먼트가_1개인_경우() throws Exception {

        // given
        val queue = new ArrayPriorityQueue(2);
        queue.offer("one", 1);

        // then
        assertEquals("one", queue.poll());
    }

    @Test
    public void poll_엘리먼트가_2개이고_우선순위_높은_엘리먼트가_먼저_들어간_경우() throws Exception {

        // given
        val queue = new ArrayPriorityQueue(2);
        queue.offer("highest", 1);
        queue.offer("low", 2);

        // then
        assertEquals("highest", queue.poll());
        assertEquals("low", queue.poll());
    }

    @Test
    public void poll_엘리먼트가_2개이고_우선순위_낮은_엘리먼트가_먼저_들어간_경우() throws Exception {

        // given
        val queue = new ArrayPriorityQueue(2);
        queue.offer("low", 2);
        queue.offer("highest", 1);

        // then
        assertEquals("highest", queue.poll());
        assertEquals("low", queue.poll());
    }

    @Test
    public void poll_엘리먼트가_3개이고_먼저_들어간_순서대로_우선순위가_낮은_경우() throws Exception {

        // given
        val queue = new ArrayPriorityQueue(4);
        queue.offer("low", 3);
        queue.offer("mid", 2);
        queue.offer("highest", 1);

        // then
        assertEquals("highest", queue.poll());
        assertEquals("mid", queue.poll());
        assertEquals("low", queue.poll());
    }

    @Test
    public void poll_엘리먼트가_3개이고_먼저_들어간_순서대로_우선순위가_높은_경우() throws Exception {

        // given
        val queue = new ArrayPriorityQueue(4);
        queue.offer("highest", 1);
        queue.offer("mid", 2);
        queue.offer("low", 3);

        // then
        assertEquals("highest", queue.poll());
        assertEquals("mid", queue.poll());
        assertEquals("low", queue.poll());
    }

    @Test
    public void poll_엘리먼트가_3개이고_입력된_순서대로_우선순위가_두번째_세번째_첫번째인_경우() throws Exception {

        // given
        val queue = new ArrayPriorityQueue(4);
        queue.offer("mid", 2);
        queue.offer("low", 3);
        queue.offer("highest", 1);

        // then
        assertEquals("highest", queue.poll());
        assertEquals("mid", queue.poll());
        assertEquals("low", queue.poll());
    }
}
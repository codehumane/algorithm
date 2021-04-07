package data.queue;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyCircularQueueTest {

    @Test
    public void example() {
        val queue = new MyCircularQueue(3);
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        assertTrue(queue.enQueue(1));
        assertEquals(1, queue.Front());
        assertEquals(1, queue.Rear());
        assertFalse(queue.isFull());
        assertFalse(queue.isEmpty());

        assertTrue(queue.enQueue(2));
        assertEquals(1, queue.Front());
        assertEquals(2, queue.Rear());
        assertFalse(queue.isFull());
        assertFalse(queue.isEmpty());

        assertTrue(queue.enQueue(3));
        assertEquals(1, queue.Front());
        assertEquals(3, queue.Rear());
        assertTrue(queue.isFull());
        assertFalse(queue.isEmpty());

        assertFalse(queue.enQueue(4));
        assertEquals(1, queue.Front());
        assertEquals(3, queue.Rear());
        assertTrue(queue.isFull());
        assertFalse(queue.isEmpty());

        assertTrue(queue.deQueue());
        assertEquals(2, queue.Front());
        assertEquals(3, queue.Rear());
        assertFalse(queue.isFull());
        assertFalse(queue.isEmpty());

        assertTrue(queue.enQueue(4));
        assertEquals(2, queue.Front());
        assertEquals(4, queue.Rear());
        assertTrue(queue.isFull());
        assertFalse(queue.isEmpty());
    }

}
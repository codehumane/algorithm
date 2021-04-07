package data.queue;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1337/<br/>
 * <br/>
 * Design your implementation of the circular queue.
 * The circular queue is a linear data structure
 * in which the operations are performed based on FIFO (First In First Out) principle
 * and the last position is connected back to the first position to make a circle.
 * It is also called "Ring Buffer".<br/>
 * <br/>
 * One of the benefits of the circular queue is that
 * we can make use of the spaces in front of the queue.
 * In a normal queue, once the queue becomes full,
 * we cannot insert the next element even if there is a space in front of the queue.
 * But using the circular queue, we can use the space to store new values.<br/>
 * <br/>
 * Implementation the MyCircularQueue class:<br/>
 * <br/>
 * - MyCircularQueue(k) Initializes the object with the size of the queue to be k.<br/>
 * - int Front() Gets the front item from the queue. If the queue is empty, return -1.<br/>
 * - int Rear() Gets the last item from the queue. If the queue is empty, return -1.<br/>
 * - boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.<br/>
 * - boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.<br/>
 * - boolean isEmpty() Checks whether the circular queue is empty or not.<br/>
 * - boolean isFull() Checks whether the circular queue is full or not.<br/>
 */
public class MyCircularQueue {

    private final int[] data;
    private int front = -1;
    private int rear = -1;
    private int count = 0;

    public MyCircularQueue(int k) {
        if (k < 1) throw new IllegalArgumentException();
        data = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear++;
            if (rear == data.length) {
                rear = 0;
            }
        }

        data[rear] = value;
        count++;

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;

        count--;

        if (isEmpty()) {
            front = -1;
            rear = -1;
        } else {
            front++;
            if (front == data.length) {
                front = 0;
            }
        }

        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return data[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return data[rear];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == data.length;
    }
}

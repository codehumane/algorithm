package data.queue;

interface PriorityQueue<E> {

    void offer(E element, int priority);

    E poll();
}

package data.queue;

import lombok.Value;

class ArrayPriorityQueue implements PriorityQueue<Object> {

    private final Element[] queue;
    private int filledSize = 0;

    ArrayPriorityQueue(int capacity) {
        this.queue = new Element[capacity];
    }

    @Override
    public void offer(Object element, int priority) {
        if (filledSize == queue.length)
            throw new IllegalStateException("queue.full");

        queue[filledSize++] = new Element(element, priority);
    }

    @Override
    public Object poll() {

        if (filledSize == 0) return null;

        Element highest = queue[0];
        queue[0] = null;

        for (int i = 1; i < filledSize; i++) {
            if (highest.priority > queue[i].priority) {
                Element current = queue[i];
                queue[i] = highest;
                highest = current;
            }

            queue[i - 1] = queue[i];
        }

        filledSize--;
        return highest.getValue();
    }

    @Value
    private class Element {

        private final Object value;
        private final int priority;
    }
}

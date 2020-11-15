package data.tree;

import java.util.PriorityQueue;

public class KthLargest {

    private final PriorityQueue<Integer> queue;
    private final int capacity;

    public KthLargest(int k, int[] nums) {
        capacity = k;
        queue = new PriorityQueue<>(k + 1);
        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > capacity) queue.poll();
        if (queue.isEmpty()) throw new IllegalStateException();
        return queue.peek();
    }

}

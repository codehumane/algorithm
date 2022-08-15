package quiz.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {

    private final LinkedHashMapExtension map;

    /**
     * Initialize the LRU cache with positive size capacity
     */
    public LRUCache(int capacity) {
        this.map = new LinkedHashMapExtension(capacity);
    }

    /**
     * Return the value of the key if the key exists,
     * otherwise return -1.<br/>
     * <br/>
     * O(1)
     */
    public int get(int key) {
        return map.get(key);
    }

    /**
     * Update the value of the key if the key exists.
     * Otherwise, add the key-value pair to the cache.
     * If the number of keys exceeds the capacity from this operation,
     * evict the least recently used key.<br/>
     * <br/>
     * O(1)
     */
    public void put(int key, int value) {
        map.put(key, value);
    }

    static class LinkedHashMapExtension
            extends LinkedHashMap<Integer, Integer> {

        private final int cacheSize;

        public LinkedHashMapExtension(int capacity) {
            super(capacity, 0.75F, true);
            this.cacheSize = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return super.size() > cacheSize;
        }
    }

}

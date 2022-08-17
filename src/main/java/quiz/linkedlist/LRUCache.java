package quiz.linkedlist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {

    private final LinkedHashMapExtension map;
    private final UsingDoublyLinkedList linkedList;

    /**
     * Initialize the LRU cache with positive size capacity
     */
    public LRUCache(int capacity) {
        this.map = new LinkedHashMapExtension(capacity);
        this.linkedList = new UsingDoublyLinkedList(capacity);
    }

    /**
     * Return the value of the key if the key exists,
     * otherwise return -1.<br/>
     * <br/>
     * O(1)
     */
    public int get(int key) {
        assert map.get(key) == linkedList.get(key);
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
        linkedList.put(key, value);
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

    static class UsingDoublyLinkedList {

        private final Map<Integer, Entry> entries;
        private final int capacity;
        private Entry head;
        private Entry tail;

        public UsingDoublyLinkedList(int capacity) {
            this.entries = new HashMap<>(capacity);
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!entries.containsKey(key)) return -1;

            var entry = entries.get(key);
            moveToLast(entry);
            return entry.value;
        }

        public void put(int key, int value) {
            if (entries.containsKey(key)) {
                var entry = entries.get(key);
                entry.value = value;
                moveToLast(entry);
            } else {
                var entry = new Entry(key, value);
                addToLast(key, entry);
            }
        }

        private void moveToLast(Entry entry) {
            // 이미 tail이면 할 것이 X
            if (tail == entry) return;

            // entry 중간 연결에서 끊어내기
            if (entry.before != null) entry.before.after = entry.after;
            if (entry.after != null) entry.after.before = entry.before;
            if (head == entry) head = entry.after;

            // entry 새로 연결
            entry.after = null;
            entry.before = tail;
            if (tail != null) tail.after = entry;
            tail = entry;
        }

        private void addToLast(int key, Entry entry) {
            entries.put(key, entry);

            if (tail != null) {
                tail.after = entry;
                entry.before = tail;
            }
            tail = entry;

            if (head == null) {
                head = entry;
            } else if (entries.size() > capacity) {
                entries.remove(head.key);
                head.after.before = null;
                head = head.after;
            }
        }

        static class Entry {

            final int key;

            int value;
            Entry before;
            Entry after;

            Entry(int key, int value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Entry entry = (Entry) o;
                return key == entry.key;
            }

            @Override
            public int hashCode() {
                return Objects.hash(key);
            }

            @Override
            public String toString() {
                return "Entry{" +
                        "key=" + key +
                        ", value=" + value +
                        '}';
            }
        }
    }

}

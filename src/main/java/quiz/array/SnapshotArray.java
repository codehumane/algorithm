package quiz.array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/snapshot-array/
 */
public class SnapshotArray {

    // index -> snap_id -> val
    private final Map<Integer, TreeMap<Integer, Integer>> snapshots = new HashMap<>();
    private final int length;
    private int snapId = 0;

    public SnapshotArray(int length) {
        this.length = length;

        for (int i = 0; i < length; i++) {
            snapshots.put(i, new TreeMap<>());
            snapshots.get(i).put(snapId, 0);
        }
    }

    public int snap() {
        return snapId++;
    }

    public void set(int index, int val) {
        validateIndex(index);
        snapshots.get(index).put(snapId, val);
    }

    public int get(int index, int snap_id) {
        validateIndex(index);

        return snapshots
                .get(index)
                .floorEntry(snap_id)
                .getValue();
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException();
        }
    }

}

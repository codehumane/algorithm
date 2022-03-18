package quiz.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/snapshot-array/
 */
public class SnapshotArray {

    // index -> snap_id -> val
    private final Map<Integer, Map<Integer, Integer>> snapshots = new HashMap<>();
    private final int length;
    private int snapId = 0;

    public SnapshotArray(int length) {
        this.length = length;

        for (int i = 0; i < length; i++) {
            snapshots.put(i, new HashMap<>());
            snapshots.get(i).put(snapId, 0);
        }
    }

    public void set(int index, int val) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException();
        }

        snapshots.get(index).put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        var snapshot = snapshots.get(index);
        if (snapshot == null) throw new IllegalStateException();

        var id = snap_id;
        while (id >= 0) {
            var value = snapshot.get(id);
            if (value != null) {
                return value;
            }
            id--;
        }

        throw new IllegalStateException();
    }

}

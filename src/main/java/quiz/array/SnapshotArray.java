package quiz.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/snapshot-array/
 */
public class SnapshotArray {

    private final Map<Integer, Integer> changed = new HashMap<>(); // index -> val (스냅샷으로 남을)
    private final Map<Integer, Map<Integer, Integer>> snapshots = new HashMap<>(); // index -> snap_id -> val (스냅샷)
    private int snapId = 0;

    public SnapshotArray(int length) {
        for (int i = 0; i < length; i++) {
            changed.put(i, 0);
        }
    }

    public void set(int index, int val) {
        changed.put(index, val);
    }

    public int snap() {
        changed.forEach((i, v) -> {
            snapshots.putIfAbsent(i, new HashMap<>());
            snapshots.get(i).put(snapId, v);
        });

        changed.clear();
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

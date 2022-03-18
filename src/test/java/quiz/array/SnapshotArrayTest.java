package quiz.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnapshotArrayTest {

    @Test
    void example1() {
        // set the length to be 3
        var snapshotArr = new SnapshotArray(3);
        // Set array[0] = 5
        snapshotArr.set(0, 5);
        // Take a snapshot, return snap_id = 0
        var snapId = snapshotArr.snap();
        snapshotArr.set(0, 6);
        // Get the value of array[0] with snap_id = 0, return 5
        var got = snapshotArr.get(0, snapId);

        assertEquals(0, snapId);
        assertEquals(5, got);
    }

    @Test
    void wrong1() {
        var s = new SnapshotArray(4);
        var snapId1 = s.snap();
        var snapId2 = s.snap();
        s.set(2, 4);
        var snapId3 = s.snap();
        s.set(1, 4);

        assertEquals(0, snapId1);
        assertEquals(1, snapId2);
        assertEquals(2, snapId3);
        assertEquals(0, s.get(0, snapId2));
        assertEquals(0, s.get(1, snapId2));
        assertEquals(0, s.get(2, snapId2));
        assertEquals(0, s.get(3, snapId2));
        assertEquals(0, s.get(0, snapId3));
        assertEquals(0, s.get(1, snapId3));
        assertEquals(4, s.get(2, snapId3));
        assertEquals(0, s.get(3, snapId3));
    }

}
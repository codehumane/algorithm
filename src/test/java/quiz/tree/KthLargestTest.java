package quiz.tree;

import lombok.val;
import org.junit.jupiter.api.Test;
import quiz.tree.KthLargest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthLargestTest {

    @Test
    public void example1() {
        val kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2}); // 8,5,4,2
        assertEquals(4, kthLargest.add(3)); // 8,5,4,3,2
        assertEquals(5, kthLargest.add(5)); // 8,5,5,4,3,2
        assertEquals(5, kthLargest.add(10)); // 10,8,5,5,4,3,2
        assertEquals(8, kthLargest.add(9)); // 10,9,8,5,5,4,3,2
        assertEquals(8, kthLargest.add(4)); // 10,9,8,5,5,4,4,3,2
    }
}
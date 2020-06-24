package ctci;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class LinkedListPartitionTest {

    /**
     * - Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
     * - Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
     */
    @Test
    public void partition() {

        // 문제
        int partition = 5;
        final LinkedListNode node = new LinkedListNode(3);
        LinkedListNode current = node;
        for (Integer v : Arrays.asList(5, 8, 5, 10, 2, 1)) {
            current.next = new LinkedListNode(v);
            current = current.next;
        }

        // 수행
        LinkedListNode result = new LinkedListPartition().partition(node, partition);

        // 확인
        assertTrue(partition > result.value); // 1,3,2 중 하나
        assertTrue(partition > result.next.value); // 1,3,2 중 하나
        assertTrue(partition > result.next.next.value); // 1,3,2 중 하나
        assertTrue(partition <= result.next.next.next.value); // 그 외
        assertTrue(partition <= result.next.next.next.next.value); // 그 외
        assertTrue(partition <= result.next.next.next.next.next.value); // 그 외
        assertTrue(partition <= result.next.next.next.next.next.next.value); // 그 외
    }
}
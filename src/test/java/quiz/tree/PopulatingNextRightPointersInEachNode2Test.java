package quiz.tree;

import data.tree.Node;
import org.junit.jupiter.api.Test;
import quiz.tree.PopulatingNextRightPointersInEachNode2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PopulatingNextRightPointersInEachNode2Test {

    private final PopulatingNextRightPointersInEachNode2 population = new PopulatingNextRightPointersInEachNode2();

    @Test
    public void connectExample1() {

        // given
        //       1
        //     /  \
        //   2      3
        //  / \      \
        // 4   5      7
        final Node node1 = new Node(1);
        final Node node2 = new Node(2);
        final Node node3 = new Node(3);
        final Node node4 = new Node(4);
        final Node node5 = new Node(5);
        final Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node7;

        // when
        final Node connected = population.connect(node1);

        // then
        //       1 → null
        //     /   \
        //   2   →   3 → null
        //  / \       \
        // 4 → 5   →   7 → null
        assertEquals(node1, connected);
        assertNull(node1.next);
        assertEquals(node3, node2.next);
        assertNull(node3.next);
        assertEquals(node5, node4.next);
        assertEquals(node7, node5.next);
        assertNull(node7.next);
    }

}
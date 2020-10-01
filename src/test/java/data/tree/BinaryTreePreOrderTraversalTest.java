package data.tree;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreePreOrderTraversalTest {

    private final BinaryTreePreOrderTraversal traversal = new BinaryTreePreOrderTraversal();

    @Test
    public void preOrderTraversalExample1() {

        // given
        val node1 = new TreeNode(1);
        val node2 = new TreeNode(2);
        val node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;

        // when
        val traversed = traversal.preOrderTraversal(node1);

        // then
        assertEquals(3, traversed.size());
        assertEquals(node1.val, traversed.get(0));
        assertEquals(node2.val, traversed.get(1));
        assertEquals(node3.val, traversed.get(2));
    }

    @Test
    public void preOrderTraversalExample2() {

        // when
        val traversed = traversal.preOrderTraversal(null);

        // then
        assertEquals(0, traversed.size());
    }

    @Test
    public void preOrderTraversalExample3() {

        // given
        val node1 = new TreeNode(1);

        // when
        val traversed = traversal.preOrderTraversal(node1);

        // then
        assertEquals(1, traversed.size());
        assertEquals(node1.val, traversed.get(0));
    }

    @Test
    public void preOrderTraversalExample4() {

        // given
        val node1 = new TreeNode(1);
        val node2 = new TreeNode(2);
        node1.left = node2;

        // when
        val traversed = traversal.preOrderTraversal(node1);

        // then
        assertEquals(2, traversed.size());
        assertEquals(node1.val, traversed.get(0));
        assertEquals(node2.val, traversed.get(1));
    }

    @Test
    public void preOrderTraversalExample5() {

        // given
        val node1 = new TreeNode(1);
        val node2 = new TreeNode(2);
        node1.right = node2;

        // when
        val traversed = traversal.preOrderTraversal(node1);

        // then
        assertEquals(2, traversed.size());
        assertEquals(node1.val, traversed.get(0));
        assertEquals(node2.val, traversed.get(1));
    }

}
package data.tree;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeInOrderTraversalTest {

    private static final BinaryTreeInOrderTraversal traversal = new BinaryTreeInOrderTraversal();

    @Test
    public void inOrderTraversalExample1() {

        // given
        val node1 = new TreeNode(1);
        val node2 = new TreeNode(2);
        val node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;

        // when
        val traversed = traversal.inOrderTraversal(node1);

        // then
        assertEquals(3, traversed.size());
        assertEquals(node1.val, traversed.get(0).intValue());
        assertEquals(node3.val, traversed.get(1).intValue());
        assertEquals(node2.val, traversed.get(2).intValue());
    }

    @Test
    public void inOrderTraversalExample2() {

        // when
        val traversed = traversal.inOrderTraversal(null);

        // then
        assertEquals(0, traversed.size());
    }

    @Test
    public void inOrderTraversalExample3() {

        // given
        val node1 = new TreeNode(1);

        // when
        val traversed = traversal.inOrderTraversal(node1);

        // then
        assertEquals(1, traversed.size());
        assertEquals(node1.val, traversed.get(0).intValue());
    }

    @Test
    public void inOrderTraversalExample4() {

        // given
        val node1 = new TreeNode(1);
        val node2 = new TreeNode(2);
        node1.left = node2;

        // when
        val traversed = traversal.inOrderTraversal(node1);

        // then
        assertEquals(2, traversed.size());
        assertEquals(node2.val, traversed.get(0).intValue());
        assertEquals(node1.val, traversed.get(1).intValue());
    }

    @Test
    public void inOrderTraversalExample5() {

        // given
        val node1 = new TreeNode(1);
        val node2 = new TreeNode(2);
        node1.right = node2;

        // when
        val traversed = traversal.inOrderTraversal(node1);

        // then
        assertEquals(2, traversed.size());
        assertEquals(node1.val, traversed.get(0).intValue());
        assertEquals(node2.val, traversed.get(1).intValue());
    }

}
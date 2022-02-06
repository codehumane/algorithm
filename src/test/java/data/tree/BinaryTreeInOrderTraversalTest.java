package data.tree;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeInOrderTraversalTest {

    private static final BinaryTreeInOrderTraversal traversal = new BinaryTreeInOrderTraversal();

    @Test
    public void inOrderTraversalExample1() {

        // given
        //   1
        //    \
        //     2
        //    /
        //   3
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
        //   1
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
        //  1
        //   \
        //    2
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

    @Test
    public void inOrderCustom1() {

        // given
        //      1
        //    /   \
        //   2     3
        //  / \   /
        // 4   5 7
        //    /   \
        //   6     8
        //
        // result:
        val node1 = new TreeNode(1);
        val node2 = new TreeNode(2);
        val node3 = new TreeNode(3);
        val node4 = new TreeNode(4);
        val node5 = new TreeNode(5);
        val node6 = new TreeNode(6);
        val node7 = new TreeNode(7);
        val node8 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node3.left = node7;
        node7.right = node8;

        // when
        val traversed = traversal.inOrderTraversal(node1);

        // then
        val expected = Arrays.asList(4, 2, 6, 5, 1, 7, 8, 3);
        assertEquals(expected, traversed);
    }

    @Test
    public void inOrderCustom2_같은_값이_2개_이상_존재할_때() {

        // given
        //      1
        //    /   \
        //   2     2
        //  / \   /
        // 4   5 7
        //    /   \
        //   6     8
        //
        // result:
        val node1 = new TreeNode(1);
        val node2 = new TreeNode(2);
        val node2_2 = new TreeNode(2);
        val node4 = new TreeNode(4);
        val node5 = new TreeNode(5);
        val node6 = new TreeNode(6);
        val node7 = new TreeNode(7);
        val node8 = new TreeNode(8);
        node1.left = node2;
        node1.right = node2_2;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node2_2.left = node7;
        node7.right = node8;

        // when
        val traversed = traversal.inOrderTraversal(node1);

        // then
        val expected = Arrays.asList(4, 2, 6, 5, 1, 7, 8, 2);
        assertEquals(expected, traversed);
    }

}
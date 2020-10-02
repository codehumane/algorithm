package data.tree;

import com.google.common.collect.Lists;
import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BinaryTreeLevelOrderTraversalTest {

    private final BinaryTreeLevelOrderTraversal traversal = new BinaryTreeLevelOrderTraversal();

    @Test
    public void levelOrderExample1() {

        // given:
        //   3
        //  / \
        // 9  20
        //   /  \
        //  15   7
        val node1 = new TreeNode(3);
        val node2 = new TreeNode(9);
        val node3 = new TreeNode(20);
        val node4 = new TreeNode(15);
        val node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        // when
        val traversed = traversal.levelOrder(node1);

        // then: [[3], [9, 20], [15, 7]]
        assertEquals(3, traversed.size());
        assertEquals(Lists.newArrayList(node1.val), traversed.get(0));
        assertEquals(Lists.newArrayList(node2.val, node3.val), traversed.get(1));
        assertEquals(Lists.newArrayList(node4.val, node5.val), traversed.get(2));
    }

    @Test
    public void levelOrderCustom1() {

        // given:
        //         3
        //       /   \
        //      9    20
        //     /    /  \
        //    10   15   7
        //          \
        //           8
        val node3 = new TreeNode(3);
        val node9 = new TreeNode(9);
        val node20 = new TreeNode(20);
        val node10 = new TreeNode(10);
        val node15 = new TreeNode(15);
        val node7 = new TreeNode(7);
        val node8 = new TreeNode(8);
        node3.left = node9;
        node3.right = node20;
        node9.left = node10;
        node20.left = node15;
        node20.right = node7;
        node15.right = node8;

        // when
        val traversed = traversal.levelOrder(node3);

        // then: [[3], [9, 20], [10, 15, 7], [8]]
        assertEquals(4, traversed.size());
        assertEquals(Lists.newArrayList(3), traversed.get(0));
        assertEquals(Lists.newArrayList(9, 20), traversed.get(1));
        assertEquals(Lists.newArrayList(10, 15, 7), traversed.get(2));
        assertEquals(Lists.newArrayList(8), traversed.get(3));
    }

    @Test
    public void levelOrderCustom2() {

        // when
        val traversed = traversal.levelOrder(null);

        // then
        assertTrue(traversed.isEmpty());
    }

}
package data.tree;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsertIntoABinarySearchTreeTest {

    private final InsertIntoABinarySearchTree tree = new InsertIntoABinarySearchTree();
    private final ValidateBinarySearchTree validator = new ValidateBinarySearchTree();

    @Test
    public void example1() {

        // given
        //      4
        //     / \
        //    2   7
        //   / \
        //  1   3
        val node4 = new TreeNode(4);
        val node2 = new TreeNode(2);
        val node7 = new TreeNode(7);
        val node1 = new TreeNode(1);
        val node3 = new TreeNode(3);
        node4.left = node2;
        node4.right = node7;
        node2.left = node1;
        node2.right = node3;

        // when
        val root = tree.insertIntoBST(node4, 5);

        // then
        assertNotNull(root);
        assertTrue(validator.isValidBST(root));
    }

    @Test
    public void custom_중간에_끼면서_왼쪽에_끼는_경우_1번째() {

        // given
        //      7
        //     / \
        //    3   9
        //   / \
        //  1   5
        val node7 = new TreeNode(7);
        val node3 = new TreeNode(3);
        val node9 = new TreeNode(9);
        val node1 = new TreeNode(1);
        val node5 = new TreeNode(5);
        node7.left = node3;
        node7.right = node9;
        node3.left = node1;
        node3.right = node5;

        // when
        val inserted = tree.insertIntoBST(node7, 6);

        // then
        //      7
        //     / \
        //    3   9
        //   / \
        //  1   5
        //       \
        //        6
        assertEquals(node7, inserted);
        assertEquals(node3, node7.left);
        assertEquals(node9, node7.right);
        assertEquals(node1, node7.left.left);
        assertEquals(node5, node7.left.right);
        assertEquals(6, node7.left.right.right.val);
        assertTrue(validator.isValidBST(inserted));
    }

    @Test
    public void custom_중간에_끼면서_왼쪽에_끼는_경우_2번째() {

        // given
        //      7
        //     / \
        //    3   9
        //   / \
        //  1   5
        val node7 = new TreeNode(7);
        val node3 = new TreeNode(3);
        val node9 = new TreeNode(9);
        val node1 = new TreeNode(1);
        val node5 = new TreeNode(5);
        node7.left = node3;
        node7.right = node9;
        node3.left = node1;
        node3.right = node5;

        // when
        val inserted = tree.insertIntoBST(node7, 2);

        // then
        //      7
        //     / \
        //    3   9
        //   / \
        //  1   5
        //   \
        //    2
        assertEquals(node7, inserted);
        assertEquals(node3, inserted.left);
        assertEquals(node9, inserted.right);
        assertEquals(node1, inserted.left.left);
        assertEquals(node5, inserted.left.right);
        assertEquals("새로 추가된 노드", 2, inserted.left.left.right.val);
        assertTrue(validator.isValidBST(inserted));
    }

    @Test
    public void custom_중간에_끼면서_오른쪽에_끼는_경우() {

        // given
        //      7
        //     / \
        //    3   9
        //   / \
        //  1   5
        val node7 = new TreeNode(7);
        val node3 = new TreeNode(3);
        val node9 = new TreeNode(9);
        val node1 = new TreeNode(1);
        val node5 = new TreeNode(5);
        node7.left = node3;
        node7.right = node9;
        node3.left = node1;
        node3.right = node5;

        // when
        val inserted = tree.insertIntoBST(node7, 8);

        // then
        //       7
        //     /   \
        //    3     9
        //   / \   /
        //  1   5 8
        assertEquals(node7, inserted);
        assertEquals(node3, inserted.left);
        assertEquals(node9, inserted.right);
        assertEquals(node1, inserted.left.left);
        assertEquals(node5, inserted.left.right);
        assertEquals("새로 추가된 노드", 8, inserted.right.left.val);
        assertTrue(validator.isValidBST(inserted));
    }

    @Test
    public void custom_맨_아래_끼면서_왼쪽에_끼는_경우() {

        // given
        //      7
        //     / \
        //    3   9
        //   / \
        //  1   5
        val node7 = new TreeNode(7);
        val node3 = new TreeNode(3);
        val node9 = new TreeNode(9);
        val node1 = new TreeNode(1);
        val node5 = new TreeNode(5);
        node7.left = node3;
        node7.right = node9;
        node3.left = node1;
        node3.right = node5;

        // when
        val inserted = tree.insertIntoBST(node7, 0);

        // then
        //       7
        //      / \
        //     3   9
        //    / \
        //   1   5
        //  /
        // 0
        assertEquals(node7, inserted);
        assertEquals(node3, inserted.left);
        assertEquals(node9, inserted.right);
        assertEquals(node1, inserted.left.left);
        assertEquals(node5, inserted.left.right);
        assertEquals("새로 추가된 노드", 0, inserted.left.left.left.val);
        assertTrue(validator.isValidBST(inserted));
    }

    @Test
    public void custom_맨_아래_끼면서_오른쪽에_끼는_경우() {

        // given
        //      7
        //     / \
        //    3   9
        //   / \
        //  1   5
        val node7 = new TreeNode(7);
        val node3 = new TreeNode(3);
        val node9 = new TreeNode(9);
        val node1 = new TreeNode(1);
        val node5 = new TreeNode(5);
        node7.left = node3;
        node7.right = node9;
        node3.left = node1;
        node3.right = node5;

        // when
        val inserted = tree.insertIntoBST(node7, 10);

        // then
        //      7
        //     / \
        //    3   9
        //   / \   \
        //  1   5   10
        assertEquals(node7, inserted);
        assertEquals(node3, inserted.left);
        assertEquals(node9, inserted.right);
        assertEquals(node1, inserted.left.left);
        assertEquals(node5, inserted.left.right);
        assertEquals("새로 추가된 노드", 10, inserted.right.right.val);
        assertTrue(validator.isValidBST(inserted));
    }

    @Test
    public void custom_삽입위치가_애매한_경우() {

        // given
        //      7
        //     / \
        //    3   9
        //   / \
        //  1   5
        val node7 = new TreeNode(7);
        val node3 = new TreeNode(3);
        val node9 = new TreeNode(9);
        val node1 = new TreeNode(1);
        val node5 = new TreeNode(5);
        node7.left = node3;
        node7.right = node9;
        node3.left = node1;
        node3.right = node5;

        // when
        val inserted = tree.insertIntoBST(node7, 4);

        // then
        //      7
        //     / \
        //    3   9
        //   / \
        //  1   5
        //     /
        //    4
        assertEquals(node7, inserted);
        assertEquals(node3, inserted.left);
        assertEquals(node9, inserted.right);
        assertEquals(node1, inserted.left.left);
        assertEquals(node5, inserted.left.right);
        assertEquals("새로 추가된 노드", 4, inserted.left.right.left.val);
        assertTrue(validator.isValidBST(inserted));
    }

    @Test
    public void custom_빈트리() {

        // when
        val inserted = tree.insertIntoBST(null, 4);

        // then
        assertEquals(4, inserted.val);
        assertNull(inserted.left);
        assertNull(inserted.right);
    }
}
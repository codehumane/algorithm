package data.tree;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteNodeInABinarySearchTreeTest {

    private final DeleteNodeInABinarySearchTree tree = new DeleteNodeInABinarySearchTree();
    private final ValidateBinarySearchTree validator = new ValidateBinarySearchTree();

    @Test
    public void example1() {

        // given
        //      5
        //    /   \
        //   3     6
        //  / \     \
        // 2   4     7
        val n5 = new TreeNode(5);
        val n3 = new TreeNode(3);
        val n6 = new TreeNode(6);
        val n2 = new TreeNode(2);
        val n4 = new TreeNode(4);
        val n7 = new TreeNode(7);
        n5.left = n3;
        n5.right = n6;
        n3.left = n2;
        n3.right = n4;
        n6.right = n7;

        // when
        val deleted = tree.deleteNode(n5, 3);

        // then
        //      5
        //    /   \
        //   2     6
        //    \     \
        //     4     7
        assertEquals(n5, deleted);
        assertEquals(n2, deleted.left);
        assertEquals(n6, deleted.right);
        assertEquals(n4, deleted.left.right);
        assertEquals(n7, deleted.right.right);
        assertTrue(validator.isValidBST(deleted));
    }

    @Test
    public void example2() {

        // given
        //      5
        //    /   \
        //   3     6
        //  / \     \
        // 2   4     7
        val n5 = new TreeNode(5);
        val n3 = new TreeNode(3);
        val n6 = new TreeNode(6);
        val n2 = new TreeNode(2);
        val n4 = new TreeNode(4);
        val n7 = new TreeNode(7);
        n5.left = n3;
        n5.right = n6;
        n3.left = n2;
        n3.right = n4;
        n6.right = n7;

        // when
        val deleted = tree.deleteNode(n5, 0);

        // then
        //      5
        //    /   \
        //   3     6
        //  / \     \
        // 2   4     7
        assertEquals(n5, deleted);
        assertEquals(n3, deleted.left);
        assertEquals(n6, deleted.right);
        assertEquals(n2, deleted.left.left);
        assertEquals(n4, deleted.left.right);
        assertEquals(n7, deleted.right.right);
        assertTrue(validator.isValidBST(deleted));
    }

    @Test
    public void example3() {
        assertNull(tree.deleteNode(null, 0));
    }

    @Test
    public void custom1() {

        // given
        //      5
        //    /
        //   3
        //  /
        // 2
        val n5 = new TreeNode(5);
        val n3 = new TreeNode(3);
        val n2 = new TreeNode(2);
        n5.left = n3;
        n3.left = n2;

        // when
        val deleted = tree.deleteNode(n5, 3);

        // then
        //      5
        //    /
        //   2
        assertEquals(n5, deleted);
        assertEquals(n2, deleted.left);
        assertNull(deleted.left.left);
        assertNull(deleted.left.right);
        assertTrue(validator.isValidBST(deleted));
    }

    @Test
    public void custom2() {

        // given
        //      5
        //    /
        //   3
        //  /
        // 2
        val n5 = new TreeNode(5);
        val n3 = new TreeNode(3);
        val n2 = new TreeNode(2);
        n5.left = n3;
        n3.left = n2;

        // when
        val deleted = tree.deleteNode(n5, 5);

        // then
        //   3
        //  /
        // 2
        assertEquals(n3, deleted);
        assertEquals(n2, deleted.left);
        assertNull(deleted.right);
        assertNull(deleted.left.left);
        assertNull(deleted.left.right);
        assertTrue(validator.isValidBST(deleted));
    }

    @Test
    public void custom3() {

        // given
        //      5
        //    /
        //   3
        //  / \
        // 2   4
        val n5 = new TreeNode(5);
        val n3 = new TreeNode(3);
        val n2 = new TreeNode(2);
        val n4 = new TreeNode(4);
        n5.left = n3;
        n3.left = n2;
        n3.right = n4;

        // when
        val deleted = tree.deleteNode(n5, 5);

        // then
        //   3
        //  / \
        // 2   4
        assertEquals(n3, deleted);
        assertEquals(n2, deleted.left);
        assertEquals(n4, deleted.right);
        assertTrue(validator.isValidBST(deleted));
    }

    @Test
    public void failed1() {

        // given
        //      5
        //    /   \
        //   3     6
        //  / \     \
        // 2   4     7
        val n5 = new TreeNode(5);
        val n3 = new TreeNode(3);
        val n6 = new TreeNode(6);
        val n2 = new TreeNode(2);
        val n4 = new TreeNode(4);
        val n7 = new TreeNode(7);
        n5.left = n3;
        n5.right = n6;
        n3.left = n2;
        n3.right = n4;
        n6.right = n7;

        // when
        val deleted = tree.deleteNode(n5, 5);

        // then
        //      4
        //    /   \
        //   3     6
        //  /       \
        // 2         7
        assertEquals(n4, deleted);
        assertEquals(n3, deleted.left);
        assertEquals(n6, deleted.right);
        assertEquals(n2, deleted.left.left);
        assertEquals(n7, deleted.right.right);
        assertTrue(validator.isValidBST(deleted));
    }

    @Test
    public void failed2() {

        //     4
        //      \
        //       7
        //     /   \
        //    6     8
        //   /       \
        //  5         9
        val n4 = new TreeNode(4);
        val n7 = new TreeNode(7);
        val n6 = new TreeNode(6);
        val n8 = new TreeNode(8);
        val n5 = new TreeNode(5);
        val n9 = new TreeNode(9);
        n4.right = n7;
        n7.left = n6;
        n7.right = n8;
        n6.left = n5;
        n8.right = n9;

        // when
        val deleted = tree.deleteNode(n4, 7);

        // then
        //     4
        //      \
        //       6
        //     /   \
        //    5     8
        //           \
        //            9
        assertEquals(n4, deleted);
        assertNull(deleted.left);
        assertEquals(n6, deleted.right);
        assertEquals(n5, deleted.right.left);
        assertEquals(n8, deleted.right.right);
        assertEquals(n9, deleted.right.right.right);
        assertTrue(validator.isValidBST(deleted));
    }

}
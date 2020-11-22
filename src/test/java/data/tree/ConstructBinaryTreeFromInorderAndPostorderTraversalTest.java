package data.tree;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstructBinaryTreeFromInorderAndPostorderTraversalTest {

    private final ConstructBinaryTreeFromInorderAndPostorderTraversal traversal =
            new ConstructBinaryTreeFromInorderAndPostorderTraversal();

    @Test
    public void buildTreeExample1() {

        // given
        final int[] inorder = {9, 3, 15, 20, 7};
        final int[] postorder = {9, 15, 7, 20, 3};

        // when
        val tree = traversal.buildTree(inorder, postorder);

        // then:
        //    3
        //   / \
        //  9  20
        //    /  \
        //   15   7
        assertEquals(3, tree.val);
        assertEquals(9, tree.left.val);
        assertEquals(20, tree.right.val);
        assertEquals(15, tree.right.left.val);
        assertEquals(7, tree.right.right.val);
    }

    @Test
    public void buildTreeInduction1() {

        // given
        final int[] inorder = {1};
        final int[] postorder = {1};

        // when
        val tree = traversal.buildTree(inorder, postorder);

        // then:
        //   1
        assertEquals(1, tree.val);
    }

    @Test
    public void buildTreeInduction2() {

        // given
        final int[] inorder = {2, 1};
        final int[] postorder = {2, 1};

        // when
        val tree = traversal.buildTree(inorder, postorder);

        // then:
        //   1
        //  /
        // 2
        assertEquals(1, tree.val);
        assertEquals(2, tree.left.val);
    }

    @Test
    public void buildTreeInduction3() {

        // given
        final int[] inorder = {2, 1, 4};
        final int[] postorder = {2, 4, 1};

        // when
        val tree = traversal.buildTree(inorder, postorder);

        // then:
        //   1
        //  / \
        // 2   4
        assertEquals(1, tree.val);
        assertEquals(2, tree.left.val);
        assertEquals(4, tree.right.val);
    }

    @Test
    public void buildTreeInduction4() {

        // given
        final int[] inorder = {1, 4};
        final int[] postorder = {4, 1};

        // when
        val tree = traversal.buildTree(inorder, postorder);

        // then:
        //   1
        //    \
        //     4
        assertEquals(1, tree.val);
        assertEquals(4, tree.right.val);
    }

    @Test
    public void buildTreeCustom2() {

        // given
        final int[] inorder = {2, 1, 4};
        final int[] postorder = {2, 1, 4};

        // when
        val tree = traversal.buildTree(inorder, postorder);

        // then:
        //     4
        //    /
        //   1
        //  /
        // 2
        assertEquals(4, tree.val);
        assertEquals(1, tree.left.val);
        assertEquals(2, tree.left.left.val);
    }

    @Test
    public void buildTreeCustom3() {

        // given
        final int[] inorder = {2, 1, 4, 3};
        final int[] postorder = {2, 1, 3, 4};

        // when
        val tree = traversal.buildTree(inorder, postorder);

        // then:
        //     4
        //    / \
        //   1   3
        //  /
        // 2
        assertEquals(4, tree.val);
        assertEquals(1, tree.left.val);
        assertEquals(2, tree.left.left.val);
        assertEquals(3, tree.right.val);
    }

    @Test
    public void buildTreeCustom4() {

        // given
        final int[] inorder = {2, 1, 3, 4};
        final int[] postorder = {2, 3, 1, 4};

        // when
        val tree = traversal.buildTree(inorder, postorder);

        // then:
        //     4
        //    /
        //   1
        //  / \
        // 2   3
        assertEquals(4, tree.val);
        assertEquals(1, tree.left.val);
        assertEquals(2, tree.left.left.val);
        assertEquals(3, tree.left.right.val);
    }

    @Test
    public void buildTreeCustom5() {

        // given
        final int[] inorder = {2, 1, 5, 4, 3};
        final int[] postorder = {2, 5, 1, 3, 4};

        // when
        val tree = traversal.buildTree(inorder, postorder);

        // then:
        //     4
        //    / \
        //   1   3
        //  / \
        // 2   5
        assertEquals(4, tree.val);
        assertEquals(1, tree.left.val);
        assertEquals(2, tree.left.left.val);
        assertEquals(5, tree.left.right.val);
        assertEquals(3, tree.right.val);
    }

    @Test
    public void buildTreeCustom6() {

        // given
        final int[] inorder = {2, 1, 5, 4, 6, 3};
        final int[] postorder = {2, 5, 1, 4, 3, 6};

        // when
        val tree = traversal.buildTree(inorder, postorder);

        // then:
        //       6
        //      / \
        //     4   3
        //    /
        //   1
        //  / \
        // 2   5
        assertEquals(6, tree.val);
        assertEquals(4, tree.left.val);
        assertEquals(1, tree.left.left.val);
        assertEquals(2, tree.left.left.left.val);
        assertEquals(5, tree.left.left.right.val);
        assertEquals(3, tree.right.val);
    }

    @Test
    public void buildTreeCustom7() {

        // given
        final int[] inorder = {1, 5, 4, 6, 3};
        final int[] postorder = {5, 1, 4, 3, 6};

        // when
        val tree = traversal.buildTree(inorder, postorder);

        // then:
        //       6
        //      / \
        //     4   3
        //    /
        //   1
        //    \
        //     5
        assertEquals(6, tree.val);
        assertEquals(4, tree.left.val);
        assertEquals(1, tree.left.left.val);
        assertEquals(5, tree.left.left.right.val);
        assertEquals(3, tree.right.val);
    }

    @Test
    public void buildTreeCustom8() {

        // given
        final int[] inorder = {4, 6, 3, 7, 1, 5};
        final int[] postorder = {4, 7, 5, 1, 3, 6};

        // when
        val tree = traversal.buildTree(inorder, postorder);

        // then:
        //    6
        //   / \
        //  4   3
        //       \
        //        1
        //       / \
        //      7    5
        assertEquals(6, tree.val);
        assertEquals(4, tree.left.val);
        assertEquals(3, tree.right.val);
        assertEquals(1, tree.right.right.val);
        assertEquals(7, tree.right.right.left.val);
        assertEquals(5, tree.right.right.right.val);
    }

}
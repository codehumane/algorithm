package data.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

    private final ConstructBinaryTreeFromPreorderAndInorderTraversal traversal =
            new ConstructBinaryTreeFromPreorderAndInorderTraversal();

    @Test
    public void buildTreeExample1() {

        // given
        final int[] preorder = {3, 9, 20, 15, 7};
        final int[] inorder = {9, 3, 15, 20, 7};

        // when
        final TreeNode root = traversal.buildTree(preorder, inorder);

        // then:
        //     3
        //    / \
        //   9  20
        //     /  \
        //    15   7
        assertEquals(3, root.val.intValue());
        assertEquals(9, root.left.val.intValue());
        assertEquals(20, root.right.val.intValue());
        assertEquals(15, root.right.left.val.intValue());
        assertEquals(7, root.right.right.val.intValue());
    }

}
package data.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(3, root.val);
        assertEquals(9, root.left.val);
        assertEquals(20, root.right.val);
        assertEquals(15, root.right.left.val);
        assertEquals(7, root.right.right.val);
    }

}
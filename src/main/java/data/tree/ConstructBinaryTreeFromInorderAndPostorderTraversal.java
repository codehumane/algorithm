package data.tree;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /**
     * Given inorder and postorder traversal of a tree, construct the binary tree.
     * <p>
     * Note:
     * You may assume that duplicates do not exist in the tree.
     * <p>
     * For example, given
     * <p>
     * inorder = [9,3,15,20,7]
     * postorder = [9,15,7,20,3]
     * Return the following binary tree:
     * <p>
     * ....3
     * .../.\
     * ..9..20
     * ..../..\
     * ...15...7
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;

        return build(
                inorder,
                postorder,
                0,
                inorder.length - 1,
                new AtomicInteger(postorder.length - 1)
        );
    }

    private TreeNode build(int[] inorder,
                           int[] postorder,
                           int inorderFrom,
                           int inorderTo,
                           AtomicInteger postIndex) {

        if (inorderFrom > inorderTo) return null;
        final TreeNode parent = new TreeNode(postorder[postIndex.getAndDecrement()]);
        final int parentIndex = findIndex(parent.val, inorder, inorderFrom, inorderTo);

        parent.right = build(
                inorder,
                postorder,
                parentIndex + 1,
                inorderTo,
                postIndex
        );

        parent.left = build(
                inorder,
                postorder,
                inorderFrom,
                parentIndex - 1,
                postIndex
        );

        return parent;
    }

    private int findIndex(int value, int[] source, int from, int to) {
        return IntStream
                .range(from, to + 1)
                .filter(i -> source[i] == value)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }

}

package data.tree;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 * <p>
 * ....3
 * .../.\
 * ..9..20
 * ..../..\
 * ...15...7
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        final AtomicInteger preIdx = new AtomicInteger(0);
        return build(preorder, inorder, 0, preorder.length - 1, preIdx);
    }

    private TreeNode build(int[] preorder, int[] inorder, int inFrom, int inTo, AtomicInteger preIdx) {
        if (inFrom > inTo) return null;

        final TreeNode parent = new TreeNode(preorder[preIdx.getAndIncrement()]);
        int parentIdx = findIndex(parent.val, inorder, inFrom, inTo);
        parent.left = build(preorder, inorder, inFrom, parentIdx - 1, preIdx);
        parent.right = build(preorder, inorder, parentIdx + 1, inTo, preIdx);

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

package data.tree;

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
                new PostIndex(postorder.length - 1)
        );
    }

    private TreeNode build(int[] inorder,
                           int[] postorder,
                           int inorderFrom,
                           int inorderTo,
                           PostIndex postIndex) {

        if (inorderFrom > inorderTo) return null;
        final TreeNode parent = new TreeNode(postorder[postIndex.val]);
        final int parentIndex = findIndex(parent.val, inorder);
        postIndex.decrease();

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

    private int findIndex(int value, int[] source) {
        return IntStream
                .range(0, source.length)
                .filter(i -> source[i] == value)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    static class PostIndex {
        int val;

        PostIndex(int val) {
            this.val = val;
        }

        void decrease() {
            val--;
        }
    }

}

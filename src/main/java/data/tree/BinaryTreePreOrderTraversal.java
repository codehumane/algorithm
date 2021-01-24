package data.tree;

import java.util.*;

public class BinaryTreePreOrderTraversal {

    /**
     * Root -> Left -> Right
     */
    // given:
    //      1
    //    /   \
    //   2     3
    //  / \   /
    // 4   5 6
    //
    // result:
    // 1 2 4 5 6 3
    public List<Integer> preOrderTraversal(TreeNode root) {
        final List<Integer> iterative = byIterative(root);
        final List<Integer> recursive = byRecursive(root);

        if (!iterative.equals(recursive)) {
            throw new IllegalStateException();
        }

        return recursive;
    }

    private List<Integer> byIterative(TreeNode root) {
        if (root == null) return Collections.emptyList();

        final List<Integer> result = new ArrayList<>();
        final Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);

        while (!deque.isEmpty()) {
            final TreeNode node = deque.pop();
            result.add(node.val);

            if (node.right != null) deque.push(node.right);
            if (node.left != null) deque.push(node.left);
        }

        return result;
    }

    private List<Integer> byRecursive(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode node, List<Integer> result) {
        if (node == null) return;

        result.add(node.val);
        traversal(node.left, result);
        traversal(node.right, result);
    }

}

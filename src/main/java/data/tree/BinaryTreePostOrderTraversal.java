package data.tree;

import java.util.*;

public class BinaryTreePostOrderTraversal {

    /**
     * Left -> Right -> Root
     */
    // given:
    //     1
    //    / \
    //   2   3
    //  / \
    // 4   5
    //
    // result:
    // 4 5 2 3 1
    public List<Integer> postOrderTraversal(TreeNode root) {
        final List<Integer> recursive = byRecursive(root);
        final List<Integer> iterative = byIterative(root);

        if (!recursive.equals(iterative)) {
            throw new IllegalStateException();
        }

        return recursive;
    }

    private List<Integer> byIterative(TreeNode root) {
        if (root == null) return Collections.emptyList();

        final Deque<TreeNode> deque = new ArrayDeque<>();
        final List<Integer> result = new ArrayList<>();
        deque.push(root);

        while (!deque.isEmpty()) {
            final TreeNode node = deque.pop();
            result.add(0, node.val);

            if (node.left != null) deque.push(node.left);
            if (node.right != null) deque.push(node.right);
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
        traversal(node.left, result);
        traversal(node.right, result);
        result.add(node.val);
    }
}

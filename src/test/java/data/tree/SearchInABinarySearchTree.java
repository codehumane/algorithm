package data.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the root node of a binary search tree (BST) and a value.
 * You need to find the node in the BST that the node's value equals the given value.
 * Return the subtree rooted with that node.
 * If such node doesn't exist, you should return NULL.
 */
public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        final Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);

        while (!deque.isEmpty()) {
            final TreeNode node = deque.pop();
            if (val == node.val) return node;
            if (val < node.val && node.left != null) deque.add(node.left);
            if (val > node.val && node.right != null) deque.add(node.right);
        }

        return null;
    }
}

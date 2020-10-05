package data.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class PopulatingNextRightPointersInEachNode2 {

    /**
     * Given a binary tree (완전 이진 트리가 아님)
     * <p>
     * struct Node {
     * int val;
     * Node *left;
     * Node *right;
     * Node *next;
     * }
     * Populate each next pointer to point to its next right node.
     * If there is no next right node, the next pointer should be set to NULL.
     * <p>
     * Initially, all next pointers are set to NULL.
     * <p>
     * <p>
     * Follow up:
     * <p>
     * You may only use constant extra space.
     * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
     */
    public Node connect(Node root) {
        final Deque<Node> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            Node first = queue.remove();
            Node left = first;

            while (!queue.isEmpty()) {
                final Node right = queue.remove();
                left.next = right;
                left = right;
            }

            while (first != null) {
                if (first.left != null) queue.add(first.left);
                if (first.right != null) queue.add(first.right);
                first = first.next;
            }
        }

        return root;
    }
}

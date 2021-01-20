package data.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class BinaryTreeInOrderTraversal {

    /**
     * Left -> Root -> Right
     */
    // given:
    //     1
    //    / \
    //   2   3
    //  / \
    // 4   5
    //
    // result:
    // 4 2 5 1 3
    public List<Integer> inOrderTraversal(TreeNode root) {
        final List<Integer> recursive = recursiveApproach(root);
        final List<Integer> iterative = iterativeApproach(root);

        if (!recursive.equals(iterative)) {
            throw new IllegalStateException();
        }

        return iterative;
    }

    private List<Integer> iterativeApproach(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        final Set<TreeNode> visited = new HashSet<>();
        final Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);

        while (!deque.isEmpty()) {
            final TreeNode node = deque.peek();

            if (!visited.contains(node)) {
                visited.add(node);
                if (node.left != null) {
                    deque.push(node.left);
                }
            } else {
                deque.pop();
                result.add(node.val);
                if (node.right != null) {
                    deque.push(node.right);
                }
            }
        }

        return result;
    }

    private List<Integer> recursiveApproach(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode node, List<Integer> result) {
        if (node == null) return;
        traversal(node.left, result);
        result.add(node.val);
        traversal(node.right, result);
    }

}

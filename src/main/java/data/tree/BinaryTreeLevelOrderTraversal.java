package data.tree;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeLevelOrderTraversal {

    /**
     * Given a binary tree,
     * return the level order traversal of its nodes' values.
     * (ie, from left to right, level by level).
     */
    // For example:
    // Given binary tree [3,9,20,null,null,15,7],
    //     3
    //    / \
    //   9  20
    //     /  \
    //    15   7
    // return its level order traversal as:
    // [
    //   [3],
    //   [9,20],
    //   [15,7]
    // ]
    //
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        final List<List<Integer>> result = new ArrayList<>();
        final Queue<List<TreeNode>> queue = new ArrayDeque<>();
        queue.add(Collections.singletonList(root));

        while (!queue.isEmpty()) {
            final List<TreeNode> nodes = queue.remove();
            final List<TreeNode> next = getNextLevel(nodes);

            result.add(mapToValues(nodes));
            if (!next.isEmpty()) queue.add(next);
        }

        return result;
    }

    private List<TreeNode> getNextLevel(List<TreeNode> nodes) {
        final List<TreeNode> next = new ArrayList<>();

        nodes.forEach(n -> {
            if (n.left != null) next.add(n.left);
            if (n.right != null) next.add(n.right);
        });

        return next;
    }

    private List<Integer> mapToValues(List<TreeNode> nodes) {
        return nodes
                .stream()
                .map(x -> x.val)
                .collect(Collectors.toList());
    }

}

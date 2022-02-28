package quiz.tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
 */
public class FindLeavesOfBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        var collected = new ArrayList<List<Integer>>();
        var removed = new HashSet<TreeNode>();

        while ((root.left != null && !removed.contains(root.left)) ||
                (root.right != null && !removed.contains(root.right))) {

            var leaves = collect(root, removed);
            var leafValues = leaves
                    .stream()
                    .map(l -> l.val)
                    .collect(Collectors.toList());

            collected.add(leafValues);
            removed.addAll(leaves);
        }

        collected.add(List.of(root.val));
        return collected;
    }

    private List<TreeNode> collect(TreeNode root, Set<TreeNode> removed) {
        var leaves = new ArrayList<TreeNode>();
        var deque = new ArrayDeque<TreeNode>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            var node = deque.poll();
            var isLeftEmpty = node.left == null || removed.contains(node.left);
            var isRightEmpty = node.right == null || removed.contains(node.right);

            if (isLeftEmpty && isRightEmpty) {
                leaves.add(node);
            }
            if (!isLeftEmpty) {
                deque.offer(node.left);
            }
            if (!isRightEmpty) {
                deque.offer(node.right);
            }
        }

        return leaves;
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

}

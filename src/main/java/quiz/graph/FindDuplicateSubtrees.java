package quiz.graph;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/find-duplicate-subtrees/
 */
public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        var subtrees = new HashMap<String, Set<TreeNode>>();
        inorder(root, subtrees);
        return toResult(subtrees);
    }

    private String inorder(TreeNode node, Map<String, Set<TreeNode>> subtrees) {
        if (node == null) return "";

        var subtree = "<" +
                inorder(node.left, subtrees) +
                node.val +
                inorder(node.right, subtrees) +
                ">";

        subtrees.putIfAbsent(subtree, new HashSet<>());
        subtrees.get(subtree).add(node);
        return subtree;
    }

    private List<TreeNode> toResult(Map<String, Set<TreeNode>> subtrees) {

        return subtrees
                .values()
                .stream()
                .filter(treeNodes -> treeNodes.size() > 1)
                .map(treeNodes -> treeNodes.iterator().next())
                .collect(Collectors.toList());
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

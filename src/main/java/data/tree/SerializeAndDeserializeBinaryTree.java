package data.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string
 * and this string can be deserialized to the original tree structure.
 * <p>
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree.
 * You do not necessarily need to follow this format,
 * so please be creative and come up with different approaches yourself.
 * <p>
 * 자세한 포맷은 <a href="https://support.leetcode.com/hc/en-us/articles/360011883654-What-does-1-null-2-3-mean-in-binary-tree-representation-">여기</a> 참고.
 */
@Slf4j
public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        final List<TreeNode> visited = new ArrayList<>();
        final Deque<List<TreeNode>> queue = new ArrayDeque<>();
        queue.offer(Collections.singletonList(root));

        while (!queue.isEmpty()) {
            final List<TreeNode> parents = queue.poll();
            if (parents.stream().allMatch(Objects::isNull)) break;
            final List<TreeNode> children = new ArrayList<>();

            for (TreeNode node : parents) {
                visited.add(node);
                children.add(node == null ? null : node.left);
                children.add(node == null ? null : node.right);
            }

            queue.offer(children);
        }

        final String serialized = visited
                .stream()
                .map(n -> n == null ? "null" : String.valueOf(n.val))
                .collect(Collectors.joining(","));

        return "[" + serialized + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() < 3) return null;

        final List<TreeNode> parents = new ArrayList<>();
        final String[] values = data.substring(1, data.length() - 1).split(",");
        final TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        parents.add(root);
        int index = 1;

        while (!parents.isEmpty() && index < values.length) {
            final List<TreeNode> children = new ArrayList<>();

            for (TreeNode parent : parents) {
                final String lv = values[index++];
                final String rv = values[index++];

                final TreeNode left = lv.equals("null") ? null : new TreeNode(Integer.valueOf(lv));
                final TreeNode right = rv.equals("null") ? null : new TreeNode(Integer.valueOf(rv));

                if (parent != null) {
                    parent.left = left;
                    parent.right = right;
                }

                children.add(left);
                children.add(right);
            }

            parents.clear();
            parents.addAll(children);
        }

        return root;
    }

}

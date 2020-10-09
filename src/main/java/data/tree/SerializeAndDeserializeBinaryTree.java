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

        final String[] values = data.substring(1, data.length() - 1).split(",");
        final TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        appendChildren(root, values, 0);

        return root;
    }

    private void appendChildren(TreeNode node, String[] values, int valueIndex) {
        final int leftIndex = findLeftChildIndex(valueIndex);
        if (leftIndex < values.length && !"null".equals(values[leftIndex])) {
            node.left = new TreeNode(Integer.valueOf(values[leftIndex]));
            appendChildren(node.left, values, leftIndex);
        }

        final int rightIndex = leftIndex + 1;
        if (rightIndex < values.length && !"null".equals(values[rightIndex])) {
            node.right = new TreeNode(Integer.valueOf(values[rightIndex]));
            appendChildren(node.right, values, rightIndex);
        }
    }

    int findLeftChildIndex(int valueIndex) {
        final double exponent = Math.floor(Math.log(valueIndex + 1) / Math.log(2));
        final int leftMost = (int) Math.pow(2, exponent) * 2 - 1;
        final int farFrom = 2 * (valueIndex + 1 - (int) Math.pow(2, exponent));
        return leftMost + farFrom;
    }

}

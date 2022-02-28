package quiz.tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
 */
public class FindLeavesOfBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
//        return new FirstApproach().findLeaves(root);
//        return new DFSWithSorting().findLeaves(root);
//        return new DFSWithoutSorting().findLeaves(root);
        return new DFSWithoutSortingMoreEfficiently().findLeaves(root);
    }

    static class DFSWithoutSortingMoreEfficiently {

        public List<List<Integer>> findLeaves(TreeNode root) {
            var result = new ArrayList<List<Integer>>();
            collectHeight(root, result);
            return result;
        }

        private int collectHeight(TreeNode node, List<List<Integer>> result) {
            var left = node.left == null ? 0 : collectHeight(node.left, result);
            var right = node.right == null ? 0 : collectHeight(node.right, result);
            var height = Math.max(left, right) + 1;

            if (result.size() < height) {
                result.add(new ArrayList<>());
            }

            result.get(height - 1).add(node.val);
            return height;
        }

    }

    /**
     * O(N)
     * O(N)
     */
    static class DFSWithoutSorting {

        public List<List<Integer>> findLeaves(TreeNode root) {
            var heights = new HashMap<Integer, Set<TreeNode>>();
            collectHeight(root, heights);
            return toResultWithoutSort(heights);
        }

        private int collectHeight(TreeNode node, Map<Integer, Set<TreeNode>> heights) {
            var left = node.left == null ? 0 : collectHeight(node.left, heights);
            var right = node.right == null ? 0 : collectHeight(node.right, heights);
            var height = Math.max(left, right) + 1;

            heights.putIfAbsent(height, new HashSet<>());
            heights.get(height).add(node);
            return height;
        }

        private ArrayList<List<Integer>> toResultWithoutSort(HashMap<Integer, Set<TreeNode>> heights) {
            var result = new ArrayList<List<Integer>>();

            for (int i = 1; i <= heights.size(); i++) {
                var values = heights
                        .get(i)
                        .stream()
                        .map(n -> n.val)
                        .collect(Collectors.toList());

                result.add(values);
            }

            return result;
        }

    }

    /**
     * O(N·logN)
     * O(N)
     */
    static class DFSWithSorting {

        public List<List<Integer>> findLeaves(TreeNode root) {
            var heights = new HashMap<Integer, Set<TreeNode>>();
            collectHeight(root, heights);
            return toResult(heights);
        }

        private int collectHeight(TreeNode node, Map<Integer, Set<TreeNode>> heights) {
            var left = node.left == null ? 0 : collectHeight(node.left, heights);
            var right = node.right == null ? 0 : collectHeight(node.right, heights);
            var height = Math.max(left, right) + 1;

            heights.putIfAbsent(height, new HashSet<>());
            heights.get(height).add(node);
            return height;
        }

        private List<List<Integer>> toResult(HashMap<Integer, Set<TreeNode>> heights) {
            return heights
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .map(Map.Entry::getValue)
                    .map(this::sameHeightNodesToValues)
                    .collect(Collectors.toList());
        }

        private List<Integer> sameHeightNodesToValues(Set<TreeNode> nodes) {
            return nodes
                    .stream()
                    .map(n -> n.val)
                    .collect(Collectors.toList());
        }
    }

    /**
     * O(N^2)
     * O(N)
     */
    static class FirstApproach {
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
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

}

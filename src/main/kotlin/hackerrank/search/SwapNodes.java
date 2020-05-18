package hackerrank.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SwapNodes {

    /**
     * 일단 균형 트리는 아님.
     * 중복을 허용하는지에 대한 얘기는 없음. 하지만 실제 데이터를 보면 중복 허용 X.
     * in-order traversal.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        final int[][] result = new int[queries.length][indexes.length];
        final Node root = buildTree(indexes);

        for (int i = 0; i < queries.length; i++) {
            swapTree(root, queries[i]);
            result[i] = traverseTree(root, indexes.length);
        }

        return result;
    }

    private static Node buildTree(int[][] indexes) {

        int depth = 1;
        final Node root = new Node(1, depth, null);
        final Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        int index = 0;

        while (index < indexes.length) {

            depth++;
            final List<Node> temp = new ArrayList<>();
            while (!queue.isEmpty()) {

                final Node element = queue.poll();
                final int[] pair = indexes[index++];

                if (pair[0] != -1) {
                    element.left = new Node(pair[0], depth, element);
                    temp.add(element.left);
                }

                if (pair[1] != -1) {
                    element.right = new Node(pair[1], depth, element);
                    temp.add(element.right);
                }
            }

            for (Node t : temp) {
                queue.offer(t);
            }
        }

        return root;
    }

    private static void swapTree(Node node, int query) {
        if (node == null) return;

        swapTree(node.left, query);
        swapTree(node.right, query);

        if (node.depth % query == 0) {
            final Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

    private static int[] traverseTree(Node root, int size) {
        final boolean[] visited = new boolean[size + 1];
        final int[] traversed = new int[size];
        int traverseIndex = 0;
        Node current = root;

        while (traverseIndex < size) {
            if (visited[current.value]) {
                current = current.parent;
            } else if (current.left == null || visited[current.left.value]) {
                visited[current.value] = true;
                traversed[traverseIndex++] = current.value;
                if (current.right == null) {
                    current = current.parent;
                } else {
                    current = current.right;
                }
            } else {
                current = current.left;
            }
        }

        return traversed;
    }

    static class Node {

        final int value;
        final int depth;
        Node parent;
        Node left;
        Node right;

        public Node(int value, int depth, Node parent) {
            this.parent = parent;
            this.depth = depth;
            this.value = value;
        }

    }

}

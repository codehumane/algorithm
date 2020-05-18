package hackerrank.search;

import org.jetbrains.annotations.NotNull;

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
        final Node root = buildTree(indexes);

        // TODO swap

        final int[][] result = new int[queries.length][indexes.length];
        result[0] = traverseTree(root, indexes.length);
        return result;
    }

    @NotNull
    private static Node buildTree(int[][] indexes) {

        final Node root = new Node(1, null);
        final Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        int index = 0;

        while (index < indexes.length) {

            final List<Node> temp = new ArrayList<>();
            while (!queue.isEmpty()) {

                final Node element = queue.poll();
                final int[] pair = indexes[index++];

                if (pair[0] != -1) {
                    element.left = new Node(pair[0], element);
                    temp.add(element.left);
                }

                if (pair[1] != -1) {
                    element.right = new Node(pair[1], element);
                    temp.add(element.right);
                }
            }

            for (Node t : temp) {
                queue.offer(t);
            }

        }

        return root;
    }

    private static int[] traverseTree(Node root, int size) {

        final int[] traversed = new int[size];
        int traverseIndex = 0;
        Node current = root;

        while (traverseIndex < size) {

            if (current.visited) {
                current = current.parent;
            } else if (current.left == null || current.left.visited) {
                traversed[traverseIndex++] = current.value;
                current.visited = true;

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
        Node parent;
        Node left;
        Node right;
        boolean visited;

        public Node(int value, Node parent) {
            this.parent = parent;
            this.value = value;
        }

    }

}

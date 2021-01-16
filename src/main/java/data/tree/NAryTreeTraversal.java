package data.tree;

import java.util.*;

public class NAryTreeTraversal {

    /**
     * Given an n-ary tree, return the preorder traversal of its nodes' values.
     * <br/><br/>
     * Nary-Tree input serialization is represented in their level order traversal,
     * each group of children is separated by the null value (See examples).
     * <br/><br/>
     * Follow up:
     * <br/><br/>
     * Recursive solution is trivial, could you do it iteratively?
     */
    public List<Integer> preorder(NTNode root) {
        if (root == null) return Collections.emptyList();

        final List<Integer> result = new ArrayList<>();
        final Deque<NTNode> deque = new ArrayDeque<>();
        deque.push(root);

        while (!deque.isEmpty()) {
            final NTNode node = deque.pop();
            result.add(node.val);

            for (int i = node.children.size() - 1; i >= 0; i--) {
                deque.push(node.children.get(i));
            }
        }

        return result;
    }

    /**
     * Given an n-ary tree, return the postorder traversal of its nodes' values.
     * <br/><br/>
     * Nary-Tree input serialization is represented in their level order traversal,
     * each group of children is separated by the null value.
     * <br/><br/>
     * Follow up:
     * <br/><br/>
     * Recursive solution is trivial, could you do it iteratively?
     */
    public List<Integer> postorder(NTNode root) {
        if (root == null) return Collections.emptyList();

        final List<Integer> result = new ArrayList<>();
        final Deque<NTNode> deque = new ArrayDeque<>();
        deque.push(root);

        while (!deque.isEmpty()) {
            final NTNode node = deque.pop();
            result.add(0, node.val);

            for (NTNode child : node.children) {
                deque.push(child);
            }
        }

        return result;
    }

}

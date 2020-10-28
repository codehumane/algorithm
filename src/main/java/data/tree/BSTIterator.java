package data.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {

    private final Deque<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        addLefts(root);
    }

    private void addLefts(TreeNode node) {
        TreeNode current = node;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        final TreeNode popped = stack.pop();
        if (popped.right != null) addLefts(popped.right);
        return popped.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return stack.peek() != null;
    }

}

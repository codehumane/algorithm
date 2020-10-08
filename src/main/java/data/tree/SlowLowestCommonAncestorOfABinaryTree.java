package data.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlowLowestCommonAncestorOfABinaryTree implements LowestCommonAncestorOfABinaryTree {

    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode lca = null;
        final Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            lca = queue.remove();
            if (isAncestor(lca.left, p, q)) queue.add(lca.left);
            if (isAncestor(lca.right, p, q)) queue.add(lca.right);
        }

        return lca;
    }

    private boolean isAncestor(TreeNode ancestor, TreeNode p, TreeNode q) {
        if (ancestor == null) return false;
        boolean pFound = false;
        boolean qFound = false;

        List<TreeNode> parents = new ArrayList<>();
        parents.add(ancestor);

        while (!parents.isEmpty()) {
            final List<TreeNode> children = new ArrayList<>();
            for (TreeNode parent : parents) {
                if (parent.left != null) children.add(parent.left);
                if (parent.right != null) children.add(parent.right);
                if (parent.equals(p)) pFound = true;
                if (parent.equals(q)) qFound = true;
            }

            parents = children;
        }

        return pFound && qFound;
    }
}

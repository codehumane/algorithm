package data.tree;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node
 * in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LCAofBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        final Container container = new Container(root);
        find(root, container, p.val, q.val);
        return container.node;
    }

    private boolean find(TreeNode node, Container container, Integer p, Integer q) {
        if (node == null) return false;

        final boolean left = find(node.left, container, p, q);
        final boolean right = find(node.right, container, p, q);
        final boolean me = (node.val == p || node.val == q);

        final int point = (me ? 1 : 0) + (left ? 1 : 0) + (right ? 1 : 0);
        if (point > 1) container.node = node;
        
        return point > 0;
    }

    static class Container {

        public Container(TreeNode node) {
            this.node = node;
        }

        TreeNode node;
    }
}

package data.tree;

public class InefficientRecursiveLCAofBST implements LCAofBST {

    @Override
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

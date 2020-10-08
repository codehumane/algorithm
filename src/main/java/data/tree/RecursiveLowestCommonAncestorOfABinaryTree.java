package data.tree;

public class RecursiveLowestCommonAncestorOfABinaryTree implements LowestCommonAncestorOfABinaryTree {

    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        final LcaContainer lca = new LcaContainer();
        find(root, p, q, lca);
        return lca.value;
    }

    private boolean find(TreeNode node, TreeNode p, TreeNode q, LcaContainer lca) {
        if (node == null) return false;

        final boolean foundAtLeft = find(node.left, p, q, lca);
        final boolean foundAtRight = find(node.right, p, q, lca);
        final boolean foundAtHere = node == p || node == q;

        int score = 0;
        if (foundAtLeft) score++;
        if (foundAtRight) score++;
        if (foundAtHere) score++;
        if (score == 2) lca.value = node;

        return score > 0;
    }

    static class LcaContainer {
        TreeNode value;
    }

}

package data.tree;

/**
 * Given a root node reference of a BST and a key,
 * delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 * <p>
 * Basically, the deletion can be divided into two stages:
 * <p>
 * 1. Search for a node to remove.
 * 2. If the node is found, delete the node.
 * <p>
 * Follow up: Can you solve it with time complexity O(height of tree)?
 */
public class DeleteNodeInABinarySearchTree {

    public TreeNode deleteNode(TreeNode root, int key) {
        final WithParent target = find(root, key);
        if (target == null) return root;

        final WithParent left = new WithParent(target.node, target.node.left);
        final TreeNode removed = removeBiggest(left);
        return replace(target, removed, root);
    }

    private WithParent find(TreeNode root, int key) {
        WithParent cur = new WithParent(null, root);

        while (cur.node != null) {
            if (key == cur.value()) return cur;
            else if (key < cur.value()) cur = new WithParent(cur.node, cur.node.left);
            else cur = new WithParent(cur.node, cur.node.right);
        }

        return null;
    }

    private TreeNode removeBiggest(WithParent from) {
        if (from.node == null) return null;

        TreeNode parent = from.parent;
        TreeNode node = from.node;

        while (node.right != null) {
            parent = node;
            node = node.right;
        }

        if (parent.left == node) parent.left = node.left;
        else parent.right = null;

        return node;
    }

    private TreeNode replace(WithParent from, TreeNode to, TreeNode root) {
        if (to == null) {
            //   3
            //    \
            //     4
            //      \
            //       6
            //      / \
            //     5   7
            replaceChild(from, from.node.right);
            return from.node == root ? from.node.right : root;
        } else {
            //    2
            //  /   \
            // 1     5
            //      / \
            //     3   7
            //        /
            //       6
            replaceChild(from, to);
            to.right = from.node.right;
            to.left = from.node.left;
            return from.node == root ? to : root;
        }
    }

    private void replaceChild(WithParent from, TreeNode newChild) {
        if (from.parent == null) return;
        if (from.parent.right == from.node) from.parent.right = newChild;
        else from.parent.left = newChild;
    }

    static class WithParent {

        TreeNode parent;
        TreeNode node;

        WithParent(TreeNode parent, TreeNode node) {
            this.parent = parent;
            this.node = node;
        }

        Integer value() {
            if (node == null) return null;
            return node.val;
        }

        @Override
        public String toString() {
            return "WithParent{parent=" + parent + ", node=" + node + '}';
        }
    }

}

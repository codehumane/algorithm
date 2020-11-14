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

        return delete(root, target.parent, target.node);
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

    private TreeNode delete(TreeNode root, TreeNode parent, TreeNode node) {
        if (node.left == null && node.right == null) {
            root = replace(root, parent, node, null);

        } else if (node.left != null && node.right != null) {
            final TreeNode predecessor = findInorderPredecessor(node);
            deleteNode(root, predecessor.val);
            root = replace(root, parent, node, predecessor);
            predecessor.left = node.left;
            predecessor.right = node.right;

        } else {
            final TreeNode child = node.left != null ? node.left : node.right;
            root = replace(root, parent, node, child);
        }

        return root;
    }

    private TreeNode replace(TreeNode root, TreeNode parent, TreeNode from, TreeNode to) {
        if (from == root) root = to;
        else if (parent.left == from) parent.left = to;
        else parent.right = to;

        return root;
    }

    private TreeNode findInorderPredecessor(TreeNode node) {
        TreeNode predecessor = node.left;
        while (predecessor.right != null) {
            predecessor = predecessor.right;
        }

        return predecessor;
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

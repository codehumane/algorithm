package data.tree;

/**
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree.
 * Return the root node of the BST after the insertion.
 * It is guaranteed that the new value does not exist in the original BST.
 * <p>
 * Notice that there may exist multiple valid ways for the insertion,
 * as long as the tree remains a BST after insertion.
 * You can return any of them.
 */
public class InsertIntoABinarySearchTree {

    // 1. 위에서부터 차례로 내려가기
    public TreeNode insertIntoBST(TreeNode root, int val) {
        final TreeNode node = new TreeNode(val);
        if (root == null) return node;

        final TreeNode parent = findParent(root, val);
        insert(parent, node);
        return root;
    }

    private TreeNode findParent(TreeNode root, int val) {
        TreeNode node = root;

        while (true) {
            if (val < node.val && node.left != null) node = node.left;
            else if (val > node.val && node.right != null) node = node.right;
            else return node;
        }
    }

    private void insert(TreeNode parent, TreeNode node) {
        if (parent.val > node.val) {
            node.left = parent.left;
            parent.left = node;
        } else {
            node.right = parent.right;
            parent.right = node;
        }
    }

}

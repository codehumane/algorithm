package data.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * - The left subtree of a node contains only nodes with keys less than the node's key.
 * - The right subtree of a node contains only nodes with keys greater than the node's key.
 * - Both the left and right subtrees must also be binary search trees.
 */
@Slf4j
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        final List<Integer> inorder = new ArrayList<>();
        traverse(root, inorder);
        return validateAscending(inorder);
    }

    private void traverse(TreeNode node, List<Integer> inorder) {
        if (node == null) return;

        traverse(node.left, inorder);
        inorder.add(node.val);
        traverse(node.right, inorder);
    }

    private boolean validateAscending(List<Integer> inorder) {
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i - 1) >= inorder.get(i)) return false;
        }

        return true;
    }

}

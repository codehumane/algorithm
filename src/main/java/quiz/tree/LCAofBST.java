package quiz.tree;

import data.tree.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node
 * in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public interface LCAofBST {

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q);

}

package data.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreOrderTraversal {

    /**
     * Root -> Left -> Right
     */
    // given:
    //     1
    //    / \
    //   2   3
    //  / \
    // 4   5
    //
    // result:
    // 1 2 4 5 3
    public List<Integer> preOrderTraversal(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode node, List<Integer> result) {
        result.add(node.val);
        if (node.left != null) traversal(node.left, result);
        if (node.right != null) traversal(node.right, result);
    }

}

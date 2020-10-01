package data.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrderTraversal {

    /**
     * Left -> Root -> Right
     */
    // given:
    //     1
    //    / \
    //   2   3
    //  / \
    // 4   5
    //
    // result:
    // 4 2 5 1 3
    public List<Integer> inOrderTraversal(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode node, List<Integer> result) {
        if (node == null) return;
        traversal(node.left, result);
        result.add(node.val);
        traversal(node.right, result);
    }

}

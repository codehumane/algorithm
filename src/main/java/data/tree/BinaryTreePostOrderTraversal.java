package data.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrderTraversal {

    /**
     * Left -> Right -> Root
     */
    // given:
    //     1
    //    / \
    //   2   3
    //  / \
    // 4   5
    //
    // result:
    // 4 5 2 3 1
    public List<Integer> postOrderTraversal(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode node, List<Integer> result) {
        if (node == null) return;
        traversal(node.left, result);
        traversal(node.right, result);
        result.add(node.val);
    }
}

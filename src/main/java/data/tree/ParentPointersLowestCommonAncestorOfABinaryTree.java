package data.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class ParentPointersLowestCommonAncestorOfABinaryTree implements LowestCommonAncestorOfABinaryTree {

    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        final Map<TreeNode, TreeNode> parents = buildParents(root);
        final List<TreeNode> ancestors = buildAncestors(parents, p);
        return findCommonAncestor(parents, ancestors, q);
    }

    private Map<TreeNode, TreeNode> buildParents(TreeNode root) {
        final Deque<TreeNode> stack = new ArrayDeque<>();
        final Map<TreeNode, TreeNode> parents = new HashMap<>();

        stack.push(root);
        parents.put(root, null);

        while (!stack.isEmpty()) {
            final TreeNode node = stack.pop();

            if (node.right != null) {
                stack.push(node.right);
                parents.put(node.right, node);
            }

            if (node.left != null) {
                stack.push(node.left);
                parents.put(node.left, node);
            }
        }

        return parents;
    }

    private List<TreeNode> buildAncestors(Map<TreeNode, TreeNode> parents, TreeNode p) {
        final List<TreeNode> ancestors = new ArrayList<>();

        TreeNode ancestor = p;
        while (ancestor != null) {
            ancestors.add(ancestor);
            ancestor = parents.get(ancestor);
        }

        return ancestors;
    }

    private TreeNode findCommonAncestor(Map<TreeNode, TreeNode> parents,
                                        List<TreeNode> ancestors,
                                        TreeNode q) {

        TreeNode finding = q;
        while (finding != null) {
            if (ancestors.contains(finding)) return finding;
            finding = parents.get(finding);
        }

        throw new IllegalStateException();
    }

}

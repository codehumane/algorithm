package data.tree;

public class EfficientRecursiveLCAofBST implements LCAofBST {

    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // BST 특성 상 둘 다 오른쪽에 있음. 오른쪽 자식 노드부터 다시 살핀다.
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // BST 특성 상 둘 다 왼쪽에 있음. 왼쪽 자식 노드부터 다시 살핀다.
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // 처음으로 왼쪽 오른쪽에 값들이 나뉘어진 경우 발견. 이는 곧 LCA.
        return root;
    }
}

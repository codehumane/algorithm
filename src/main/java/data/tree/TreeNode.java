package data.tree;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@AllArgsConstructor
@ToString(of = "val")
class TreeNode {

    final int val;
    TreeNode left;
    TreeNode right;

}

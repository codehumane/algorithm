package data.tree;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@AllArgsConstructor
@ToString(of = "val")
public class TreeNode {

    public final int val;
    public TreeNode left;
    public TreeNode right;

}

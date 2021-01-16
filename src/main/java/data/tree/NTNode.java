package data.tree;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N-ary Tree Node
 */
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(of = "val")
public class NTNode {

    public final int val;
    public List<NTNode> children = new ArrayList<>();

    public void addChildren(NTNode... children) {
        this.children.addAll(Arrays.asList(children));
    }

}

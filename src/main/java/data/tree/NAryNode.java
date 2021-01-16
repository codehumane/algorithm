package data.tree;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@ToString(of = "val")
public class NAryNode {

    public final int val;
    public List<NAryNode> children = new ArrayList<>();

    public void addChildren(NAryNode... children) {
        this.children.addAll(Arrays.asList(children));
    }

}

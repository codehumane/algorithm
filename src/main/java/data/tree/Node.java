package data.tree;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Node {

    public final int val;
    public Node left;
    public Node right;
    public Node next;

}

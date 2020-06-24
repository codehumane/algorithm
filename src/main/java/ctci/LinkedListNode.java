package ctci;

import lombok.ToString;

@ToString
public class LinkedListNode {

    public LinkedListNode() {
    }

    public LinkedListNode(Integer value) {
        this.value = value;
    }

    public int value;
    public LinkedListNode next;

}

package data.tree;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@Slf4j
public class SerializeAndDeserializeBinaryTreeTest {

    private final SerializeAndDeserializeBinaryTree seder = new SerializeAndDeserializeBinaryTree();

    @Test
    public void example1() {

        // tree
        //      1
        //    /   \
        //   2     3
        //        /  \
        //       4    5
        final TreeNode node1 = new TreeNode(1);
        final TreeNode node2 = new TreeNode(2);
        final TreeNode node3 = new TreeNode(3);
        final TreeNode node4 = new TreeNode(4);
        final TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        // serialize
        final String serialized = seder.serialize(node1);
        assertEquals("[1,2,3,null,null,4,5,null,null,null,null]", serialized);

        // deserialize
        final TreeNode deserialized = seder.deserialize(serialized);
        assertEquals(node1.val, deserialized.val);
        assertEquals(node2.val, deserialized.left.val);
        assertEquals(node3.val, deserialized.right.val);
        assertEquals(node4.val, deserialized.right.left.val);
        assertEquals(node5.val, deserialized.right.right.val);
    }

    @Test
    public void example2() {

        // serialize
        final String serialized = seder.serialize(null);
        assertEquals("[]", serialized);

        // deserialize
        final TreeNode deserialized = seder.deserialize(serialized);
        assertNull(deserialized);
    }

    @Test
    public void example3() {

        // tree
        //  1
        final TreeNode node1 = new TreeNode(1);

        // serialize
        final String serialized = seder.serialize(node1);
        assertEquals("[1,null,null]", serialized);

        // deserialize
        final TreeNode deserialized = seder.deserialize(serialized);
        assertEquals(node1.val, deserialized.val);
    }

    @Test
    public void custom1() {

        // tree
        //      1
        //    /   \
        //   2     3
        //    \   /  \
        //     4 5    6
        //      /
        //     7
        // -> [1,2,3,null,4,5,6,null,null,7,null,null,null,null,null]
        final TreeNode node1 = new TreeNode(1);
        final TreeNode node2 = new TreeNode(2);
        final TreeNode node3 = new TreeNode(3);
        final TreeNode node4 = new TreeNode(4);
        final TreeNode node5 = new TreeNode(5);
        final TreeNode node6 = new TreeNode(6);
        final TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.left = node5;
        node3.right = node6;
        node5.left = node7;

        // serialize
        final String serialized = seder.serialize(node1);
        assertEquals("[1,2,3,null,4,5,6,null,null,7,null,null,null,null,null]", serialized);

        // deserialize
        final TreeNode deserialized = seder.deserialize(serialized);
        assertEquals(node1.val, deserialized.val);
        assertEquals(node2.val, deserialized.left.val);
        assertEquals(node3.val, deserialized.right.val);
        assertEquals(node4.val, deserialized.left.right.val);
        assertEquals(node5.val, deserialized.right.left.val);
        assertEquals(node6.val, deserialized.right.right.val);
        assertEquals(node7.val, deserialized.right.left.left.val);
    }

    @Test
    public void custom2() {

        // tree
        //   1
        //  /
        // 2
        final TreeNode node1 = new TreeNode(1);
        final TreeNode node2 = new TreeNode(2);
        node1.left = node2;

        // serialize
        final String serialized = seder.serialize(node1);
        assertEquals("[1,2,null,null,null]", serialized);

        // deserialize
        final TreeNode deserialized = seder.deserialize(serialized);
        assertEquals(node1.val, deserialized.val);
        assertEquals(node2.val, deserialized.left.val);
    }

    @Test
    public void custom3() {

        // tree
        //   1
        //    \
        //     2
        final TreeNode node1 = new TreeNode(1);
        final TreeNode node2 = new TreeNode(2);
        node1.right = node2;

        // serialize
        final String serialized = seder.serialize(node1);
        assertEquals("[1,null,2,null,null]", serialized);

        // deserialize
        final TreeNode deserialized = seder.deserialize(serialized);
        assertEquals(node1.val, deserialized.val);
        assertEquals(node2.val, deserialized.right.val);
    }

    @Test
    public void findLeftChildIndex() {

        // tree:
        //      1
        //    /   \
        //   2     3
        //    \   /  \
        //     4 5    6
        //      /
        //     7
        //
        // values: [1,2,3,null,4,5,6,null,null,null,null,7,null,null,null]
        assertEquals(1, seder.findLeftChildIndex(0));
        assertEquals(3, seder.findLeftChildIndex(1));
        assertEquals(5, seder.findLeftChildIndex(2));
        assertEquals(7, seder.findLeftChildIndex(3));
        assertEquals(9, seder.findLeftChildIndex(4));
        assertEquals(11, seder.findLeftChildIndex(5));
        assertEquals(13, seder.findLeftChildIndex(6));
    }
}
package data.tree;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@Slf4j
public class SerializeAndDeserializeBinaryTreeTest {

    private final SerializeAndDeserializeBinaryTree seder = new SerializeAndDeserializeBinaryTree();

    @Test
    public void serializeExample1() {

        // given
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

        // when
        final String serialized = seder.serialize(node1);

        // then
        assertEquals("[1,2,3,null,null,4,5]", serialized);
    }

    @Test
    public void serializeCustom() {

        // given
        //      1
        //    /   \
        //   2     3
        //    \   /  \
        //     4 5    6
        //      /
        //     7
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

        // when
        final String serialized = seder.serialize(node1);

        // then
        assertEquals("[1,2,3,null,4,5,6,null,null,null,null,7,null,null,null]", serialized);
    }

    @Test
    public void deserializeExample1() {

        // given
        //      1
        //    /   \
        //   2     3
        //        /  \
        //       4    5
        final String serialized = "[1,2,3,null,null,4,5]";

        // when
        final TreeNode root = seder.deserialize(serialized);

        // then
        assertEquals(1, root.val.intValue());
        assertEquals(2, root.left.val.intValue());
        assertEquals(3, root.right.val.intValue());
        assertEquals(4, root.right.left.val.intValue());
        assertEquals(5, root.right.right.val.intValue());
    }

    @Test
    public void deserializeExample2() {

        // given (nothing)
        final String serialized = "[]";

        // when
        final TreeNode root = seder.deserialize(serialized);

        // then
        assertNull(root);
    }

    @Test
    public void deserializeExample3() {

        // given (nothing)
        final String serialized = "[1]";

        // when
        final TreeNode root = seder.deserialize(serialized);

        // then
        assertEquals(1, root.val.intValue());
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    public void deserializeExample4() {

        // given (nothing)
        final String serialized = "[1,2,null]";

        // when
        final TreeNode root = seder.deserialize(serialized);

        // then
        assertEquals(1, root.val.intValue());
        assertEquals(2, root.left.val.intValue());
        assertNull(root.right);
    }

    @Test
    public void deserializeCustom1() {

        // given
        //      1
        //    /   \
        //   2     3
        //    \   /  \
        //     4 5    6
        //      /
        //     7
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

        // when
        final TreeNode deserialized = seder.deserialize("[1,2,3,null,4,5,6,null,null,null,null,7,null,null,null]");

        // then
        assertEquals(node1.val, deserialized.val);
        assertEquals(node2.val, deserialized.left.val);
        assertEquals(node3.val, deserialized.right.val);
        assertEquals(node4.val, deserialized.left.right.val);
        assertEquals(node5.val, deserialized.right.left.val);
        assertEquals(node6.val, deserialized.right.right.val);
        assertEquals(node7.val, deserialized.right.left.left.val);
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
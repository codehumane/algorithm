package data.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BSTIteratorTest {

    @Test
    public void example1() {

        // given
        //    7
        //  /   \
        // 3     15
        //      /   \
        //     9    20
        final TreeNode node7 = new TreeNode(7);
        final TreeNode node3 = new TreeNode(3);
        final TreeNode node15 = new TreeNode(15);
        final TreeNode node9 = new TreeNode(9);
        final TreeNode node20 = new TreeNode(20);
        node7.left = node3;
        node7.right = node15;
        node15.left = node9;
        node15.right = node20;

        // when
        final BSTIterator iterator = new BSTIterator(node7);

        // then
        assertEquals(3, iterator.next());
        assertEquals(7, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(9, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(15, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(20, iterator.next());
        assertFalse(iterator.hasNext());
    }

}
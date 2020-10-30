package data.tree;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchInABinarySearchTreeTest {

    private final SearchInABinarySearchTree tree = new SearchInABinarySearchTree();

    @Test
    public void example1() {

        // given
        //     4
        //    / \
        //   2   7
        //  / \
        // 1   3
        val node4 = new TreeNode(4);
        val node2 = new TreeNode(2);
        val node7 = new TreeNode(7);
        val node1 = new TreeNode(1);
        val node3 = new TreeNode(3);
        node4.left = node2;
        node4.right = node7;
        node2.left = node1;
        node2.right = node3;

        // when
        val searched = tree.searchBST(node4, 2);

        // then
        assertEquals(node2, searched);
    }

    @Test
    public void example2() {

        // given
        //     4
        //    / \
        //   2   7
        //  / \
        // 1   3
        val node4 = new TreeNode(4);
        val node2 = new TreeNode(2);
        val node7 = new TreeNode(7);
        val node1 = new TreeNode(1);
        val node3 = new TreeNode(3);
        node4.left = node2;
        node4.right = node7;
        node2.left = node1;
        node2.right = node3;

        // when
        val searched = tree.searchBST(node4, 5);

        // then
        assertNull(searched);
    }

}
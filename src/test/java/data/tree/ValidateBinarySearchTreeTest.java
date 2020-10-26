package data.tree;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidateBinarySearchTreeTest {

    private final ValidateBinarySearchTree validator = new ValidateBinarySearchTree();

    @Test
    public void validateExample1() {

        // given
        //   2
        //  / \
        // 1   3
        val node2 = new TreeNode(2);
        val node1 = new TreeNode(1);
        val node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;

        // when & then
        assertTrue(validator.isValidBST(node2));
    }

    @Test
    public void validateExample2() {

        // given
        //   5
        //  / \
        // 1   4
        //    / \
        //   3   6
        val node5 = new TreeNode(5);
        val node1 = new TreeNode(1);
        val node4 = new TreeNode(4);
        val node3 = new TreeNode(3);
        val node6 = new TreeNode(6);
        node5.left = node1;
        node5.right = node4;
        node4.left = node3;
        node4.right = node6;

        // when & then
        assertFalse(validator.isValidBST(node5));
    }

    @Test
    public void validateCustom1() {

        // less than or equal to가 아닌 less than 을 지키는지 확인
        val root = new TreeNode(1);
        root.left = new TreeNode(1);

        // when & then
        assertFalse(validator.isValidBST(root));
    }

    @Test
    public void validateCustom2() {

        // greater than or equal to가 아닌 greater than 을 지키는지 확인
        val root = new TreeNode(1);
        root.right = new TreeNode(1);

        // when & then
        assertFalse(validator.isValidBST(root));
    }

}
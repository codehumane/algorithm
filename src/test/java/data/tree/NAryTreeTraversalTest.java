package data.tree;

import lombok.val;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NAryTreeTraversalTest {

    private static final NAryTreeTraversal traversal = new NAryTreeTraversal();
    private static final NTNode example1Root;
    private static final NTNode example2Root;

    static {
        val n1 = new NTNode(1);
        val n3 = new NTNode(3);
        val n2 = new NTNode(2);
        val n4 = new NTNode(4);
        val n5 = new NTNode(5);
        val n6 = new NTNode(6);
        n1.addChildren(n3, n2, n4);
        n3.addChildren(n5, n6);
        example1Root = n1;
    }

    static {
        val n1 = new NTNode(1);
        val n2 = new NTNode(2);
        val n3 = new NTNode(3);
        val n4 = new NTNode(4);
        val n5 = new NTNode(5);
        val n6 = new NTNode(6);
        val n7 = new NTNode(7);
        val n8 = new NTNode(8);
        val n9 = new NTNode(9);
        val n10 = new NTNode(10);
        val n11 = new NTNode(11);
        val n12 = new NTNode(12);
        val n13 = new NTNode(13);
        val n14 = new NTNode(14);
        n1.addChildren(n2, n3, n4, n5);
        n3.addChildren(n6, n7);
        n7.addChildren(n11);
        n11.addChildren(n14);
        n4.addChildren(n8);
        n8.addChildren(n12);
        n5.addChildren(n9, n10);
        n9.addChildren(n13);
        example2Root = n1;
    }

    @Test
    public void preorderExample1() {
        val expected = asList(1, 3, 5, 6, 2, 4);
        val result = traversal.preorder(example1Root);
        assertEquals(expected, result);
    }

    @Test
    public void preorderExample2() {
        val expected = asList(1, 2, 3, 6, 7, 11, 14, 4, 8, 12, 5, 9, 13, 10);
        val result = traversal.preorder(example2Root);
        assertEquals(expected, result);
    }

    @Test
    public void preorderFailed1() {
        assertTrue(traversal.preorder(null).isEmpty());
    }

    @Test
    public void postorderExample1() {
        val expected = asList(5, 6, 3, 2, 4, 1);
        val result = traversal.postorder(example1Root);
        assertEquals(expected, result);
    }

    @Test
    public void postorderExample2() {
        val expected = asList(2, 6, 14, 11, 7, 3, 12, 8, 4, 13, 9, 10, 5, 1);
        val result = traversal.postorder(example2Root);
        assertEquals(expected, result);
    }

    @Test
    public void levelOrderExample1() {
        val expected = asList(
                singletonList(1),
                asList(3, 2, 4),
                asList(5, 6)
        );

        val result = traversal.levelOrder(example1Root);
        assertEquals(expected, result);
    }

    @Test
    public void levelOrderExample2() {
        val expected = asList(
                singletonList(1),
                asList(2, 3, 4, 5),
                asList(6, 7, 8, 9, 10),
                asList(11, 12, 13),
                singletonList(14)
        );

        val result = traversal.levelOrder(example2Root);
        assertEquals(expected, result);
    }

}
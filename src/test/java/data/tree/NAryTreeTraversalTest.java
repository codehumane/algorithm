package data.tree;

import lombok.val;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NAryTreeTraversalTest {

    private static final NAryTreeTraversal traversal = new NAryTreeTraversal();
    private static final NAryNode example1Root;
    private static final NAryNode example2Root;

    static {
        val n1 = new NAryNode(1);
        val n3 = new NAryNode(3);
        val n2 = new NAryNode(2);
        val n4 = new NAryNode(4);
        val n5 = new NAryNode(5);
        val n6 = new NAryNode(6);
        n1.addChildren(n3, n2, n4);
        n3.addChildren(n5, n6);
        example1Root = n1;
    }

    static {
        val n1 = new NAryNode(1);
        val n2 = new NAryNode(2);
        val n3 = new NAryNode(3);
        val n4 = new NAryNode(4);
        val n5 = new NAryNode(5);
        val n6 = new NAryNode(6);
        val n7 = new NAryNode(7);
        val n8 = new NAryNode(8);
        val n9 = new NAryNode(9);
        val n10 = new NAryNode(10);
        val n11 = new NAryNode(11);
        val n12 = new NAryNode(12);
        val n13 = new NAryNode(13);
        val n14 = new NAryNode(14);
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
        val expected = Arrays.asList(1, 3, 5, 6, 2, 4);
        val traversed = traversal.preorder(example1Root);
        assertEquals(expected, traversed);
    }

    @Test
    public void preorderExample2() {
        val expected = Arrays.asList(1, 2, 3, 6, 7, 11, 14, 4, 8, 12, 5, 9, 13, 10);
        val traversed = traversal.preorder(example2Root);
        assertEquals(expected, traversed);
    }

    @Test
    public void preorderFailed1() {
        assertTrue(traversal.preorder(null).isEmpty());
    }

}
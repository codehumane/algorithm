package data.tree;

import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class LowestCommonAncestorOfABinaryTreeTest<T extends LowestCommonAncestorOfABinaryTree> {

    private T lca;
    private Class<T> lcaClass;

    public LowestCommonAncestorOfABinaryTreeTest(Class<T> lcaClass) {
        this.lcaClass = lcaClass;
    }

    @Parameterized.Parameters
    public static List<Class> fanMeetingClasses() {
        List<Class> classes = new ArrayList<>();
        classes.add(SlowLowestCommonAncestorOfABinaryTree.class);
        classes.add(RecursiveLowestCommonAncestorOfABinaryTree.class);
        return classes;
    }

    @Before
    public void setup() throws IllegalAccessException, InstantiationException {
        this.lca = lcaClass.newInstance();
    }

    @Test
    public void lowestCommonAncestorExample1() {

        // given: 5, 1
        //        3
        //      /    \
        //     5      1
        //   / \     / \
        //  6   2   0   8
        //     / \
        //    7   4
        val node3 = new TreeNode(3);
        val node5 = new TreeNode(5);
        val node6 = new TreeNode(6);
        val node2 = new TreeNode(2);
        val node7 = new TreeNode(7);
        val node4 = new TreeNode(4);
        val node1 = new TreeNode(1);
        val node0 = new TreeNode(0);
        val node8 = new TreeNode(8);
        node3.left = node5;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node3.right = node1;
        node1.left = node0;
        node1.right = node8;

        // when
        final TreeNode ancestor = lca.lowestCommonAncestor(node3, node5, node1);

        // then
        assertEquals(node3, ancestor);
    }

    @Test
    public void lowestCommonAncestorExample2() {

        // given:
        //        3
        //      /    \
        //     5      1
        //   / \     / \
        //  6   2   0   8
        //     / \
        //    7   4
        val node3 = new TreeNode(3);
        val node5 = new TreeNode(5);
        val node6 = new TreeNode(6);
        val node2 = new TreeNode(2);
        val node7 = new TreeNode(7);
        val node4 = new TreeNode(4);
        val node1 = new TreeNode(1);
        val node0 = new TreeNode(0);
        val node8 = new TreeNode(8);
        node3.left = node5;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node3.right = node1;
        node1.left = node0;
        node1.right = node8;

        // when
        final TreeNode ancestor = lca.lowestCommonAncestor(node3, node5, node4);

        // then
        assertEquals(node5, ancestor);
    }

}
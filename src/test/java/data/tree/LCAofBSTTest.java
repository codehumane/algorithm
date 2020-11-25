package data.tree;

import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(value = Parameterized.class)
public class LCAofBSTTest<T extends LCAofBST> {

    private T lcaOfBST;
    private Class<T> lcaOfBSTClass;

    public LCAofBSTTest(Class<T> lcaOfBSTClass) {
        this.lcaOfBSTClass = lcaOfBSTClass;
    }

    @Parameterized.Parameters
    public static List<Class> classes() {
        final List<Class> classes = new ArrayList<>();
        classes.add(InefficientRecursiveLCAofBST.class);
        return classes;
    }

    @Before
    public void setup() throws IllegalAccessException, InstantiationException {
        this.lcaOfBST = lcaOfBSTClass.newInstance();
    }

    @Test
    public void example1() {

        // given
        //             6
        //          /     \
        //         2       8
        //       /  \     /  \
        //      0    4   7    9
        //          / \
        //         3   5
        val n6 = new TreeNode(6);
        val n2 = new TreeNode(2);
        val n8 = new TreeNode(8);
        val n0 = new TreeNode(0);
        val n4 = new TreeNode(4);
        val n7 = new TreeNode(7);
        val n9 = new TreeNode(9);
        val n3 = new TreeNode(3);
        val n5 = new TreeNode(5);
        n6.left = n2;
        n6.right = n8;
        n2.left = n0;
        n2.right = n4;
        n8.left = n7;
        n8.right = n9;
        n4.left = n3;
        n4.right = n5;

        // when
        val lca = lcaOfBST.lowestCommonAncestor(n6, n2, n8);

        // then
        assertNotNull(lca);
        assertEquals(n6, lca);
    }

    @Test
    public void example2() {

        // given
        //             6
        //          /     \
        //         2       8
        //       /  \     /  \
        //      0    4   7    9
        //          / \
        //         3   5
        val n6 = new TreeNode(6);
        val n2 = new TreeNode(2);
        val n8 = new TreeNode(8);
        val n0 = new TreeNode(0);
        val n4 = new TreeNode(4);
        val n7 = new TreeNode(7);
        val n9 = new TreeNode(9);
        val n3 = new TreeNode(3);
        val n5 = new TreeNode(5);
        n6.left = n2;
        n6.right = n8;
        n2.left = n0;
        n2.right = n4;
        n8.left = n7;
        n8.right = n9;
        n4.left = n3;
        n4.right = n5;

        // when
        val lca = lcaOfBST.lowestCommonAncestor(n6, n2, n4);

        // then
        assertNotNull(lca);
        assertEquals(n2, lca);
    }

    @Test
    public void example3() {

        // given
        val n2 = new TreeNode(2);
        val n1 = new TreeNode(1);
        n2.left = n1;

        // when
        val lca = lcaOfBST.lowestCommonAncestor(n2, n2, n1);

        // then
        assertNotNull(lca);
        assertEquals(n2, lca);
    }

}
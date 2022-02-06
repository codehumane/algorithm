package quiz.tree;

import data.tree.TreeNode;
import lombok.val;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LCAofBSTTest {

    @ParameterizedTest
    @MethodSource("getLCAOfBST")
    public void example1(LCAofBST lcaOfBST) {

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

    @ParameterizedTest
    @MethodSource("getLCAOfBST")
    public void example2(LCAofBST lcaOfBST) {

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

    @ParameterizedTest
    @MethodSource("getLCAOfBST")
    public void example3(LCAofBST lcaOfBST) {

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

    private static Stream<Arguments> getLCAOfBST() {
        return Stream.of(
                Arguments.of(new InefficientRecursiveLCAofBST()),
                Arguments.of(new EfficientRecursiveLCAofBST()),
                Arguments.of(new IterativeLCAofBST())
        );
    }

}
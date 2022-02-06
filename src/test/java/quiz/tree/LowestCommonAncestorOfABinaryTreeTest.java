package quiz.tree;

import data.tree.TreeNode;
import lombok.val;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LowestCommonAncestorOfABinaryTreeTest {

    public static Stream<Arguments> lcas() {
        return Stream.of(
                Arguments.of(new SlowLowestCommonAncestorOfABinaryTree()),
                Arguments.of(new RecursiveLowestCommonAncestorOfABinaryTree()),
                Arguments.of(new ParentPointersLowestCommonAncestorOfABinaryTree()),
                Arguments.of(new ProbableStackLowestCommonAncestorOfABinaryTree())
        );
    }

    @ParameterizedTest
    @MethodSource("lcas")
    public void lowestCommonAncestorExample1(LowestCommonAncestorOfABinaryTree lca) {

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

    @ParameterizedTest
    @MethodSource("lcas")
    public void lowestCommonAncestorExample2(LowestCommonAncestorOfABinaryTree lca) {

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
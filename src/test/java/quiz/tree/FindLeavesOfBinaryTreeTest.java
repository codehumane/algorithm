package quiz.tree;

import org.junit.jupiter.api.Test;
import quiz.tree.FindLeavesOfBinaryTree.TreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FindLeavesOfBinaryTreeTest {

    private final FindLeavesOfBinaryTree solution = new FindLeavesOfBinaryTree();

    @Test
    void example() {

        // when
        var n1 = new TreeNode(1);
        var n2 = new TreeNode(2);
        var n3 = new TreeNode(3);
        var n4 = new TreeNode(4);
        var n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        // and
        var expected = List.of(
                Set.of(4, 5, 3),
                Set.of(2),
                Set.of(1)
        );

        // when
        var result = solution
                .findLeaves(n1)
                .stream()
                .map(HashSet::new)
                .collect(toList());

        // then
        assertEquals(expected, result);
    }

    @Test
    void custom1() {
        var n1 = new TreeNode(1);
        var expected = List.of(List.of(1));
        var result = solution.findLeaves(n1);
        assertEquals(expected, result);
    }

    @Test
    void custom2() {

        // given
        var n1 = new TreeNode(1);
        var n2 = new TreeNode(2);
        n1.right = n2;

        // and
        var expected = List.of(
                Set.of(2),
                Set.of(1)
        );

        // when
        var result = solution
                .findLeaves(n1)
                .stream()
                .map(HashSet::new)
                .collect(toList());

        // then
        assertEquals(expected, result);
    }

    @Test
    void custom3() {

        // when
        var n1 = new TreeNode(1);
        var n2 = new TreeNode(2);
        var n3 = new TreeNode(3);
        var n4 = new TreeNode(4);
        var n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.right = n5;

        // and
        var expected = List.of(
                Set.of(4, 5),
                Set.of(2, 3),
                Set.of(1)
        );

        // when
        var result = solution
                .findLeaves(n1)
                .stream()
                .map(HashSet::new)
                .collect(toList());

        // then
        assertEquals(expected, result);
    }

}
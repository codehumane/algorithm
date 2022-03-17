package quiz.graph;

import org.junit.jupiter.api.Test;
import quiz.graph.FindDuplicateSubtrees.TreeNode;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FindDuplicateSubtreesTest {

    private final FindDuplicateSubtrees solution = new FindDuplicateSubtrees();

    @Test
    void example1() {

        // given
        var n1 = new TreeNode(1);
        var n2 = new TreeNode(2);
        var n4 = new TreeNode(4);
        var n3 = new TreeNode(3);
        var n2a = new TreeNode(2);
        var n4a = new TreeNode(4);
        var n4b = new TreeNode(4);

        // and
        n1.left = n2;
        n2.left = n4;
        n1.right = n3;
        n3.left = n2a;
        n2a.left = n4a;
        n3.right = n4b;

        // when
        var result = solution.findDuplicateSubtrees(n1);

        // then
        verify(result, Set.of(2, 4));
    }

    @Test
    void example2() {

        // given
        var n2 = new TreeNode(2);
        var n1l = new TreeNode(1);
        var n1r = new TreeNode(1);
        n2.left = n1l;
        n2.right = n1r;

        // when
        var result = solution.findDuplicateSubtrees(n2);

        // then
        verify(result, Set.of(1));
    }

    @Test
    void example3() {

        // given
        var root = new TreeNode(2);
        var n2l = new TreeNode(2);
        var n2r = new TreeNode(2);
        var n3a = new TreeNode(3);
        var n3b = new TreeNode(3);
        root.left = n2l;
        root.right = n2r;
        n2l.left = n3a;
        n2r.left = n3b;

        // when
        var result = solution.findDuplicateSubtrees(root);

        // then
        verify(result, Set.of(2, 3));
    }

    private void verify(List<TreeNode> result, Set<Integer> expected) {

        var values = result
                .stream()
                .map(x -> x.val)
                .collect(Collectors.toSet());

        assertEquals(expected.size(), values.size());

        for (var e : expected) {
            assertTrue(values.contains(e));
        }
    }


}
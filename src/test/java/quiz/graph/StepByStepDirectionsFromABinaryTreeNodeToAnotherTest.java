package quiz.graph;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import quiz.graph.StepByStepDirectionsFromABinaryTreeNodeToAnother.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StepByStepDirectionsFromABinaryTreeNodeToAnotherTest {

    private final StepByStepDirectionsFromABinaryTreeNodeToAnother solution =
            new StepByStepDirectionsFromABinaryTreeNodeToAnother();

    @Test
    void example1() {

        // given
        var n1 = new TreeNode(1);
        var n2 = new TreeNode(2);
        var n3 = new TreeNode(3);
        var n4 = new TreeNode(4);
        var n5 = new TreeNode(5);
        var n6 = new TreeNode(6);

        // and
        n5.left = n1;
        n5.right = n2;
        n1.left = n3;
        n2.left = n6;
        n2.right = n4;

        // when
        var result = solution.getDirections(n5, 3, 6);

        // then
        assertEquals("UURL", result);
    }

    @Test
    void example2() {

        // given
        var n1 = new TreeNode(1);
        var n2 = new TreeNode(2);
        n2.left = n1;

        // when
        var result = solution.getDirections(n2, 2, 1);

        // then
        assertEquals("L", result);
    }

    @ParameterizedTest
    @CsvSource({
            "4,2,U",
            "2,4,L",
            "4,5,UR",
            "4,3,UUR",
            "3,4,ULL",
            "3,5,ULR"
    })
    void custom(int startValue, int destValue, String expected) {
        var result = solution.getDirections(preparedCustomTree(), startValue, destValue);
        assertEquals(expected, result);
    }

    private TreeNode preparedCustomTree() {
        var n1 = new TreeNode(1);
        var n2 = new TreeNode(2);
        var n3 = new TreeNode(3);
        var n4 = new TreeNode(4);
        var n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        return n1;
    }

}
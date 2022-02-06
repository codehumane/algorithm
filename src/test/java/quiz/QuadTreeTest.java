package quiz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuadTreeTest {

    private QuadTree quadTree = new QuadTree();

    @Test
    public void reverseVertically_한_가지_색으로_이루어진_경우_결과는_입력값과_동일하다() throws Exception {
        // Given

        // 흰
        String input = "w";

        // When
        String reversed = quadTree.reverseVertically(input);

        // Then
        Assertions.assertEquals(input, reversed);
    }

    @Test
    public void reverseVertically_깊이가_2인_경우() throws Exception {
        // Given

        // bw
        // wb
        String input = "xbwwb";

        // wb
        // bw
        String expected = "xwbbw";

        // When
        String reversed = quadTree.reverseVertically(input);

        // Then
        Assertions.assertEquals(expected, reversed);
    }

    @Test
    public void reverseVertically_깊이가_3인_경우() throws Exception {
        // Given

        // x[bwx[wbbw]b]
        String input = "xbwxwbbwb";

        // x[x[bwwb]bbw]
        String expected = "xxbwwbbbw";

        // When
        String reversed = quadTree.reverseVertically(input);

        // Then
        Assertions.assertEquals(expected, reversed);
    }

    @Test
    public void reverseVertically_깊이가_4_이상인_경우() throws Exception {
        // Given

        // bw
        // wb
        String input = "xxwwwbxwxwbbbwwxxxwwbbbwwwwbb";

        // wb
        // bw
        String expected = "xxwbxwwxbbwwbwbxwbwwxwwwxbbwb";

        // When
        String reversed = quadTree.reverseVertically(input);

        // Then
        Assertions.assertEquals(expected, reversed);
    }
}
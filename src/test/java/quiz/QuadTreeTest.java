package quiz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuadTreeTest {

    private QuadTree quadTree;

    @Before
    public void setUp() throws Exception {
        quadTree = new QuadTree();
    }

    @Test
    public void reverseVertically_한_가지_색으로_이루어진_경우_결과는_입력값과_동일하다() throws Exception {
        // Given

        // 흰
        String input = "w";

        // When
        String reversed = quadTree.reverseVertically(input);

        // Then
        Assert.assertEquals(input, reversed);
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
        Assert.assertEquals(expected, reversed);
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
        Assert.assertEquals(expected, reversed);
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
        Assert.assertEquals(expected, reversed);
    }
}
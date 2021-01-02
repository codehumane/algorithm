package quiz.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindTheDuplicateNumberTest {

    private final FindTheDuplicateNumber finder = new FindTheDuplicateNumber();

    @Test
    public void example1() {
        assertEquals(2, finder.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    @Test
    public void example2() {
        assertEquals(3, finder.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    @Test
    public void example3() {
        assertEquals(1, finder.findDuplicate(new int[]{1, 1}));
    }

    @Test
    public void example4() {
        assertEquals(1, finder.findDuplicate(new int[]{1, 1, 2}));
    }
}
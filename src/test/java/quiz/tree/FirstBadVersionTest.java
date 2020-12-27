package quiz.tree;

import org.junit.Test;
import quiz.tree.FirstBadVersion;

import static org.junit.Assert.*;

public class FirstBadVersionTest {

    @Test
    public void example1() {

        // given
        final int n = 5;
        final int bad = 4;

        // when
        final int result = new FirstBadVersion(bad).firstBadVersion(n);

        // then
        assertEquals(bad, result);
    }

    @Test
    public void example2() {

        // given
        final int n = 1;
        final int bad = 1;

        // when
        final int result = new FirstBadVersion(bad).firstBadVersion(n);

        // then
        assertEquals(bad, result);
    }

}
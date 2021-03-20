package quiz.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class ReverseStringTest {

    private final ReverseString solution = new ReverseString();

    @Test
    public void example1() {
        final char[] expected = {'o', 'l', 'l', 'e', 'h'};
        final char[] input = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(input);
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void example2() {
        final char[] expected = {'H', 'a', 'n', 'n', 'a', 'h'};
        final char[] input = {'h', 'a', 'n', 'n', 'a', 'H'};
        solution.reverseString(input);
        Assert.assertArrayEquals(expected, input);
    }
}
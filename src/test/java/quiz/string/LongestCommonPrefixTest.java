package quiz.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonPrefixTest {

    private final LongestCommonPrefix prefix = new LongestCommonPrefix();

    @Test
    public void example1() {
        assertEquals("fl", prefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    @Test
    public void example2() {
        assertEquals("", prefix.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    @Test
    public void custom() {
        assertEquals("", prefix.longestCommonPrefix(new String[]{}));
        assertEquals("hello", prefix.longestCommonPrefix(new String[]{"hello"}));
        assertEquals("hello", prefix.longestCommonPrefix(new String[]{"hello", "hello"}));
        assertEquals("hello", prefix.longestCommonPrefix(new String[]{"hello", "hello1"}));
        assertEquals("hello", prefix.longestCommonPrefix(new String[]{"hello1", "hello"}));
    }

}
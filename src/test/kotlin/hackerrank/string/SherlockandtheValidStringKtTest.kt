package hackerrank.string

import org.junit.Assert.assertEquals
import org.junit.Test

class SherlockandtheValidStringKtTest {

    @Test
    fun isValid() {
        assertEquals("YES", isValid("a"))
        assertEquals("YES", isValid("abc"))
        assertEquals("YES", isValid("abcc"))
        assertEquals("YES", isValid("aabbcc"))
        assertEquals("YES", isValid("aabbccc"))
        assertEquals("YES", isValid("aabbbcc"))
        assertEquals("YES", isValid("aaabbcc"))
        assertEquals("YES", isValid("cababc"))
        assertEquals("YES", isValid("abcdefghhgfedecba"))
        assertEquals("YES", isValid("aabbc"))
        assertEquals("YES", isValid("aabcc"))
        assertEquals("NO", isValid("abccc"))
        assertEquals("NO", isValid("aabbcd"))
        assertEquals("NO", isValid("aabbccddeefghi"))
    }
}
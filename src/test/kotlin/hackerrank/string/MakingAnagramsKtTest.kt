package hackerrank.string

import org.junit.Assert.assertEquals
import org.junit.Test

class MakingAnagramsKtTest {

    @Test
    fun makeAnagram() {
        assertEquals(0, makeAnagram("a", "a"))
        assertEquals(1, makeAnagram("a", "ab"))
        assertEquals(1, makeAnagram("ab", "a"))
        assertEquals(1, makeAnagram("aa", "a"))
        assertEquals(1, makeAnagram("a", "aa"))
        assertEquals(0, makeAnagram("aa", "aa"))
        assertEquals(2, makeAnagram("cde", "dcf"))
        assertEquals(4, makeAnagram("cde", "abc"))
    }
}

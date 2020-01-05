package hackerrank.string

import org.junit.Assert.assertEquals
import org.junit.Test

class SpecialStringAgainKtTest {

    @Test
    fun `substrCount 모든 글자가 같은 경우를 고려해야 한다`() {
        assertEquals(1, substrCount(1, "a"))
        assertEquals(2, substrCount(2, "ab"))
        assertEquals(2 + 1, substrCount(2, "aa"))
        assertEquals(3 + 1, substrCount(3, "aab"))
        assertEquals(3 + 3, substrCount(3, "aaa")) // (n - 1) + ... 1
    }

    @Test
    fun `substrCount 가운데 글자를 제외한 모든 글자가 같은 경우도 고려해야 한다`() {
        assertEquals(3 + 1, substrCount(3, "aba"))
        assertEquals(4 + 1 + 1, substrCount(4, "abab"))
        assertEquals(5 + 3 + 1, substrCount(5, "aaaba"))
        assertEquals(6 + 3 + 1 + 2, substrCount(6, "aaabaa"))
        assertEquals(7 + 3 + 3 + 3, substrCount(7, "aaabaaa"))
    }

    @Test
    fun substrCount() {
        assertEquals(1, substrCount(1, "a"))
        assertEquals(2, substrCount(2, "ab"))
        assertEquals(3, substrCount(2, "aa"))
        assertEquals(4, substrCount(3, "aba"))
        assertEquals(4, substrCount(3, "aab"))
        assertEquals(4, substrCount(3, "abb"))
        assertEquals(6, substrCount(3, "aaa"))
        assertEquals(7, substrCount(5, "asasd"))
        assertEquals(10, substrCount(7, "abcbaba"))
        assertEquals(10, substrCount(4, "aaaa"))
    }

}

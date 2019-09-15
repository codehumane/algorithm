package hackerrank.dictionaryandhashmap

import hackerrank.dictionaryandhashmap.twoStrings
import org.junit.Assert.*
import org.junit.Test

class TwoStringsKtTest {

    @Test
    fun `twoStrings case1`() {
        val result = twoStrings("hello", "world")
        assertEquals("YES", result)
    }

    @Test
    fun `twoStrings case2`() {
        val result = twoStrings("hi", "world")
        assertEquals("NO", result)
    }
}
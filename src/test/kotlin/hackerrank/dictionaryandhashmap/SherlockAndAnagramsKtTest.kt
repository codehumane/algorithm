package hackerrank.dictionaryandhashmap

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SherlockAndAnagramsKtTest {

    @Test
    fun sherlockAndAnagrams() {
        assertEquals(2, sherlockAndAnagrams("mom"))
        assertEquals(4, sherlockAndAnagrams("abba"))
        assertEquals(0, sherlockAndAnagrams("abcd"))
        assertEquals(3, sherlockAndAnagrams("ifailuhkqq"))
        assertEquals(10, sherlockAndAnagrams("kkkk"))
    }

}
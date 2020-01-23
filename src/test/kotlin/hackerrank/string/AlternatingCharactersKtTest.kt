package hackerrank.string

import org.junit.Assert.*
import org.junit.Test

class AlternatingCharactersKtTest {

    @Test
    fun alternatingCharacters() {
        assertEquals(3, alternatingCharacters("AAAA"))
        assertEquals(4, alternatingCharacters("BBBBB"))
        assertEquals(0, alternatingCharacters("ABABABAB"))
        assertEquals(0, alternatingCharacters("BABABA"))
        assertEquals(4, alternatingCharacters("AAABBB"))
    }
}
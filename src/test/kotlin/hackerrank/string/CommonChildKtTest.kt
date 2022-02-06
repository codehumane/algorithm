package hackerrank.string

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CommonChildKtTest {

    @Test
    fun commonChild() {
        assertEquals(0, commonChild("AA", "BB"))
        assertEquals(2, commonChild("HARRY", "SALLY"))
        assertEquals(3, commonChild("SHINCHAN", "NOHARAAA"))
        assertEquals(2, commonChild("ABCDEF", "FBDAMN"))
    }

}

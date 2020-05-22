package hackerrank.search

import org.junit.Assert.assertEquals
import org.junit.Test

class MakingCandiesKtTest {

    @Test
    fun minimumPasses() {
        assertEquals(4, minimumPasses(1, 2, 1, 60))
        assertEquals(3, minimumPasses(3, 1, 2, 12))
        assertEquals(16, minimumPasses(1, 1, 6, 45))
        assertEquals(3, minimumPasses(5, 1, 10, 15))
        assertEquals(1, minimumPasses(5184889632, 5184889632, 20, 10000))
        assertEquals(3577, minimumPasses(5361, 3918, 8447708, 989936375520))
        assertEquals(1, minimumPasses(4294967297, 4294967297, 1000000000000, 1000000000000))
    }

}
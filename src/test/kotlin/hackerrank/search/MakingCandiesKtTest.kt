package hackerrank.search

import org.junit.Assert.assertEquals
import org.junit.Test

class MakingCandiesKtTest {

    @Test
    fun minimumPasses() {
        assertEquals(4, minimumPasses(1, 2, 1, 60))
        assertEquals(3, minimumPasses(3, 1, 2, 12))
        assertEquals(16, minimumPasses(1, 1, 6, 45))
        assertEquals(1, minimumPasses(5184889632, 5184889632, 20, 10000))
    }
}
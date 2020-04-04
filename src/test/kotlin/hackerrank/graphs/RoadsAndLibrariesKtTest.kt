package hackerrank.graphs

import org.junit.Assert.assertEquals
import org.junit.Test

class RoadsAndLibrariesKtTest {

    @Test
    fun `roadsAndLibraries hackerrank 첫 번째 문제`() {
        val cost = roadsAndLibraries(
            3,
            2,
            1,
            arrayOf(
                arrayOf(1, 2),
                arrayOf(3, 1),
                arrayOf(2, 3)
            )
        )

        assertEquals(4, cost)
    }

//    @Test
    fun `roadsAndLibraries hackerrank 두 번째 문제`() {
        val cost = roadsAndLibraries(
            6,
            2,
            5,
            arrayOf(
                arrayOf(1, 3),
                arrayOf(3, 4),
                arrayOf(2, 4),
                arrayOf(1, 2),
                arrayOf(2, 3),
                arrayOf(5, 6)
            )
        )

        assertEquals(12, cost)
    }
}
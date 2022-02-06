package hackerrank.graphs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RoadsAndLibrariesKtTest {

    @Test
    fun `roadsAndLibraries hackerrank case 1`() {
        val cost = RoadsAndLibraries.roadsAndLibraries(
            3,
            2,
            1,
            arrayOf(
                arrayOf(1, 2).toIntArray(),
                arrayOf(3, 1).toIntArray(),
                arrayOf(2, 3).toIntArray()
            )
        )

        assertEquals(4, cost)
    }

    @Test
    fun `roadsAndLibraries hackerrank case 2`() {
        val cost = RoadsAndLibraries.roadsAndLibraries(
            6,
            2,
            5,
            arrayOf(
                arrayOf(1, 3).toIntArray(),
                arrayOf(3, 4).toIntArray(),
                arrayOf(2, 4).toIntArray(),
                arrayOf(1, 2).toIntArray(),
                arrayOf(2, 3).toIntArray(),
                arrayOf(5, 6).toIntArray()
            )
        )

        assertEquals(12, cost)
    }

    @Test
    fun `roadsAndLibraries hackerrank case 3`() {
        val cost = RoadsAndLibraries.roadsAndLibraries(
            5,
            3,
            6,
            arrayOf(
                arrayOf(1, 2).toIntArray(),
                arrayOf(1, 3).toIntArray(),
                arrayOf(1, 4).toIntArray()
            )
        )

        assertEquals(15, cost)
    }
}
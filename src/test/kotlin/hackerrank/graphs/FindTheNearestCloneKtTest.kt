package hackerrank.graphs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheNearestCloneKtTest {

    @Test
    fun `findShortest sample 1`() {
        assertEquals(
            1,
            FindTheNearestClone.findShortest(
                4,
                intArrayOf(1, 1, 4),
                intArrayOf(2, 3, 2),
                longArrayOf(1, 2, 1, 1),
                1
            )
        )
    }

    @Test
    fun `findShortest sample 2`() {
        assertEquals(
            -1,
            FindTheNearestClone.findShortest(
                4,
                intArrayOf(1, 1, 4),
                intArrayOf(2, 3, 2),
                longArrayOf(1, 2, 3, 4),
                2
            )
        )
    }

    @Test
    fun `findShortest sample 3`() {
        assertEquals(
            3,
            FindTheNearestClone.findShortest(
                4,
                intArrayOf(1, 1, 2, 3),
                intArrayOf(2, 3, 4, 5),
                longArrayOf(1, 2, 3, 3, 2),
                2
            )
        )
    }

}
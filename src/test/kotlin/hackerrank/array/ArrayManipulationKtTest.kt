package hackerrank.array

import hackerrank.array.arrayManipulation
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ArrayManipulationKtTest {

    @Test
    fun `arrayManipulation case1`() {

        val n = 10
        val expected = 10L
        val queries = arrayOf(
            arrayOf(1, 5, 3),
            arrayOf(4, 8, 7),
            arrayOf(6, 9, 1)
        )

        val result = arrayManipulation(n, queries)
        assertEquals(expected, result)
    }

    @Test
    fun `arrayManipulation case2`() {

        val n = 5
        val expected = 200L
        val queries = arrayOf(
            arrayOf(1, 2, 100),
            arrayOf(2, 5, 100),
            arrayOf(3, 4, 100)
        )

        val result = arrayManipulation(n, queries)
        assertEquals(expected, result)
    }

}

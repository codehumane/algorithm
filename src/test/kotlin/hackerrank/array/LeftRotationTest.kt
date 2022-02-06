package hackerrank.array

import hackerrank.array.LeftRotation
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class LeftRotationTest {

    private val solution = LeftRotation()

    @Test
    fun `rotLeft case1`() {
        val input = arrayOf(1, 2, 3, 4, 5)
        val expected = arrayOf(5, 1, 2, 3, 4)
        val result = solution.rotLeft(input, 4)
        assertArrayEquals(expected, result)
    }

    @Test
    fun `rotLeft case2`() {
        val input = arrayOf(77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77)
        val expected = arrayOf(41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51)
        val result = solution.rotLeft(input, 10)
        assertArrayEquals(expected, result)
    }

    @Test
    fun `rotLeft case3`() {
        val input = arrayOf(33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97)
        val expected = arrayOf(87, 97, 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60)
        val result = solution.rotLeft(input, 13)
        assertArrayEquals(expected, result)
    }
}
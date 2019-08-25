package hackerrank

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class LeftRotationTest {

    @Test
    fun rotLeft() {

        // given
        val input1 = arrayOf(1, 2, 3, 4, 5)
        val expected1 = arrayOf(5, 1, 2, 3, 4)
        val input2 = arrayOf(77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77)
        val expected2 = arrayOf(41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51)
        val input3 = arrayOf(33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97)
        val expected3 = arrayOf(87, 97, 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60)
        val rotation = LeftRotation()

        // then
        assertArrayEquals(expected1, rotation.rotLeft(input1, 4))
        assertArrayEquals(expected2, rotation.rotLeft(input2, 10))
        assertArrayEquals(expected3, rotation.rotLeft(input3, 13))
    }
}
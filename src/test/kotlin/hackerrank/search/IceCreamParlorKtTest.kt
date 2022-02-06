package hackerrank.search

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IceCreamParlorKtTest {

    @Test
    fun `whatFlavors sample`() {

        // in kotlin
        assertEquals(1 to 4, whatFlavors(arrayOf(1, 4, 5, 3, 2), 4))
        assertEquals(1 to 2, whatFlavors(arrayOf(2, 2, 4, 3), 4))
        assertEquals(2 to 4, whatFlavors(arrayOf(4, 3, 2, 5, 7), 8))
        assertEquals(2 to 4, whatFlavors(arrayOf(4, 5, 2, 3, 7), 8))

        // in java
        assertArrayEquals(intArrayOf(1, 4), IceCreamParlor.getFlavors(intArrayOf(1, 4, 5, 3, 2), 4))
        assertArrayEquals(intArrayOf(1, 2), IceCreamParlor.getFlavors(intArrayOf(2, 2, 4, 3), 4))
        assertArrayEquals(intArrayOf(2, 4), IceCreamParlor.getFlavors(intArrayOf(4, 3, 2, 5, 7), 8))
        assertArrayEquals(intArrayOf(2, 4), IceCreamParlor.getFlavors(intArrayOf(4, 5, 2, 3, 7), 8))
    }

}
package math

import org.junit.Test

import org.junit.Assert.*

class FibonacciKtTest {

    @Test
    fun fibonacci() {
        assertEquals(0, fibonacci(1)) // 0
        assertEquals(1, fibonacci(2)) // 0,1
        assertEquals(1, fibonacci(3)) // 0,1,1
        assertEquals(2, fibonacci(4)) // 0,1,1,2
        assertEquals(3, fibonacci(5)) // 0,1,1,2,3
        assertEquals(5, fibonacci(6)) // 0,1,1,2,3,5
        assertEquals(8, fibonacci(7)) // 0,1,1,2,3,5,8
        assertEquals(13, fibonacci(8)) // 0,1,1,2,3,5,8,13
        assertEquals(21, fibonacci(9)) // 0,1,1,2,3,5,8,13,21
    }

}
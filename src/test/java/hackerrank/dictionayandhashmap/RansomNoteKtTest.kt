package hackerrank.dictionayandhashmap

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RansomNoteKtTest {

    @Test
    fun `checkMagazine case1`() {
        val magazine = arrayOf("give", "me", "one", "grand", "today", "night")
        val note = arrayOf("give", "one", "grand", "today")
        val result = checkMagazine(magazine, note)
        assertTrue(result)
    }

    @Test
    fun `checkMagazine case2`() {
        val magazine = arrayOf("two", "times", "three", "is", "not", "four")
        val note = arrayOf("two", "times", "two", "is", "four")
        val result = checkMagazine(magazine, note)
        assertFalse(result)
    }

    @Test
    fun `checkMagazine case3`() {
        val magazine = arrayOf("ive", "got", "a", "lovely", "bunch", "of", "coconuts")
        val note = arrayOf("ive", "got", "some", "coconuts")
        val result = checkMagazine(magazine, note)
        assertFalse(result)
    }
}
package hackerrank.dictionaryandhashmap

import hackerrank.dictionayandhashmap.checkMagazine
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RansomNoteKtTest {

    @Test
    fun `checkMagazine case1`() {
        val magazine = arrayOf(
            "give",
            "me",
            "one",
            "grand",
            "today",
            "night"
        )

        val note = arrayOf(
            "give",
            "one",
            "grand",
            "today"
        )

        val result = checkMagazine(magazine, note)
        assertTrue(result)
    }

    @Test
    fun `checkMagazine case2`() {
        val magazine = arrayOf(
            "two",
            "times",
            "three",
            "is",
            "not",
            "four"
        )

        val note = arrayOf(
            "two",
            "times",
            "two",
            "is",
            "four"
        )

        val result = checkMagazine(magazine, note)
        assertFalse(result)
    }

    @Test
    fun `checkMagazine case3`() {
        val magazine = arrayOf(
            "ive",
            "got",
            "a",
            "lovely",
            "bunch",
            "of",
            "coconuts"
        )

        val note = arrayOf(
            "ive",
            "got",
            "some",
            "coconuts"
        )
        
        val result = checkMagazine(magazine, note)
        assertFalse(result)
    }

    @Test
    fun `checkMagazine case4 ulocked`() {
        val magazine = arrayOf(
            "apgo",
            "clm",
            "w",
            "lxkvg",
            "mwz",
            "elo",
            "bg",
            "elo",
            "lxkvg",
            "elo",
            "apgo",
            "apgo",
            "w",
            "elo",
            "bg"
        )

        val note = arrayOf(
            "elo",
            "lxkvg",
            "bg",
            "mwz",
            "clm",
            "w"
        )

        val result = checkMagazine(magazine, note)
        assertTrue(result)
    }
}
package hackerrank.dictionaryandhashmap

import hackerrank.dictionaryandhashmap.checkMagazine
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

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
    fun `checkMagazine case4 unlocked`() {
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
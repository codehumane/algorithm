package hackerrank.string

fun alternatingCharacters(s: String): Int {

    var count = 0
    var beforeChar = 'X'

    s.forEach {
        if (it == beforeChar) count++
        beforeChar = it
    }

    return count
}

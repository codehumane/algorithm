package hackerrank.dictionayandhashmap

fun twoStrings(s1: String, s2: String): String {
    val counts = s1.groupingBy { it }.eachCount()
    val sharing = s2.any { counts.containsKey(it) }
    return if (sharing) "YES" else "NO"
}
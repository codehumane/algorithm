package hackerrank.string

fun makeAnagram(a: String, b: String): Int {
    val charCountsA = a.groupingBy { it }.eachCount()
    val charCountsB = b.groupingBy { it }.eachCount()
    val deletionCountA = countDeletion(charCountsA, charCountsB)
    val deletionCountB = countDeletion(charCountsB, charCountsA)

    return deletionCountA + deletionCountB
}

private fun countDeletion(compare: Map<Char, Int>, target: Map<Char, Int>): Int {
    return compare
        .map { it.value - target.getOrDefault(it.key, 0) }
        .filter { it > 0 }
        .sum()
}

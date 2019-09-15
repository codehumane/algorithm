package hackerrank.dictionaryandhashmap

fun checkMagazine(magazine: Array<String>, note: Array<String>): Boolean {

    val magazineWordCounts = magazine
        .groupingBy { it }
        .eachCount()

    val noteWordCounts = note
        .groupingBy { it }
        .eachCount()

    return noteWordCounts
        .all { it.value <= magazineWordCounts[it.key] ?: 0 }

}
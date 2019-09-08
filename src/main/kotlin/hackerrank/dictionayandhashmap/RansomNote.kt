package hackerrank.dictionayandhashmap

fun checkMagazine(magazine: Array<String>, note: Array<String>): Boolean {

    val magazineWordCounts = magazine
        .groupBy { it }
        .mapValues { it.value.size }

    val noteWordCounts = note
        .groupBy { it }
        .mapValues { it.value.size }

    return noteWordCounts.all {
        it.value <= magazineWordCounts[it.key] ?: 0
    }

}
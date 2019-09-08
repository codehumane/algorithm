package hackerrank.dictionayandhashmap

fun checkMagazine(magazine: Array<String>, note: Array<String>): Boolean {
    return note.all { word ->

        var matching = false
        (0 until magazine.size).forEach { candidateIndex ->
            if (magazine[candidateIndex] == word) {
                magazine[candidateIndex] = ""
                matching = true
            }
        }

        matching

    }
}
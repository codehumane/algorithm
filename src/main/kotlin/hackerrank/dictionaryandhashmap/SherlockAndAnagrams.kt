package hackerrank.dictionaryandhashmap

// 이 방식은 수행시간이 n(n+1)/2. 즉, O(n^2)
fun sherlockAndAnagrams(s: String): Int {
    val anagramCount = mutableMapOf<String, Int>()

    (1 until s.length).forEach { wordSize ->
        (0..s.length - wordSize).forEach { wordIndex ->

            val anagram = s
                .substring(wordIndex, wordIndex + wordSize)
                .toCharArray()
                .apply { sort() }
                .let { String(it) }

            val count = anagramCount[anagram] ?: 0
            anagramCount[anagram] = count + 1

        }
    }

    return anagramCount
        .filter { it.value > 1 }
        .map { (it.value * (it.value - 1)) / 2 }
        .sum()
}

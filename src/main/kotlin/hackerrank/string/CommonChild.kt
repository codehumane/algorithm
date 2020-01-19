package hackerrank.string

import kotlin.math.max

/**
 * AA, BB
 * HARRY, SALLY
 * SHINCHAN, NOHARAAA
 * ABCDEF, FBDAMN
 *
 *   SHINCHAHN
 * N 000111111
 * O -
 * H 011111111
 * H 011112222
 * A 011112333
 * R -
 * A -
 * A -
 * A -
 *
 */
fun commonChild(s1: String, s2: String): Int {
    val counts = Array(s1.length + 1) { IntArray(s2.length + 1) }

    s1.forEachIndexed { i1, c1 ->
        s2.forEachIndexed { i2, c2 ->
            counts[i1 + 1][i2 + 1] = if (c1 == c2) {
                counts[i1][i2] + 1
            } else {
                max(counts[i1 + 1][i2], counts[i1][i2 + 1])
            }
        }

        printMatrix(counts, s1, s2)
    }

    return counts[s1.length][s2.length]
}

private fun printMatrix(counts: Array<IntArray>, s1: String, s2: String) {
    val s2Joined = s2.toCharArray().joinToString(" ")

    var s1CharIndex = 0
    val joined = counts
        .filterIndexed { i, _ -> i > 0 }
        .joinToString("\n") {
            "${s1[s1CharIndex++]} ${it.filterIndexed { i, _ -> i > 0 }.joinToString(" ")}"
        }

    println("matrix is...\n  $s2Joined\n$joined")
}

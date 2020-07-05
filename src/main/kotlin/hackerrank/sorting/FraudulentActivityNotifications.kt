package hackerrank.sorting

fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    var notification = 0
    val counts = IntArray(200 + 1)

    (0 until d).forEach {
        counts[expenditure[it]] += 1
    }

    var startDay = 0
    (d until expenditure.size).forEach {
        val median = median(counts, d)
        if (expenditure[it] >= median * 2) {
            notification++
        }

        counts[expenditure[startDay]] -= 1
        counts[expenditure[it]] += 1
        startDay++
    }

    return notification
}

fun median(counts: IntArray, days: Int): Float {
    val isOdd = days.rem(2) == 1
    var accum = 0
    var left = -1

    counts.forEachIndexed { index, count ->
        accum += count
        if (isOdd) {
            if (accum - 1 >= days.div(2))
                return index.toFloat()
        } else {
            if (accum == days.div(2)) {
                left = index
            }
            if (accum > days.div(2)) {
                return if (left == -1) {
                    index.toFloat()
                } else {
                    (left + index).div(2f)
                }
            }
        }
    }

    throw IllegalStateException("invalid fraudulent detection")
}

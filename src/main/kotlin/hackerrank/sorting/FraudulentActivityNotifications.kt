package hackerrank.sorting

fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    var count = 0

    (d until expenditure.size).forEach {
        if (isNotification(expenditure, it, d)) count++
    }

    return count
}

fun isNotification(
    expenditure: Array<Int>,
    index: Int,
    range: Int
): Boolean {

    val median = median(
        expenditure,
        index - range,
        index - 1
    )

    return expenditure[index].toFloat() >= (median * 2f)
}

private fun median(
    source: Array<Int>,
    from: Int,
    to: Int
): Float {

    val copy = source
        .copyOfRange(from, to + 1)
        .apply { sort() }

    val mid = copy.size.div(2)

    return if (copy.size.rem(2) == 0) {
        (copy[mid] + copy[mid + 1]).div(2f)
    } else {
        copy[mid].toFloat()
    }

}

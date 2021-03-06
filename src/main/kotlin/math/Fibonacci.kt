package math

fun fibonacci(n: Int): Int {
    return fibonacciTopDownWithoutArray(n)
}

fun fibonacciTopDownWithoutArray(n: Int): Int {
    if (n < 2) return n - 1

    var cache1 = 0
    var cache2 = 1

    repeat(n - 2) {
        val current = cache1 + cache2
        cache1 = cache2
        cache2 = current
    }

    return cache2
}

fun fibonacciTopDown(n: Int): Int {
    if (n < 2) return n - 1

    val cache = IntArray(n + 1) { -1 }
    cache[1] = 0
    cache[2] = 1

    (3..n).forEach {
        if (cache[it] == -1)
            cache[it] = cache[it - 1] + cache[it - 2]
    }

    return cache[n]
}

private fun fibonacciBottomUp(n: Int): Int {
    val cache = IntArray(n + 1) { -1 }
    return fibonacciBottomUp(n, cache)
}

fun fibonacciBottomUp(n: Int, cache: IntArray): Int {
    if (n == 1) return 0
    if (n == 2) return 1

    if (cache[n] == 0)
        cache[n] = fibonacci(n - 1) + fibonacci(n - 2)

    return cache[n]
}

fun fibonacciRecursive(n: Int): Int {
    if (n == 1) return 0
    if (n == 2) return 1
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)
}


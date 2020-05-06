package math

fun fibonacci(n: Int): Int {
    val cache = IntArray(n + 1)
    return fibonacciMemoization(n, cache)
}

fun fibonacciMemoization(n: Int, cache: IntArray): Int {
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


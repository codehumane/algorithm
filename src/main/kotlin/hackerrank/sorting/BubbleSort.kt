package hackerrank.sorting

fun countSwaps(a: Array<Int>) {
    var swapCount = 0;

    repeat(a.size) {
        (0 until a.size - 1).forEach {
            if (a[it] > a[it + 1]) {
                swap(a, it, it + 1)
                swapCount++;
            }
        }
    }

    println("Array is sorted in $swapCount swaps.");
    println("First Element: ${a.first()}");
    println("Last Element: ${a.last()}");
}

private fun swap(array: Array<Int>, index1: Int, index2: Int) {
    val temp = array[index1];
    array[index1] = array[index2];
    array[index1 + 1] = temp;
}

package hackerrank

/**
 * Arrays: Left Rotation
 *
 * 이 알고리즘은 <생각하는 프로그래밍>에 나왔던 방식이 생각나 그대로 풀어봄.
 * Java 버전으로는 아래와 같이 작성.
 *
Complete the rotLeft function below.
static int[] rotLeft(int[] a, int d) {
final int left = d % a.length;
reverse(a, 0, d - 1);
reverse(a, d, a.length - 1);
reverse(a, 0, a.length - 1);
return a;
}

private static void reverse(int[] a, int from, int to) {
if (from == to) return;
final int mid = (from + to) / 2;
for (int i = 0; i <= mid - from; i++) {
swap(a, from + i, to - i);
}
}

private static void swap(int[] a, int idx1, int idx2) {
if (idx1 == idx2) return;
final int temp = a[idx2];
a[idx2] = a[idx1];
a[idx1] = temp;
}
 */
class LeftRotation {

    fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
        val left = d.rem(a.size)
        reverse(a, 0, left - 1)
        reverse(a, left, a.size - 1)
        reverse(a, 0, a.size - 1)
        return a
    }

    private fun reverse(a: Array<Int>, from: Int, to: Int) {
        if (from == to) return
        val mid = (from + to) / 2
        (0..mid - from).forEach {
            swap(a, from + it, to - it)
        }
    }

    private fun swap(a: Array<Int>, idx1: Int, idx2: Int) {
        if (idx1 == idx2) return
        val temp = a[idx2]
        a[idx2] = a[idx1]
        a[idx1] = temp
    }

}
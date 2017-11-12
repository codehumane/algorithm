package math;

import java.util.Arrays;

/**
 * 주어진 리스트 l에서 중위수를 찾아낸다.
 */
class MedianFinder {

    // 대충 작성해 본 의사 코드

    // 입력값: array = {5,1,2,6}

    // 분할
    // v = first of array
    // l = {1,2}, m = {5}, r = {6}
    // medianIdx = (array.length - 1)/2 = 1
    // if l.length > medianIdx : find(l, fromIdx, medianIdx)
    // elseif l.length + m.length > medianIdx : find(l, medianIdx + 1, l.length + m.length - 1)
    // else : find(l, l.length + m.length, array.length - 1)

    // 정복
    // 생략. 코딩하면서 생각함.

    static int run(int[] input) {
        if (input.length == 1)
            return input[0];

        int iMedian = (input.length - 1) / 2;
        return find(input, 0, input.length - 1, iMedian);
    }

    private static int find(int[] input, int iFrom, int iTo, int iMedian) {

        // 기저 조건
        if (iFrom == iMedian && iTo == iMedian)
            // 정복 단계의 로직 상, 이 외의 기저 조건이 발생할 수 없음.
            return input[iMedian];

        // 분할
        int iv = iFrom;
        int vLength = 1;
        for (int i = iv + 1; i <= iTo; i++) {
            if (input[iv] > input[i]) {
                moveLeft(input, i, iv);
                iv++;
            } else if (input[iv] == input[i]) {
                iv++;
            }
        }

        // 정복
        if (iv - 1 >= iMedian)
            return find(input, iFrom, iv - 1, iMedian);
        else if (iv + vLength - 1 >= iMedian)
            return find(input, iv, iv + vLength - 1, iMedian);
        else
            return find(input, iv + vLength, iTo, iMedian);
    }

    private static void moveLeft(int[] arr, int from, int until) {
        while (from > until) {
            swap(arr, from, from - 1);
            from--;
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}

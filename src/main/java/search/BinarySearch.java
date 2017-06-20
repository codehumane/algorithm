package search;

/**
 * 이진 탐색
 * <p>
 * n >= 0이고, x[0] <= x[1] <= x[2] <= ... <= x[n-1]이 성립할 때,
 * x와 동일한 타입의 숫자 t가 x에 존재한다면 인덱스를 반환하고,
 * 존재하지 않으면 -1을 반환한다.
 * <p>
 * 설명 출처: 생각하는 프로그래밍
 */
class BinarySearch {

    static int search(int[] x, int t) {
        return search(x, 0, x.length - 1, t);
    }

    private static int search(int[] x, int start, int end, int t) {
        if (start == end) return x[start] == t ? start : -1;

        int mid = (start + end) / 2;
        if (t > x[mid]) return search(x, mid + 1, end, t);
        else return search(x, start, mid, t);
    }
}

package sort;

/**
 * 오랜만에 병합정렬을 다시 작성해 봄. <br/>
 * 그리고 잘못 작성 됨. <br/>
 * 하지만 오답 노트의 효용처럼, 이 잘못된 로직도 기록에 남김. <br/>
 */
class WrongMergeSort {

    int[] run(int[] input) {
        if (input.length == 1) return input;
        sort(input, 0, input.length - 1);
        return input;
    }

    // 먼저 나누고, 병합할 때 순서를 정한다.
    private void sort(int[] input, int iFrom, int iTo) {

        if (iTo - iFrom < 1) return;

        // 나눌 때의 기준 : 0 ~ (from + to) / 2, (from + to) / 2 + 1 ~ to
        // 예) 원소 1개: 예외. 먼저 검사하고 리턴,
        // 예) 원소 2개: 1/2 = 0, 원소 3개: 2/2 = 1, 4개: 3/2 = 1, 5개: 4/2 = 2, ...

        int iMid = (iFrom + iTo) / 2;
        sort(input, iFrom, iMid);
        sort(input, iMid + 1, iTo);
        merge(input, iFrom, iTo, iMid);
    }

    private void merge(int[] input, int iFrom, int iTo, int iMid) {

        int iLeft = iFrom;
        int iRight = iMid + 1;

        // 만약, 왼쪽의 값이 오른쪽의 값 보다 크면,
        // 사이의 모든 값을 오른쪽으로 한칸 씩 이동시키고,
        // 오른쪽의 값을 왼쪽의 값 위치로 이동시킨다.
        // 더 좋은 방법 없나?
        // 그리고 이런 처리를 칭하는 용어는 없을까? 주저리 주저리..
        while (iLeft <= iRight - 1 && iRight <= iTo) {
            if (input[iLeft] > input[iRight]) {

                int i = iRight;
                while (i > iLeft) {
                    swap(input, i, i - 1);
                    i--;
                }

                iRight++;
            } else {
                iLeft++;
            }
        }
    }

    private void swap(int[] input, int idx1, int idx2) {
        int temp = input[idx1];
        input[idx1] = input[idx2];
        input[idx2] = temp;
    }
}

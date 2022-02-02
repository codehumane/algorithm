package quiz.sort;

class Distinct {

    int solution(int[] A) {
        mergeSort(A);
        return countDistinctOnSorted(A);
    }

    int[] mergeSort(int[] A) {
        mergeSort(0, A.length - 1, A);
        return A;
    }

    private void mergeSort(int from, int to, int[] A) {
        if (to - from + 1 < 2) return;

        // 2(0-1)개 : 0,0,1
        // 3(0-2)개 : 0,1,2
        // 4(0-3)개 : 0,1,3
        // 5(0-4)개 : 0,2,4
        int mid = (from + to) / 2;

        mergeSort(from, mid, A);
        mergeSort(mid + 1, to, A);

        merge(A, from, mid, to);
    }

    private void merge(int[] A, int from, int mid, int to) {

        int leftIdx = from;
        int rightIdx = mid + 1;
        int size = to - from + 1;
        int[] sorted = new int[size];
        int sortedIdx = 0;

        while (sortedIdx < size) {
            if (rightIdx > to || (leftIdx <= mid && A[leftIdx] < A[rightIdx])) {
                sorted[sortedIdx++] = A[leftIdx++];
            } else {
                sorted[sortedIdx++] = A[rightIdx++];
            }
        }

        for (int s : sorted) {
            A[from++] = s;
        }
    }

    private int countDistinctOnSorted(int[] A) {

        int last = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (i == 0 || A[i] > last) {
                last = A[i];
                count++;
            }
        }

        return count;
    }
}

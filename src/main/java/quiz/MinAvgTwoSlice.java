package quiz;

class MinAvgTwoSlice {

    int solution(int[] A) {

        int startIdx = 0;
        int N = A.length;
        double minAvg = 0;

        for (int i = 0; i <= N - 2; i++) {

            double avg = (A[i] + A[i + 1]) / 2.0;
            if (i == 0 || avg < minAvg) {
                minAvg = avg;
                startIdx = i;
            }

            if (i < N - 2) {
                avg = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
                if (avg < minAvg) {
                    minAvg = avg;
                    startIdx = i;
                }
            }
        }

        return startIdx;
    }
}

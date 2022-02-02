package quiz.math;

class CountDiv {

    int solution(int A, int B, int K) {
        final int first = (A % K == 0) ? A : (A / K + 1) * K;
        return B < first ? 0 : (B - first) / K + 1;
    }
}

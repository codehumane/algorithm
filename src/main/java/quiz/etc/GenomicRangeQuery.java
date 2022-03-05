package quiz.etc;

class GenomicRangeQuery {

    /**
     * O(M+N) 구현은 아래 2개 링크 참고
     * <p>
     * - [prefix sum](https://en.wikipedia.org/wiki/Prefix_sum)
     * - [문제풀이](https://github.com/ZRonchy/Codility/blob/master/Lesson3/GenomicRangeQuery.java)
     */
    int[] solution(String S, int[] P, int[] Q) {

        int M = P.length;
        int N = S.length();
        int[] result = new int[M];
        int[][] prefixSum = new int[3][N + 1];

        for (int i = 0; i < S.length(); i++) {
            prefixSum[0][i + 1] = prefixSum[0][i] + (S.charAt(i) == 'A' ? 1 : 0);
            prefixSum[1][i + 1] = prefixSum[1][i] + (S.charAt(i) == 'C' ? 1 : 0);
            prefixSum[2][i + 1] = prefixSum[2][i] + (S.charAt(i) == 'G' ? 1 : 0);
        }

        for (int K = 0; K < M; K++) {

            int from = P[K];
            int to = Q[K] + 1;

            if (prefixSum[0][to] - prefixSum[0][from] > 0) result[K] = 1;
            else if (prefixSum[1][to] - prefixSum[1][from] > 0) result[K] = 2;
            else if (prefixSum[2][to] - prefixSum[2][from] > 0) result[K] = 3;
            else result[K] = 4;
        }

        return result;
    }
}

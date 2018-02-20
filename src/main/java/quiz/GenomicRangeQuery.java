package quiz;

class GenomicRangeQuery {

    int[] solution(String S, int[] P, int[] Q) {

        int M = P.length;
        int[] result = new int[M];
        for (int K = 0; K < M; K++)
            result[K] = findMinimal(S, P[K], Q[K]);

        return result;
    }

    private int findMinimal(String S, int from, int to) {
        int min = convert(S, from);
        for (int j = from; j <= to; j++)
            if (min > convert(S, j))
                min = convert(S, j);

        return min;
    }

    private int convert(String S, int index) {
        if (S.charAt(index) == 'A') return 1;
        else if (S.charAt(index) == 'C') return 2;
        else if (S.charAt(index) == 'G') return 3;
        else return 4;
    }
}

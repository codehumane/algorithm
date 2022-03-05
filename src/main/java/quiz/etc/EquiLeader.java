package quiz.etc;

class EquiLeader {

    int solution(int[] A) {
        final int candidateIndex = findLeaderCandidate(A);
        final int candidateCount = countOccurrence(A, A[candidateIndex]);

        if (A.length / 2 < candidateCount)
            return countEquiLeader(A, A[candidateIndex], candidateCount);

        return 0;
    }

    private int findLeaderCandidate(int[] A) {

        int candidateIndex = 0;
        int candidateCount = 0;

        for (int i = 0; i < A.length; i++) {
            if (candidateCount == 0) {
                candidateIndex = i;
                candidateCount++;
                continue;
            }

            if (A[i] == A[candidateIndex]) candidateCount++;
            else candidateCount--;
        }

        return candidateIndex;
    }

    private int countOccurrence(int[] A, int i) {
        int candidateCount = 0;
        for (int a : A) {
            if (a == i)
                candidateCount++;
        }

        return candidateCount;
    }

    private int countEquiLeader(int[] A, int i, int candidateCount) {

        final int N = A.length;
        int leaderMeetCount = 0;
        int equiLeaderCount = 0;

        for (int S = 0; S < N - 1; S++) {
            if (A[S] == i)
                leaderMeetCount++;

            if ((S + 1) / 2 < leaderMeetCount
                    && (N - S - 1) / 2 < candidateCount - leaderMeetCount)
                equiLeaderCount++;
        }

        return equiLeaderCount;
    }
}

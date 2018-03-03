package quiz;

class Dominator {

    int solution(int[] A) {
        final int candidateIndex = findCandidateIndex(A);
        return isDominant(A, candidateIndex) ? candidateIndex : -1;
    }

    private int findCandidateIndex(int[] A) {

        int candidateIndex = 0;
        int counter = 0;

        for (int i = 0; i < A.length; i++) {
            if (counter == 0) {
                counter++;
                candidateIndex = i;
                continue;
            }

            if (A[i] == A[candidateIndex]) counter++;
            else counter--;
        }

        return candidateIndex;
    }

    private boolean isDominant(int[] A, int index) {
        int occurrence = 0;
        for (int a : A) {
            if (a == A[index])
                occurrence++;
        }

        return occurrence > A.length / 2;
    }
}


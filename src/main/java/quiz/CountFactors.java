package quiz;

class CountFactors {

    int solution(int N) {

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) count++;
        }

        return count;
    }
}

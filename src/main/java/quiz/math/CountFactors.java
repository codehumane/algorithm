package quiz.math;

class CountFactors {

    int solution(int N) {

        int count = 0;
        for (long i = 1; i * i <= N; i++) {
            if (N % i == 0)
                count += (N / i == i) ? 1 : 2;
        }

        return count;
    }
}

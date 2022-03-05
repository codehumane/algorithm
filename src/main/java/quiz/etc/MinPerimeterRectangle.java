package quiz.etc;

class MinPerimeterRectangle {

    int solution(int N) {
        int min = Integer.MAX_VALUE;
        final double root = Math.sqrt(N);
        for (int i = 1; i <= root; i++) {
            if (N % i == 0)
                min = Math.min((i + N / i) * 2, min);
        }

        return min;
    }

}

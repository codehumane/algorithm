package quiz.dynamic;

/**
 * 이항 계수를 캐시 없이 구현한다. 단순 분할 정복
 */
public class BinomialCoefficientWithNoCache implements BinomialCoefficient {

    @Override
    public int calculate(int N, int K) {
        if (N == K || K == 0) {
            // base condition
            return 1;
        }

        int result = 0;
        result += calculate(N - 1, K);
        result += calculate(N - 1, K - 1);
        return result;
    }
}
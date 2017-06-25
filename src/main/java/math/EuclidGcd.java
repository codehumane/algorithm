package math;

/**
 * 유클리드의 최대 공약수 구하기
 */
class EuclidGcd {

    /**
     * 주어진 두 자연수의 최대 공약수를 반환한다.
     * <p>
     * 유클리드의 최대 공약수는 두 자연수 X, Y (X > Y)가 있을 때 아래의 규칙을 이용한다.
     * <p>
     * 1. EuclidGcd(X, 0) = X <br/>
     * 2. EuclidGcd(0, Y) = Y <br/>
     * 3. EuclidGcd(X, Y) = EuclidGcd(X MOD Y, Y) <br/>
     *
     * @param arg1 자연수
     * @param arg2 자연수
     * @return 공약수
     */
    static int run(int arg1, int arg2) {
        int X = arg1 > arg2 ? arg1 : arg2;
        int Y = arg1 > arg2 ? arg2 : arg1;
        return gcd(X, Y);
    }

    private static int gcd(int X, int Y) {
        if (Y == 0) return X;
        return gcd(Y, X % Y);
    }
}

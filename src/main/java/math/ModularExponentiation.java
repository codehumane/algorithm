package math;

/**
 * 모듈러 연산
 */
class ModularExponentiation {

    /**
     * 주어진 밑(base)과 지수(exponentiation)에 대한 모듈러(N) 연산의 결과를 반환함.
     *
     * @param base 밑
     * @param expo 지수
     * @param N    모듈러
     * @return 모듈러 연산 결과
     */
    static int calc(int base, int expo, int N) {
        if (expo == 0)
            return 1;

        return (calc(base, expo - 1, N) * base) % N;
    }

    /**
     * 제곱을 이용한 모듈러 지수 연산
     */
    static int calcBySquare(int base, int expo, int N) {
        if (expo == 1)
            return base % N;

        final int sqr = onlyBySqr(base, expo / 2, N);
        final int rest = calc(base, expo % 2, N);
        return (sqr * sqr * rest) % N;
    }

    private static int onlyBySqr(int base, int expo, int N) {
        if (expo == 1)
            return base % N;

        final int sqrBase = onlyBySqr(base, expo / 2, N);
        return (sqrBase * sqrBase) % N;
    }

    /**
     * 2의 지수를 활용한 모듈러 지수 연산
     */
    static int calcByPowerOf2(int base, int expo, int N) {
        int sum = 1;
        int tmp = 1;

        while (expo >= tmp) {
            if ((tmp & expo) == tmp)
                sum *= onlyBySqr(base, tmp, N);
            tmp = tmp << 1;
        }

        return sum % N;
    }
}

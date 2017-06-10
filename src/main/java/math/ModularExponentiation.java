package math;

/**
 * 모듈러 연산
 */
public class ModularExponentiation {

    /**
     * 주어진 밑(base)과 지수(exponentiation)에 대한 모듈러(N) 연산의 결과를 반환함.
     *
     * @param base 밑
     * @param expo 지수
     * @param N    모듈러
     * @return 모듈러 연산 결과
     */
    public static int calc(int base, int expo, int N) {
        if (expo == 0)
            return 1;

        return (calc(base, expo - 1, N) * base) % N;
    }
}

package math;

import math.EuclidExtended.Result;

/**
 * 주어진 정수 a(a>0)와 modulo N에 대한 모듈러 역수를 구하라.<br/>
 * 만약 역수가 없는 경우에는 -1을 반환한다.
 * <p>
 * 모듈러 역수의 정의는 아래와 같다.<br/>
 * (a * a^-1) ≡ 1 (mod N) 혹은 (a * a^-1) mod N = 1
 */
class ModularInverse {

    /**
     * a^-1을 b라고 두고, b를 0부터 N-1까지 늘려가며 a * b를 N으로 나눠본다. <br/>
     * 나머지가 1이면, 이 때의 b가 바로 역수가 된다. <br/>
     * 없으면 -1을 반환한다.
     */
    static int get(int a, int N) {
        for (int i = 0; i < N - 1; i++) {
            if (a * i % N == 1) return i;
        }
        return -1;
    }

    /**
     * 유클리드 확장을 이용한 방법
     */
    static int getByEuclidExtended(int a, int N) {
        final Result result = EuclidExtended.get(a, N);
        if (result.getD() > 1) return -1;
        return result.getX();
    }
}

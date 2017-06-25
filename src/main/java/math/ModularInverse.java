package math;

/**
 * 주어진 정수 a(a>0)와 modulo N에 대한 모듈러 역수를 구하라.<br/>
 * 만약 역수가 없는 경우에는 -1을 반환한다.
 * <p>
 * 모듈러 역수의 정의는 아래와 같다.<br/>
 * (a * a^-1) ≡ 1 (mod N) 혹은 (a * a^-1) mod N = 1
 */
class ModularInverse {

    static int get(int a, int N) {
        for (int i = 0; i < N - 1; i++) {
            if (a * i % N == 1) return i;
        }

        return -1;
    }
}

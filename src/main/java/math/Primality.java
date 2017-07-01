package math;

import lombok.extern.slf4j.Slf4j;

/**
 * 페르마의 소정리를 이용한 소수 판별<br/>
 * 지수에 대한 모듈러 연산이 이용되므로, {@link ModularExponentiation} 참조됨
 *
 * @see <a href="https://ko.wikipedia.org/wiki/%ED%8E%98%EB%A5%B4%EB%A7%88%EC%9D%98_%EC%86%8C%EC%A0%95%EB%A6%AC">페르마의 소정리</a>
 */
@Slf4j
class Primality {

    static boolean isPrimary(int N) {
        if (N < 4) return true;

        final int aMax = N / 2 + 2;
        // 1이상 N 미만의 정수 중 절반 이상
        for (int a = 2; a <= aMax; a++) {
            // a^(N-1) ≡ 1 (mod N) 여부 확인
            if (ModularExponentiation.calcByPowerOf2(a, N - 1, N) != 1)
                return false;
        }

        // 절반 이상의 a에 대해 페르마 소정리가 성립되면, N은 소수이다. (단, 카미키얼 수 제외)
        return true;
    }
}

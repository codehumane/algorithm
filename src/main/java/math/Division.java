package math;

/**
 * 나눗셈
 */
class Division {

    /**
     * 주어진 피제수(dividend)를 제수(divisor)로 나누었을 때, 몫(quotient)을 반환함.
     *
     * @param dividend 피제수
     * @param divisor  제수
     * @return 몫
     */
    static int calc(int dividend, int divisor) {
        int quotient = 0;
        while (dividend >= divisor) {
            dividend = dividend - divisor;
            quotient++;
        }

        return quotient;
    }
}

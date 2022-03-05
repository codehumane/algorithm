package quiz.math;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NumberSum {

    public int sum(int number) {
        return sumByDivide(number);
        //        return sumByRecursive(number);
        //        return sumByForStatement(number);
    }

    /**
     * 1부터 number까지의 정수를 분할 정복 방식으로 모두 더한다. <br/>
     *
     * 공식 도출은 아래 순서로 이루어진다. <br/>
     * = 1 + 2 + 3 + 4 + … + n <br/>
     * = (1 + 2 + 3 + … + n/2) + ((n/2 + 1) + … + n) <br/>
     * = (1 + 2 + 3 + … + n/2) + ((n/2 + 1) + (n/2 + 2) + … (n/2 + n/2)) <br/>
     * = n/2 * n/2 + (1 + 2 + 3 + … + n/2) <br/>
     * = n/2 * n/2 + sum(n/2) <br/>
     *
     * 시간 복잡도를 11이라는 입력 값을 예로 들어 계산하면 다음과 같다. <br/>
     * sum(11) <br/>
     * = sum(10) + 11 <br/>
     * = (sum(5)*2 + 5*5) + 11 <br/>
     * = ((sum(4) + 5)*2 + 5*5) + 11 <br/>
     * = (((sum(2)*2 + 4) + 5)*2 + 5*5) + 11 <br/>
     * = ((((sum(1)*2 + 1)*2 + 4) + 5)*2 + 5*5) + 11 <br/>
     * = ((((1*2 + 1)*2 + 4) + 5)*2 + 5*5) + 11 <br/>
     * = 66 <br/>
     *
     * @param number
     * @return
     */
    private int sumByDivide(int number) {
        if (number == 1) {
            // base case
            return 1;
        }

        if (number % 2 == 1) {
            return sumByDivide(number - 1) + number;
        }

        return 2 * sumByDivide(number / 2) + (number / 2) * (number / 2);
    }

    private int sumByRecursive(int number) {
        if (number == 1) {
            return 1;
        }

        return sumByRecursive(number - 1) + number;
    }

    private int sumByForStatement(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }

        return sum;
    }
}

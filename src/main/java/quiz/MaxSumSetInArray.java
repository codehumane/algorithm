package quiz;

/**
 * 1차원 배열에서 연속된 부분 구간 중 그 합이 최대인 구간을 찾아라.
 * 예를 들어, [-7, 4, -3, 6, 3, -8, 3, 4]에서 최대 합을 갖는 부분 구간은 [4, -3, 6, 3]이다.
 */
public class MaxSumSetInArray {

    public int sum(int[] array) {
//        return sum_N의_3승(array);
        return sum_N의_2승(array);
//        return sum_N_곱하기_로그N(array);
//        return sum_N(array);
    }

    private int sum_N의_3승(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int length = array.length;

        for (int i=0; i < length; i++) {
            for (int j=0; j < length; j++) {

                int sum = 0;
                for (int k=i; k<=j; k++) {
                    sum += array[k];
                }

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    private int sum_N의_2승(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int length = array.length;

        for (int i=0; i < length; i++) {
            int sum = 0;
            for (int j=i; j < length; j++) {
                sum += array[j];

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }
}

package quiz.math;

public class ErrorDigitDiff {

    /**
     * 0에서 10^9 사이의 수 중에서 임의의 값이 입력값으로 주어졌을 때,
     * 특정 숫자를 모두 다른 값으로 바꿔 최대/최소값을 구한 뒤,
     * 최대 최소 값의 차이를 구하기.
     * 단, 앞 자리 수를 0으로 바꿀 수는 없다.
     * <p>
     * 예컨대, 132635이 주어진다면,
     * 특정 숫자를 바꿔서 만들 수 있는 최소값은 102605이고,
     * 최대값은 932635이므로,
     * 이들의 차이를 구하면 932635 - 102605 즉, 830030이 된다.
     */
    public long solution(int N) {
        return max(N) - min(N);
    }

    /**
     * 첫 번째 자리수부터 맨 마지막 자리수까지 검사하면서,
     * 9가 아닌 가장 첫 번째 수를 찾은 뒤 9로 바꾸고,
     * 뒤이어 나오는 같은 숫자도 모두 9로 바꿔준다.
     */
    long max(int N) {
        char target = 'x';
        char value = '9';

        for (char c : toChars(N)) {
            if (c != value) {
                target = c;
                break;
            }
        }

        return replace(N, value, target);
    }

    /**
     * 첫 번째 자리수가 1이면,
     * 뒤이어 오는 숫자 중 0이 아니고 1이 아닌 것을 0으로 바꾸면 됨.
     * <p>
     * 첫 번째 자리수가 1이 아니면(0일 수는 없음),
     * 첫 번째 숫자와 같은 숫자들을 모두 1로 바꾸면 됨.
     */
    long min(int N) {
        char lead = String.valueOf(N).charAt(0);
        char target = 'x';
        char value;

        if (lead == '1') {
            value = '0';
            for (char c : toChars(N)) {
                if (c != '0' && c != '1') {
                    target = c;
                    break;
                }
            }
        } else {
            value = '1';
            target = lead;
        }

        return replace(N, value, target);
    }

    private Long replace(int N, char value, char target) {
        return Long.valueOf(String.valueOf(N).replace(target, value));
    }

    private char[] toChars(int N) {
        return String.valueOf(N).toCharArray();
    }

}

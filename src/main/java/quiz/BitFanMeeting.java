package quiz;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BitFanMeeting implements FanMeeting {

    private static final char CHAR_MALE = 'M';
    private static final char CHAR_FEMALE = 'F';
    private static final int BIT_MALE = 1;
    private static final int BIT_FEMALE = 0;

    /**
     * 문제의 정의 중 '멤버의 수와 팬의 수는 모두 1 이상 200,000 이하의 정수이며, 멤버의 수는 항상 팬의 수 이하입니다.' 부분이 있다. <br/>
     * 비트로의 변환 시, 2의 200,000승을 int와 float이 표현할 수는 없으므로<br/>
     * 입력 값이 큰 경우에는 이 해결책이 적용될 수 없다.<br/>
     * 반면 {@link FoolFanMeeting}에 비해서는 더 나은 시간 복잡도를 보인다.<br/>
     * 멤버가 M, 팬을 N이라고 할 때 O(N - M + M + N) 즉, O(2N)의 시간 복잡도를 가진다.
     *
     * @param members
     * @param fans
     * @return
     */
    @Override
    public int count(String members, String fans) {
        int memBit = convertToBit(members);
        int fanBit = convertToBit(fans);
        int count = 0;

        for (int i = fans.length() - members.length(); i >= 0; i--) {
            if ((memBit << i & fanBit) == 0) {
                count++;
            }
        }

        return count;
    }

    private int convertToBit(String string) {
        int bit = 0;
        for (int i = 0; i < string.length(); i++) {
            bit <<= 1;
            if (isMaleChar(string, i)) {
                bit |= BIT_MALE;
            }
        }

        return bit;
    }

    private boolean isMaleChar(String string, int i) {
        return string.charAt(i) == CHAR_MALE;
    }
}

package quiz.bit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FoolFanMeeting implements FanMeeting {

    private static final char MALE = 'M';

    /**
     * 시간 복잡도는 멤버의 수를 N, 팬의 수를 M이라고 할 때 O(MN-NN)이 소요됨<br/>
     *
     * @param members
     * @param fans
     * @return
     */
    @Override
    public int count(String members, String fans) {
        log.info("FoolFanMeeting");
        int count = 0;
        int fanIdx = 0;
        while (fanIdx + members.length() <= fans.length()) {
            if (isFullHug(members, fans, fanIdx++)) {
                count++;
            }
        }

        return count;
    }

    private boolean isFullHug(String members, String fans, int fanIdx) {
        for (int i = 0; i < members.length(); i++) {
            if (isMale(members.charAt(i)) && isMale(fans.charAt(fanIdx + i))) {
                return false;
            }
        }

        return true;
    }

    private boolean isMale(char memChar) {
        return memChar == MALE;
    }
}

package quiz;

/**
 * https://algospot.com/judge/problem/read/FANMEETING
 */
public class FanMeeting {

    private static final char MALE = 'M';
    private static final char FEMALE = 'F';

    public int countFullMembersConcurrentHugCount(String members, String fans) {
        char[] memChars = members.toCharArray();
        char[] fanChars = fans.toCharArray();
        int count = 0;

        int fanIdx = 0;
        while (fanIdx + memChars.length <= fanChars.length) {
            if (checkConcurrentHug(memChars, fanChars, fanIdx++)) {
                count++;
            }
        }

        return count;
    }

    private boolean checkConcurrentHug(char[] memChars, char[] fanChars, int fanIdx) {
        for (int i = 0; i < memChars.length; i++) {
            if (memChars[i] == MALE && fanChars[fanIdx + i] == MALE) {
                return false;
            }
        }

        return true;
    }
}

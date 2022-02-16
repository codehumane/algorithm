package quiz.dynamic;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 * <p>
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        final var sub = p.split("\\*");
        var beginIdx = 0;

        for (int i = 0; i < sub.length; i++) {
            beginIdx = indexOf(s, sub[i], beginIdx);

            if (beginIdx == -1) return false; // 일치하는 것 없음
            if (i == 0 && p.charAt(0) != '*' && beginIdx != 0) return false; // first 부분

            beginIdx += sub[i].length();
        }

        return p.charAt(p.length() - 1) == '*' || beginIdx == s.length();
    }

    private int indexOf(String string, String regex, int beginIdx) {
        var si = beginIdx;

        while (si < string.length()) {
            if (si + regex.length() <= string.length() &&
                    match(string, si, si + regex.length() - 1, regex)) {
                return si;
            }

            si++;
        }

        return -1;
    }

    private boolean match(String string, int start, int end, String regex) {
        var si = start;
        var ri = 0;

        while (ri < regex.length()) {
            if (si > end) return false;
            if (regex.charAt(ri) != '.' && regex.charAt(ri) != string.charAt(si)) return false;

            si++;
            ri++;
        }

        return true;
    }

}

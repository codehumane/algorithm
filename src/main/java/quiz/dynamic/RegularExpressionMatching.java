package quiz.dynamic;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 * <p>
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */
public class RegularExpressionMatching {

    public boolean isMatch(String text, String pattern) {
        return dp(
                0,
                0,
                text,
                pattern,
                new Boolean[text.length() + 1][pattern.length() + 1]
        );
    }

    private boolean dp(int ti,          // text index
                       int pi,          // pattern index
                       String t,        // text
                       String p,        // pattern
                       Boolean[][] m) { // memoization

        if (m[ti][pi] != null) {
            return m[ti][pi];
        }

        if (pi == p.length()) {
            m[ti][pi] = ti == t.length();
        } else {
            if (isStarChar(pi, p)) {
                m[ti][pi] = dp(ti, pi + 2, t, p, m) ||
                        (matchFirst(ti, pi, t, p) && dp(ti + 1, pi, t, p, m));
            } else {
                m[ti][pi] = matchFirst(ti, pi, t, p) && dp(ti + 1, pi + 1, t, p, m);
            }
        }

        return m[ti][pi];
    }

    private boolean matchFirst(int ti, int pi, String t, String p) {
        return ti < t.length() && (p.charAt(pi) == t.charAt(ti) || p.charAt(pi) == '.');
    }

    private boolean isStarChar(int pi, String p) {
        return pi + 1 < p.length() && p.charAt(pi + 1) == '*';
    }

}

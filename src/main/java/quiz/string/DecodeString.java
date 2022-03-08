package quiz.string;

/**
 * https://leetcode.com/problems/decode-string/
 */
public class DecodeString {

    public String decodeString(String s) {
        return build(s, 0).string;
    }

    private EncodeState build(String s, int idx) {
        var builder = new StringBuilder();

        while (idx < s.length()) {

            if (Character.isAlphabetic(s.charAt(idx))) {
                builder.append(s.charAt(idx));
                idx++;

            } else if (Character.isDigit(s.charAt(idx))) {
                var bracketOpen = idx;
                while (Character.isDigit(s.charAt(bracketOpen))) {
                    bracketOpen++;
                }

                var encoded = build(s, bracketOpen + 1);
                var repeated = String
                        .valueOf(encoded.string)
                        .repeat(Math.max(0, Integer.parseInt(s.substring(idx, bracketOpen))));

                builder.append(repeated);
                idx = encoded.index + 1;

            } else {
                break;
            }
        }

        return new EncodeState(builder.toString(), idx);
    }

    static class EncodeState {

        final String string;
        final int index;

        public EncodeState(String string, int index) {
            this.string = string;
            this.index = index;
        }

    }

}

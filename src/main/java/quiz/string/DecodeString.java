package quiz.string;

/**
 * https://leetcode.com/problems/decode-string/
 */
public class DecodeString {

    public String decodeString(String s) {
        return new UsingRecursion().decodeString(s);
    }

    static class UsingRecursion {
        public String decodeString(String s) {
            return build(s, 0).string;
        }

        private Decoding build(String s, int idx) {
            var builder = new StringBuilder();

            while (idx < s.length()) {
                if (Character.isAlphabetic(s.charAt(idx))) {
                    builder.append(s.charAt(idx));
                    idx++;

                } else if (Character.isDigit(s.charAt(idx))) {
                    var decoded = decode(s, idx);
                    builder.append(decoded.string);
                    idx = decoded.index + 1;

                } else {
                    break;
                }
            }

            return new Decoding(builder.toString(), idx);
        }

        private Decoding decode(String s, int idx) {
            var bracketOpenIndex = indexOfBracketOpen(s, idx);
            var repeat = Integer.parseInt(s.substring(idx, bracketOpenIndex));
            var decoded = build(s, bracketOpenIndex + 1);

            var repeated = String
                    .valueOf(decoded.string)
                    .repeat(Math.max(0, repeat));

            return new Decoding(repeated, decoded.index);
        }

        private int indexOfBracketOpen(String s, int idx) {
            while (Character.isDigit(s.charAt(idx))) {
                idx++;
            }

            return idx;
        }

        static class Decoding {

            final String string;
            final int index;

            public Decoding(String string, int index) {
                this.string = string;
                this.index = index;
            }

        }
    }

}

package quiz.string;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        return new MySlidingWindow().lengthOfLongestSubstring(s);
    }

    static class MySlidingWindow {
        public int lengthOfLongestSubstring(String s) {
            var chars = new HashSet<Character>(s.length());
            var longest = 0;
            var left = 0;

            for (int i = 0; i < s.length(); i++) {
                var c = s.charAt(i);

                if (chars.contains(c)) {
                    longest = Math.max(longest, chars.size());

                    for (int l = left; l < i; l++) {
                        var d = s.charAt(l);
                        chars.remove(d);

                        if (d == c) {
                            left = l + 1;
                            break;
                        }
                    }
                }

                chars.add(c);
            }

            return Math.max(longest, chars.size());
        }
    }

}

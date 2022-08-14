package quiz.string;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        var bySlidingWindow = new SlidingWindow().lengthOfLongestSubstring(s);
        var byOptimized = new SlidingWindowOptimized().lengthOfLongestSubstring(s);
        assert bySlidingWindow == byOptimized;
        return bySlidingWindow;
    }

    static class SlidingWindowOptimized {

        public int lengthOfLongestSubstring(String s) {
            var indices = new HashMap<Character, Integer>();
            var longest = 0;
            var left = 0;

            for (int right = 0; right < s.length(); right++) {
                var c = s.charAt(right);

                if (indices.containsKey(c)) {
                    left = Math.max(left, indices.get(c) + 1);
                }

                longest = Math.max(longest, right - left + 1);
                indices.put(c, right);
            }

            return longest;
        }
    }

    static class SlidingWindow {
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

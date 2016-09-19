package quiz;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Wildcard {

    public static final char QUESTION = '?';
    public static final char ASTERISK = '*';
    private final String[] patterns;

    public Wildcard(String pattern) {
        this.patterns = splitPattern(pattern);
    }

    private String[] splitPattern(String input) {
        String[] pattern = new String[input.length() + 1];
        char[] chars = input.toCharArray();
        int start = 0;
        int idx = 0;

        for (int i = 0; i < chars.length; i++) {
            if (ASTERISK == chars[i] || QUESTION == chars[i]) {
                String sub = input.substring(start, i);
                if (sub.length() > 0) {
                    pattern[idx++] = sub;
                }

                start = i + 1;
                pattern[idx++] = input.substring(i, i + 1);
            }

            if (i == chars.length - 1 && start <= i) {
                pattern[idx] = input.substring(start, i + 1);
            }
        }

        return pattern;
    }

    public boolean match(String target) {
        return match(target, 0, 0);
    }

    private boolean match(String target, int from, int pIndex) {
        String pattern = patterns[pIndex];
        if ("*".equals(pattern)) {
            return matchAsterisk(target, from, pIndex);
        } else if ("?".equals(pattern)) {
            return matchQuestion(target, from, pIndex);
        } else {
            return matchNormal(target, from, pIndex);
        }
    }

    private boolean matchNormal(String target, int targetFrom, int pIndex) {
        String pattern = patterns[pIndex];

        // subt 구하기
        int targetTo = targetFrom + pattern.length();
        if (targetTo > target.length()) {
            return false;
        }

        String subt = target.substring(targetFrom, targetTo);

        // subt와 pattern 일치 여부 확인
        if (pattern.equals(subt)) { // 일치한다면
            if (patterns[pIndex + 1] == null) {
                if (targetTo == target.length()) {
                    return true;
                }
            } else {
                pIndex++;
            }

            return match(target, targetTo, pIndex);
        } else { // 불일치한다면
            // 하지만 이전이 asterisk 였다면!
            if (pIndex > 0 && "*".equals(patterns[pIndex - 1])) {
                targetFrom++;
                return match(target, targetFrom, pIndex);
            }
            return false;
        }
    }

    private boolean matchAsterisk(String target, int from, int pIndex) {
        if (patterns[pIndex + 1] == null) {
            return true;
        }

        return match(target, from, ++pIndex);
    }

    private boolean matchQuestion(String target, int from, int pIndex) {
        if (patterns[pIndex + 1] == null) {
            return from + 1 == target.length();
        }

        return match(target, ++from, ++pIndex);
    }
}

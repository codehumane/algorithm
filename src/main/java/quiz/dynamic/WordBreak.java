package quiz.dynamic;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * https://leetcode.com/problems/word-break/
 * <p>
 * TODO 일단 recursion으로 구현 후 loop로 개선
 */
@Slf4j
public class WordBreak {

    public boolean wordBreak(String text, List<String> dictionary) {
        var cache = new boolean[text.length()];

        for (int i = 0; i < text.length(); i++) {
            for (String segment : dictionary) {
                var endIdx = i + segment.length() - 1;

                if (endIdx >= text.length()) continue;
                if (i > 0 && !cache[i - 1]) continue;
                if (cache[endIdx]) continue;

                cache[endIdx] = text
                        .substring(i, endIdx + 1)
                        .equals(segment);
            }
        }

        return cache[text.length() - 1];
    }
}

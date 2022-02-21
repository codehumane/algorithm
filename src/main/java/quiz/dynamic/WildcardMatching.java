package quiz.dynamic;

public class WildcardMatching {

    enum Match {
        EXACT,
        VIABLE
    }

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();

        if (text.isEmpty()) {
            return pattern
                    .chars()
                    .mapToObj(c -> (char) c)
                    .allMatch(c -> c == '*');
        }

        final var grid = new Match[text.length()][pattern.length()];
        fillGrid(text, pattern, grid);

        return matchByGrid(text, pattern, grid);
    }

    private void fillGrid(String text, String pattern, Match[][] grid) {

        int patternFrom = 0;
        int patternTo = pattern.toCharArray().length - 1;

        for (int ti = 0; ti < text.toCharArray().length; ti++) {

            int matchingFrom = patternTo;
            int matchingTo = patternFrom;

            for (int pi = patternFrom; pi <= patternTo; pi++) {
                final int rightmost = fillCell(text, pattern, grid, ti, pi);

                if (rightmost >= 0) {
                    matchingFrom = Math.min(matchingFrom, pi);
                    matchingTo = Math.max(matchingTo, rightmost);
                }
            }

            patternFrom = matchingFrom;
            patternTo = Math.min(matchingTo + 1, pattern.length() - 1);
        }
    }

    private int fillCell(String text, String pattern, Match[][] grid, int ti, int pi) {
        if ((ti == 0 && pi == 0) ||
                (ti > 0 && grid[ti - 1][pi] == Match.VIABLE) ||
                (ti > 0 && pi > 0 && grid[ti - 1][pi - 1] != null)) {

            grid[ti][pi] = match(text, pattern, ti, pi);
            return fillRightCells(text, pattern, grid, ti, pi);
        }

        return -1;
    }

    private int fillRightCells(String text, String pattern, Match[][] grid, int ti, int pi) {
        var starCnt = (grid[ti][pi] == Match.VIABLE) ? 1 : 0;
        var starIdx = pi + 1;

        while (grid[ti][starIdx - 1] != null && starIdx < pattern.length()) {
            if (pattern.charAt(starIdx) == '*') starCnt++;
            if (starCnt < starIdx - pi) break;

            grid[ti][starIdx] = match(text, pattern, ti, starIdx++);
        }

        return starIdx - 1;
    }

    private Match match(String text, String pattern, int ti, int pi) {
        if (pattern.charAt(pi) == '?' || pattern.charAt(pi) == text.charAt(ti)) return Match.EXACT;
        if (pattern.charAt(pi) == '*') return Match.VIABLE;
        return null;
    }

    private boolean matchByGrid(String text, String pattern, Match[][] grid) {
        final Match last = grid[text.length() - 1][pattern.length() - 1];
        return last == Match.EXACT || last == Match.VIABLE;
    }

}

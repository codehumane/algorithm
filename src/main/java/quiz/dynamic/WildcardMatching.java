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
        for (int ti = 0; ti < text.toCharArray().length; ti++) {
            for (int pi = 0; pi < pattern.toCharArray().length; pi++) {
                fillCell(text, pattern, grid, ti, pi);
            }
        }
    }

    private void fillCell(String text, String pattern, Match[][] grid, int ti, int pi) {
        if ((ti == 0 && pi == 0) ||
                (ti > 0 && grid[ti - 1][pi] == Match.VIABLE) ||
                (ti > 0 && pi > 0 && grid[ti - 1][pi - 1] != null)) {

            grid[ti][pi] = match(text, pattern, ti, pi);
            fillRightCells(text, pattern, grid, ti, pi);
        }
    }

    private void fillRightCells(String text, String pattern, Match[][] grid, int ti, int pi) {
        var starCnt = (grid[ti][pi] == Match.VIABLE) ? 1 : 0;
        var starIdx = pi + 1;

        while (grid[ti][starIdx - 1] != null && starIdx < pattern.length()) {
            if (pattern.charAt(starIdx) == '*') {
                starCnt++;
            }
            if (starCnt >= starIdx - pi) {
                grid[ti][starIdx] = match(text, pattern, ti, starIdx);
            }
            starIdx++;
        }
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

package quiz.tree;

/**
 * Given a list of sorted characters letters containing only lowercase letters,
 * and given a target letter target,
 * find the smallest element in the list that is larger than the given target.
 * <p>
 * Letters also wrap around.
 */
public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        if (target < letters[0] || target >= letters[letters.length - 1]) return letters[0];
        return find(letters, target, 0, letters.length - 1);
    }

    private char find(char[] letters, char target, int left, int right) {
        if (left == right) return letters[left];

        final int mid = left + (right - left) / 2;
        final char letter = letters[mid];

        if (letter > target) return find(letters, target, left, mid);
        else return find(letters, target, mid + 1, right);
    }

}

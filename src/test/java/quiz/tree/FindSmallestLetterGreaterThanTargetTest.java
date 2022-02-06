package quiz.tree;

import org.junit.jupiter.api.Test;
import quiz.tree.FindSmallestLetterGreaterThanTarget;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindSmallestLetterGreaterThanTargetTest {

    private final FindSmallestLetterGreaterThanTarget finder = new FindSmallestLetterGreaterThanTarget();

    @Test
    public void examples() {
        final char[] letters = {'c', 'f', 'j'};
        assertEquals('c', finder.nextGreatestLetter(letters, 'a'));
        assertEquals('f', finder.nextGreatestLetter(letters, 'c'));
        assertEquals('f', finder.nextGreatestLetter(letters, 'd'));
        assertEquals('j', finder.nextGreatestLetter(letters, 'f'));
        assertEquals('j', finder.nextGreatestLetter(letters, 'g'));
        assertEquals('c', finder.nextGreatestLetter(letters, 'j'));
        assertEquals('c', finder.nextGreatestLetter(letters, 'k'));
    }

}
package quiz.etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WildcardTest {

    @Test
    public void match_와일드카드나_물음표_없는_경우() throws Exception {
        // Given
        Wildcard wildcard = new Wildcard("help");

        // Then
        Assertions.assertTrue(wildcard.match("help"));
        Assertions.assertFalse(wildcard.match("help1"));
        Assertions.assertFalse(wildcard.match("helt"));
        Assertions.assertFalse(wildcard.match("hep"));
    }

    @Test
    public void match_물음표_있는_경우() throws Exception {
        // Given
        Wildcard wildcard = new Wildcard("he?p");

        // Then
        Assertions.assertTrue(wildcard.match("help"));
        Assertions.assertFalse(wildcard.match("help1"));
        Assertions.assertFalse(wildcard.match("heltp"));
        Assertions.assertFalse(wildcard.match("hep"));
    }

    @Test
    public void match_와일드카드_있는_경우_첫번째() throws Exception {
        // Given
        Wildcard wildcard = new Wildcard("he*p");

        // Then
        Assertions.assertTrue(wildcard.match("help"));
        Assertions.assertFalse(wildcard.match("help1"));
        Assertions.assertTrue(wildcard.match("heltp"));
        Assertions.assertTrue(wildcard.match("heltap"));
        Assertions.assertTrue(wildcard.match("hep"));
    }

    @Test
    public void match_와일드카드_있는_경우_두번째() throws Exception {
        // Given
        Wildcard wildcard = new Wildcard("he*p*p");

        // Then
        Assertions.assertTrue(wildcard.match("helpap"));
        Assertions.assertTrue(wildcard.match("helpappp"));
        Assertions.assertTrue(wildcard.match("helplplp"));
        Assertions.assertTrue(wildcard.match("helpaplp"));
        Assertions.assertTrue(wildcard.match("helplpap"));
        Assertions.assertFalse(wildcard.match("heltp"));
        Assertions.assertTrue(wildcard.match("hepp"));
    }

    @Test
    public void match_algospot_input() throws Exception {
        Wildcard wildcard = new Wildcard("*p*");
        Assertions.assertTrue(wildcard.match("help"));
        Assertions.assertTrue(wildcard.match("papa"));
        Assertions.assertFalse(wildcard.match("hello"));

        wildcard = new Wildcard("*bb*");
        Assertions.assertTrue(wildcard.match("babbbc"));
    }
}
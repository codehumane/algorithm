package quiz;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class WildcardTest {

    @Test
    public void match_와일드카드나_물음표_없는_경우() throws Exception {
        // Given
        Wildcard wildcard = new Wildcard("help");

        // Then
        Assert.assertTrue(wildcard.match("help"));
        Assert.assertFalse(wildcard.match("help1"));
        Assert.assertFalse(wildcard.match("helt"));
        Assert.assertFalse(wildcard.match("hep"));
    }

    @Test
    public void match_물음표_있는_경우() throws Exception {
        // Given
        Wildcard wildcard = new Wildcard("he?p");

        // Then
        Assert.assertTrue(wildcard.match("help"));
        Assert.assertFalse(wildcard.match("help1"));
        Assert.assertFalse(wildcard.match("heltp"));
        Assert.assertFalse(wildcard.match("hep"));
    }

    @Test
    public void match_와일드카드_있는_경우_첫번째() throws Exception {
        // Given
        Wildcard wildcard = new Wildcard("he*p");

        // Then
        Assert.assertTrue(wildcard.match("help"));
        Assert.assertFalse(wildcard.match("help1"));
        Assert.assertTrue(wildcard.match("heltp"));
        Assert.assertTrue(wildcard.match("heltap"));
        Assert.assertTrue(wildcard.match("hep"));
    }

    @Test
    public void match_와일드카드_있는_경우_두번째() throws Exception {
        // Given
        Wildcard wildcard = new Wildcard("he*p*p");

        // Then
        Assert.assertTrue(wildcard.match("helpap"));
        Assert.assertTrue(wildcard.match("helpappp"));
        Assert.assertTrue(wildcard.match("helplplp"));
        Assert.assertTrue(wildcard.match("helpaplp"));
        Assert.assertTrue(wildcard.match("helplpap"));
        Assert.assertFalse(wildcard.match("heltp"));
        Assert.assertTrue(wildcard.match("hepp"));
    }

    @Test
    public void match_algospot_input() throws Exception {
        Wildcard wildcard = new Wildcard("*p*");
        Assert.assertTrue(wildcard.match("help"));
        Assert.assertTrue(wildcard.match("papa"));
        Assert.assertFalse(wildcard.match("hello"));

        wildcard = new Wildcard("*bb*");
        Assert.assertTrue(wildcard.match("babbbc"));
    }
}
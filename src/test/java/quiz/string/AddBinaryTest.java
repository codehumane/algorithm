package quiz.string;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddBinaryTest {

    private final AddBinary adder = new AddBinary();

    @Test
    public void example1() {

        val a = "11";
        val b = "1";
        val expected = "100";
        val result = adder.addBinary(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void example2() {

        val a = "1010";
        val b = "1011";
        val expected = "10101";
        val result = adder.addBinary(a, b);

        assertEquals(expected, result);
    }


}
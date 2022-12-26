package quiz.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZigZagConversionTest {

    private final ZigZagConversion solution = new ZigZagConversion();

    @Test
    void examples() {
        assertEquals("PAHNAPLSIIGYIR", solution.convert("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", solution.convert("PAYPALISHIRING", 4));
        assertEquals("A", solution.convert("A", 1));
    }

    @Test
    void customs() {
        assertEquals("1234567890ABCDEFGHIJKLMNO", solution.convert("1234567890ABCDEFGHIJKLMNO", 1));
        assertEquals("13579ACEGIKMO24680BDFHJLN", solution.convert("1234567890ABCDEFGHIJKLMNO", 2));
        assertEquals("159CG24680BDF37AE", solution.convert("1234567890ABCDEFG", 3));
        assertEquals("1CO2BDN3AEM40FL59GK68HJ7I", solution.convert("1234567890ABCDEFGHIJKLMNO", 7));
    }

    @Test
    void wrong() {
        assertEquals("A", solution.convert("A", 2));
    }

}
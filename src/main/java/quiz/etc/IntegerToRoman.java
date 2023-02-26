package quiz.etc;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;

/**
 * <br/>
 * Symbol       Value   <br/>
 * I             1      <br/>
 * V             5      <br/>
 * X             10     <br/>
 * L             50     <br/>
 * C             100    <br/>
 * D             500    <br/>
 * M             1000   <br/>
 * <br/>
 * # subtraction<br/>
 * - I can be placed before V (5) and X (10) to make 4 and 9.<br/>
 * - X can be placed before L (50) and C (100) to make 40 and 90.<br/>
 * - C can be placed before D (500) and M (1000) to make 400 and 900.<br/>
 * <br/>
 * # constraints<br/>
 * - 1 <= num <= 3999
 */
@Slf4j
public class IntegerToRoman {

    static final LinkedHashMap<String, Integer> symbols;
    static final LinkedHashMap<String, String> subtractions;

    static {
        symbols = new LinkedHashMap<>();
        symbols.put("M", 1000);
        symbols.put("D", 500);
        symbols.put("C", 100);
        symbols.put("L", 50);
        symbols.put("X", 10);
        symbols.put("V", 5);
        symbols.put("I", 1);
    }

    static {
        subtractions = new LinkedHashMap<>();
        subtractions.put("DCCCC", "CM");
        subtractions.put("CCCC", "CD");
        subtractions.put("LXXXX", "XC");
        subtractions.put("XXXX", "XL");
        subtractions.put("VIIII", "IX");
        subtractions.put("IIII", "IV");
    }

    public String intToRoman(int num) {
        assert 1 <= num && num <= 3_999;

        var roman = new StringBuilder();
        for (String symbol : symbols.keySet()) {
            num = append(num, roman, symbol);
        }

        return roman.toString();
    }

    private int append(int num, StringBuilder roman, String symbol) {
        var count = num / symbols.get(symbol);
        var left = num % symbols.get(symbol);

        while (count-- > 0) {
            roman.append(symbol);
        }

        subtract(roman);
        return left;
    }

    private void subtract(StringBuilder roman) {
        for (String key : subtractions.keySet()) {
            if (roman.length() < key.length()) continue;

            var start = roman.length() - key.length();
            var target = roman.substring(start);

            if (target.equals(key)) {
                roman.replace(start, roman.length(), subtractions.get(key));
            }
        }
    }

}

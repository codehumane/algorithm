package quiz.string;

import lombok.extern.slf4j.Slf4j;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
@Slf4j
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        var zigzag = new StringBuilder(s.length());
        for (int row = 1; row <= numRows; row++) {

            var index = row;
            append(s, index, zigzag);

            while (index <= s.length()) {

                if (numRows > row) {
                    index += (numRows - row) * 2;
                    append(s, index, zigzag);
                }

                if (row > 1) {
                    index += (row - 1) * 2;
                    append(s, index, zigzag);
                }
            }
        }

        return zigzag.toString();
    }

    private void append(String s, int index, StringBuilder zigzag) {
        if (index <= s.length()) {
            zigzag.append(s.charAt(index - 1));
        }
    }

}

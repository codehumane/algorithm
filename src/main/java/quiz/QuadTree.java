package quiz;

/**
 * 쿼드트리 소개(한글): https://algospot.com/judge/problem/read/QUADTREE
 */
public class QuadTree {

    private static final char WHITE = 'w';
    private static final char BLACK = 'b';
    private static final char MIXED = 'x';

    public String reverseVertically(String input) {
        char[] chars = input.toCharArray();
        if (chars.length == 1) {
            return input;
        }

        char[] temp = new char[chars.length];
        reverse(chars, temp, 0);
        return String.valueOf(chars);
    }

    // ...before...
    // x[bwx[wbbw]b]
    // x=>
    //     bw
    //     xb
    //     x=>
    //        wb
    //        bw

    // ...after...
    // x[x[bwwb]bbw]
    // x=>
    //    xb
    //    bw
    //    x=>
    //       bw
    //       wb
    private int reverse(char[] chars, char[] temp, int index) {
        if (chars[index] != MIXED) {
            return index + 1;
        }

        int upLeftIdx = index + 1;
        int upRightIdx = reverse(chars, temp, upLeftIdx);
        int downLeftIdx = reverse(chars, temp, upRightIdx);
        int downRightIdx = reverse(chars, temp, downLeftIdx);
        int nextUpLeftIdx = reverse(chars, temp, downRightIdx);
        swapUpDown(chars, temp, upLeftIdx, downLeftIdx, nextUpLeftIdx);

        return nextUpLeftIdx;
    }

    private void swapUpDown(char[] chars, char[] temp, int start, int third, int nextStart) {
        for (int i = start; i < nextStart; i++) {
            temp[i] = chars[i];
        }

        int idx = start;
        for (int i = third; i < nextStart; i++) {
            chars[idx++] = temp[i];
        }
        for (int i = start; i < third; i++) {
            chars[idx++] = temp[i];
        }
    }

}

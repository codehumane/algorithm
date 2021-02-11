package quiz;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * https://www.acmicpc.net/problem/12100
 * <p><br/>
 * input<br/>
 * 3<br/>
 * 2 2 2<br/>
 * 4 4 4<br/>
 * 8 8 8<br/>
 * <p><br/>
 * output<br/>
 * 16<br/>
 */
public class TwoZeroFourEight {

    public static void main(String[] args) {
        final int[][] input = scanInput();
        final int output = play(input);
        System.out.println(output);
    }

    private static int[][] scanInput() {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int[][] input = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                input[i][j] = scanner.nextInt();
            }
        }

        return input;
    }

    public static int play(int[][] input) {
        return play(input, 0);
    }

    private static int play(int[][] input, int count) {
        if (count == 5) { // 5번 수행 완료
            return Arrays
                    .stream(input)
                    .flatMapToInt(Arrays::stream)
                    .max()
                    .orElseThrow(IllegalStateException::new);
        }

        final int up = play(up(input), count + 1);
        final int right = play(right(input), count + 1);
        final int down = play(down(input), count + 1);
        final int left = play(left(input), count + 1);

        return Stream
                .of(up, right, down, left)
                .max(Integer::compareTo)
                .orElseThrow(IllegalStateException::new);
    }

    static int[][] up(int[][] input) {
        int[][] copy = copy(input);

        // 왼쪽 -> 오른쪽
        for (int i = 0; i < copy.length; i++) {
            int up = 0;
            int move = 1;

            // 위 -> 아래
            while (move < copy.length) {
                final int upValue = copy[up][i];
                final int moveValue = copy[move][i];

                if (moveValue != 0) {
                    copy[move][i] = 0;

                    if (upValue == 0) copy[up][i] = moveValue;
                    else if (upValue == moveValue) copy[up++][i] *= 2;
                    else copy[++up][i] = moveValue;
                }

                move++;
            }
        }

        return copy;
    }

    static int[][] right(int[][] input) {
        int[][] copy = copy(input);

        for (int i = 0; i < copy.length; i++) {
            int right = copy.length - 1;
            int move = right - 1;

            while (move >= 0) {
                final int rightValue = copy[i][right];
                final int moveValue = copy[i][move];

                if (moveValue != 0) {
                    copy[i][move] = 0;

                    if (rightValue == 0) copy[i][right] = moveValue;
                    else if (rightValue == moveValue) copy[i][right--] *= 2;
                    else copy[i][--right] = moveValue;
                }

                move--;
            }
        }

        return copy;
    }

    static int[][] down(int[][] input) {
        int[][] copy = copy(input);

        for (int i = 0; i < copy.length; i++) {
            int down = copy.length - 1;
            int move = down - 1;

            while (move >= 0) {
                final int downValue = copy[down][i];
                final int moveValue = copy[move][i];

                if (moveValue != 0) {
                    copy[move][i] = 0;

                    if (downValue == 0) copy[down][i] = moveValue;
                    else if (downValue == moveValue) copy[down--][i] *= 2;
                    else copy[--down][i] = moveValue;
                }

                move--;
            }
        }

        return copy;
    }

    static int[][] left(int[][] input) {
        int[][] copy = copy(input);

        for (int i = 0; i < copy.length; i++) {
            int left = 0;
            int move = left + 1;

            while (move < copy.length) {
                final int leftValue = copy[i][left];
                final int moveValue = copy[i][move];

                if (moveValue != 0) {
                    copy[i][move] = 0;

                    if (leftValue == 0) copy[i][left] = moveValue;
                    else if (leftValue == moveValue) copy[i][left++] *= 2;
                    else copy[i][++left] = moveValue;
                }

                move++;
            }
        }

        return copy;
    }

    private static int[][] copy(int[][] source) {
        final int[][] result = new int[source.length][source.length];

        for (int i = 0; i < source.length; i++)
            System.arraycopy(source[i], 0, result[i], 0, source[i].length);

        return result;
    }
}

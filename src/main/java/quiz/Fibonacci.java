package quiz;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Fibonacci {

    public int[] run(int input) {
        int[] numbers = new int[input];
        fillNumbers(input, numbers);
        return numbers;
    }

    private void fillNumbers(int input, int[] numbers) {
        if (input == 1 || input == 2) {
            numbers[input - 1] = 1;
            if (input == 2) {
                numbers[input - 2] = 1;
            }

            return;
        }

        fillNumbers(input - 1, numbers);
        numbers[input - 1] = numbers[input - 2] + numbers[input - 3];
    }
}

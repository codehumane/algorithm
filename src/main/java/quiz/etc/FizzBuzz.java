package quiz.etc;

public class FizzBuzz {

    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";

    public String convert(int input) {
        StringBuilder sb = new StringBuilder();
        for (int i=1; i <= input; i++) {
            convertEach(i, sb);
        }

        return sb.toString();
    }

    private void convertEach(int number, StringBuilder sb) {
        boolean converted = false;
        if (isFizz(number)) {
            converted = true;
            sb.append(FIZZ);
        }

        if (isBuzz(number)) {
            converted = true;
            sb.append(BUZZ);
        }

        if (!converted) {
            sb.append(String.valueOf(number));
        }
    }

    private boolean isFizz(int input) {
        return input % 3 == 0;
    }

    private boolean isBuzz(int input) {
        return input % 5 == 0;
    }
}

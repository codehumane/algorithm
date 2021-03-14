package quiz.string;

/**
 * Given two binary strings a and b,
 * return their sum as a binary string.
 */
public class AddBinary {

    public String addBinary(String a, String b) {

        final StringBuilder builder = new StringBuilder();
        final State state = new State(a.length() - 1, b.length() - 1);

        while (state.aIndex >= 0 || state.bIndex >= 0) {
            builder.append(addChars(a, b, state));
            state.aIndex--;
            state.bIndex--;
        }

        if (state.overflow) builder.append('1');

        return builder
                .reverse()
                .toString();
    }

    private String addChars(String a, String b, State state) {

        int calculator = 0;
        if (state.aIndex >= 0 && a.charAt(state.aIndex) == '1') calculator++;
        if (state.bIndex >= 0 && b.charAt(state.bIndex) == '1') calculator++;
        if (state.overflow) calculator++;

        state.overflow = calculator >= 2;
        return String.valueOf(calculator % 2);
    }

    static class State {
        int aIndex;
        int bIndex;
        boolean overflow;

        State(int aIndex, int bIndex) {
            this.aIndex = aIndex;
            this.bIndex = bIndex;
        }
    }

}

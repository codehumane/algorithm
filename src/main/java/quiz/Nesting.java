package quiz;

class Nesting {

    int solution(String S) {

        int openCount = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                openCount++;
                continue;
            }

            if (openCount-- == 0) {
                break;
            }
        }

        return openCount == 0 ? 1 : 0;
    }
}

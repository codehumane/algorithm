package quiz.tree;

/**
 * 1 <= bad <= n <= 2^31 - 1
 * <p>
 * OOOOX
 * OOOXX
 * OOXXX
 * OXXXX
 * XXXXX
 */
public class FirstBadVersion extends VersionControl {

    public FirstBadVersion(int firstBadVersion) {
        super(firstBadVersion);
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            final int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) right = mid; // `mid`가 첫 번째 bad version 일 수도 아닐 수도 있으므로 mid 포함하여 다시 검사
            else left = mid + 1;
        }

        return left;
    }

}

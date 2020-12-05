package data.tree;

/**
 * 1 <= bad <= n <= 2^31 - 1
 */
public class FirstBadVersion extends VersionControl {

    public FirstBadVersion(int firstBadVersion) {
        super(firstBadVersion);
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            final int mid = left + (right - left) / 2;
            if (isBadVersion(mid) && !isBadVersion(mid - 1)) return mid;
            if (isBadVersion(mid) && isBadVersion(mid - 1)) right = mid - 1;
            else left = mid + 1;
        }

        throw new IllegalStateException();
    }

}

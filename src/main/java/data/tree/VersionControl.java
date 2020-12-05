package data.tree;

public class VersionControl {

    private final int firstBadVersion;

    public VersionControl(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    protected boolean isBadVersion(int version) {
        return firstBadVersion <= version;
    }
}

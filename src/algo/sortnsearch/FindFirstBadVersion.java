package algo.sortnsearch;

/**
 *
 * Lesson: to find mid, use begin + (end-begin)/2 instead of (begin+end)/2 to avoid overflow of int range.
 * <p>
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * </p>
 * <p>
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * </p>
 */
public class FindFirstBadVersion {

    private static int badVersion;

    public static void main(String[] args) {
        int[] inputs = {5, 2126753390};
        int[] badVersions = {4, 1702766719};
        for (int i=0; i<inputs.length; i++) {
            badVersion = badVersions[i];
            System.out.println("Expected: " + badVersions[i] + ", Actual: " + firstBadVersion(inputs[i]) + ", Passed: " + (badVersions[i] == firstBadVersion(inputs[i])));
        }
    }

    public static boolean isBadVersion(int n) {
        return n >= badVersion;
    }

    public static int firstBadVersion(int n) {
        return search(1, n);
    }

    public static int search(int start, int end) {
        // binary search but to find the first occurrence
        if (start == end) return start;
        int m = start + (end-start)/2;
        if (isBadVersion(m)) {
            return search(start, m);
        } else {
            return search(m + 1, end);
        }
    }
}

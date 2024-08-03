package algo.strings;

/*

Lesson:
Compare strstr and strstrbrudeforce methods and see the optimizations.

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.


Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.

 */

public class FindSubstring {

    public static void main(String[] args) {
        String[][] inputs = {
                {"sadbutsad", "sad"},
                {"leetcode", "leeto"},
                {"a", "a"},
                {"a", "b"},
                {"a", "aa"},
                {"aa", "a"},
                {"shyamsuthar", "suthar"},
                {"shyamsuthar", "msut"}
        };
        int[] expected = {0, -1, 0, -1, -1, 0, 5, 4};
        for (int i = 0; i < inputs.length; i++) {
            int result = strStr(inputs[i][0], inputs[i][1]);
            System.out.println("Input: " + inputs[i][0] + " " + inputs[i][1] + " Expected: " + expected[i] + " Result: " + result + " Pass: " + (expected[i] == result));
            int result1 = strStrBruteforce(inputs[i][0], inputs[i][1]);
            System.out.println("Input: " + inputs[i][0] + " " + inputs[i][1] + " Expected: " + expected[i] + " Result: " + result1 + " Bruteforce Pass: " + (expected[i] == result1));
        }
    }

    public static int strStr(String haystack, String needle) {
        int lh = haystack.length(), ln = needle.length();
        if (lh < ln) {
            return -1;
        }
        // just need to iterate till lh-ln because if needle is not found in haystack till lh-ln, it will not be found in haystack after lh-ln
        for (int i=0; i <= lh-ln; i++) {
            int j = 0;
            // comparison condition in the loop itself
            while( j < ln && haystack.charAt(i+j) == needle.charAt(j)) {
                j++;
            }
            if (j == ln) {
                return i;
            }
        }
        return -1;
    }

    public static int strStrBruteforce(String haystack, String needle) {
        int lh = haystack.length(), ln = needle.length();
        if (lh < ln) {
            return -1;
        }

        // mine
        int i=0;
        while (i < lh) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int x = i+1, y = 1;
                while (x < lh && y < ln) {
                    if (haystack.charAt(x) != needle.charAt(y)) {
                        break;
                    }
                    x++;
                    y++;
                }
                if (y == ln) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

}

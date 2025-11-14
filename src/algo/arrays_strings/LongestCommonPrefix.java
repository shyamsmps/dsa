package algo.arrays_strings;

/*

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.

 */

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[][] inputs = {
                {"flower", "flow", "flight"},
                {"dog", "racecar", "car"},
                {"a"},
                {"ab", "a"},
                {"a", "ab"},
                {"", "a"},
                {"a", ""},
                {"", ""}
        };

        String[] expected = {"fl", "", "a", "a", "", "", "", ""};

        for (int i = 0; i < inputs.length; i++) {
            String result = longestCommonPrefix(inputs[i]);
            System.out.println("Input: " + Arrays.toString(inputs[i]) + " Expected: " + expected[i] + " Result: " + result + " Pass: " + expected[i].equals(result));
        }
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder s = new StringBuilder();
        for (int x = 0; x < strs[0].length(); x++) {
            char c = strs[0].charAt(x);
            for (int y = 1; y < strs.length; y++) {
                if (strs[y].length() <= x || strs[y].charAt(x) != c) {
                    return s.toString();
                }
            }
            s.append(c);
        }
        return s.toString();
    }
}

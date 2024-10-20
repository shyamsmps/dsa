package algo.arrays;

import java.util.Arrays;

/**
 Write a function to find the longest common prefix string amongst an array of strings.
 If there is no common prefix, return an empty string "".
 Example 1:
 Input: strs = ["flower","flow","flight"]
 Output: "fl"
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String arr1[] = {"flower","flow","flight"};
        String arr2[] = {"dog","racecar","car"};
        String arr3[] = {"car"};
        String arr4[] = {"car", "car", "carrrr"};
        String arr[][] = {arr1, arr2, arr3, arr4};
        for (int i=0; i<arr.length; i++) {
            System.out.println(String.join(", ", arr[i]) + " : " + longestCommonPrefixV1(arr[i]));
            System.out.println(String.join(", ", arr[i]) + " : " + longestCommonPrefixV2(arr[i]));
        }

    }

    public static String longestCommonPrefixV1(String[] strs) {
        String common = "";
        if (strs.length > 0) {
            for (int i=0; i<strs[0].length(); i++) {
                char c = strs[0].charAt(i);
                for (int j=1; j<strs.length; j++) {
                    if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                        return common;
                    }
                }
                common+=c;

            }
        }
        return common;
    }

    public static String longestCommonPrefixV2(String[] strs) {
        int len = strs.length;
        if (len < 1) {
            return "";
        }
        if (len == 1) {
            return strs[0];
        }
        Arrays.sort(strs);
        String common = "";
        for (int i=0; i<strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            if (c != strs[len-1].charAt(i)) {
                break;
            } else {
                common+=c;
            }
        }
        return common;

    }

}

package algo.dp;

import java.util.*;

/**
 Given two strings, s1 and s2, write a function that finds and returns the length of the longest substring of s2 and s1 (if any exist).
 */
public class LongestCommonSubstring {

    public static void main(String[] args) {
        String[][] entries = {
                {"educative.io/expl", "educative.io/edpr", "educative.io/e"},
                {"EducativeIsFun", "AlgorithmsAreFun", "Fun"},
                {"abcd1234", "efgh567", ""},
                {"aaabbababc", "aababacab", "baba"},
                {"shyam", "suthar", "s"}
        };

        for (int i=0; i<entries.length; i++) {
            String s1 = entries[i][0];
            String s2 = entries[i][1];
            String expectedOutput = entries[i][2];
            System.out.println("["+s1+","+s2+"]. Expected: " + expectedOutput.length() + ", Actual: " + LCSLengthTabulationBottomUp(s1, s2));
//            System.out.println("["+s1+","+s2+"]. Expected: " + expectedOutput.length() + ", Actual: " + LCSLengthBruteForceSelf(s1, s2));
//            System.out.println("["+s1+","+s2+"]. Expected: " + expectedOutput.length() + ", Actual: " + LCSLengthRecursive(s1, s2));
        }
    }

    /**#########################################################################################################################################**/

    public static int LCSLengthTabulationBottomUp(String s1, String s2) {
        int max = 0;

        // look up table to store length of common substring where last letters are ith in s1 and jth in s2
        // space can be utilized because only one previous row is needed to find the optimal solution!
        int[][] lookUpTable = new int[s1.length()+1][s2.length()+1];

        for (int i=1; i<=s1.length(); i++) {
            for(int j=1; j<=s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    lookUpTable[i][j] = lookUpTable[i-1][j-1] + 1;
                    max = Math.max(max, lookUpTable[i][j]);
                }
            }
        }

        return max;
    }

    /**#########################################################################################################################################**/

    public static int LCSLengthRecursive(String s1, String s2) {
        return LCSLengthRecursiveInternal(s1, s2, 0, 0, 0);
    }
    public static int LCSLengthRecursiveInternal(String s1, String s2, int i1, int i2, int count) {
        // a look up table can be used to store recursive call results .
        // int [][][] lookupTable = new int [size1][][]; and lookupTable[i1][i2][count] = Math.max(c1, Math.max(c2, c3));
        if (i1 == s1.length() || i2 == s2.length())
            return count;
        if (s1.charAt(i1) == s2.charAt(i2))
            count= LCSLengthRecursiveInternal(s1, s2, i1+1, i2+1, count+1);
        int l1 = LCSLengthRecursiveInternal(s1, s2, i1+1, i2, 0);
        int l2 = LCSLengthRecursiveInternal(s1, s2, i1, i2+1, 0);
        return Math.max(count, Math.max(l1, l2));
    }

    /**#########################################################################################################################################**/

    public static int LCSLengthBruteForceSelf(String s1, String s2) {

        // create a map of first string's characters and indexes. Ex. {a: [0,2,3]}, {b: [4,6]} in acaabcb
        int maxLength = 0;
        Map<Character, List<Integer>> map1 = new HashMap<>();
        for (int i=0; i<s1.length(); i++) {
            char c = s1.charAt(i);
            if (map1.get(c) == null) {
                map1.put(c, new ArrayList<>());
            }
            map1.get(c).add(i);
        }

        for (int i=0; i<s2.length(); i++) {
            List<Integer> s1Indexes = map1.get(s2.charAt(i));
            if (s1Indexes != null && s1Indexes.size()>0) {
                // character found in other string. find common length starting from each entry in map
                for (Integer x : s1Indexes) {
                    // skip if common string can not be formed with length longer than current maxLength
                    if(x+maxLength < s1.length() && i+maxLength < s2.length() && s1.charAt(x+maxLength) == s2.charAt(i+maxLength)) {
                        int y = i, temp = 0;
                        while(x<s1.length() && y<s2.length() && s1.charAt(x++) == s2.charAt(y++)) {
                            temp++;
                        }
//                        System.out.println(s2.substring(i,i+temp));
                        maxLength = Math.max(maxLength, temp);
                    }
                }
            }
        }
        return maxLength;
    }


}
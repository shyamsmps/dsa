package algo.dp;

/**
 Given two strings, write a function to find the length of their shortest common superstring. A superstring is a string that has both input strings as substrings.
 abcf and bdcf. output: abdcf
 abcd and aabbce. output: aabbcde
 */
public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        String[][] entries = {
                {"abcf", "bdcff", "abdcff"},
                {"abcd", "aabbce", "aabbcde"},
                {"", "test", "test"},
                {"EducativeIsFun", "AlgorithmsAreFun", "EducaAlgortithmveIsAreFun"},
                {"www.educative.io/explore", "educative.io/edpresso", "www.educative.io/exdploresso"},
                {"abcf", "bfcafabcf", "bfcafabcf"}
        };

        for (int i=0; i<entries.length; i++) {
            String s1 = entries[i][0];
            String s2 = entries[i][1];
            String expectedOutput = entries[i][2];
            System.out.println(s1+" and "+s2);
            System.out.println("Expected: " + expectedOutput.length() + ", Actual: " + findSCSLengthRecursive(s1, s2));
            System.out.println("-------------------------------------------------------------------------------------");
        }
    }


    /**#########################################################################################################################################**/


    public static int findSCSLengthRecursive(String s1, String s2) {
        int lookUpTable[][] = new int[s1.length()][s2.length()];
        return findSCSLengthRecursiveInternal(lookUpTable, s1, s2, 0, 0);
    }

    /**
     * i1 and i2 are indexes to process for strings 1 and 2
     */
    public static int findSCSLengthRecursiveInternal(int[][] lookupTable, String s1, String s2, int i1, int i2) {
        if (i1 == s1.length())
            return s2.length() - i2;
        if (i2 == s2.length())
            return s1.length() - i1;
        if (lookupTable[i1][i2] == 0) {
            //if sequences have a matching character
            if (s1.charAt(i1) == s2.charAt(i2))
                lookupTable[i1][i2] = 1 + findSCSLengthRecursiveInternal(lookupTable, s1, s2, i1 + 1, i2 + 1);
            else {
                //if matching character not found
                int length1 = 1 + findSCSLengthRecursiveInternal(lookupTable, s1, s2, i1, i2 + 1);
                int length2 = 1 + findSCSLengthRecursiveInternal(lookupTable, s1, s2, i1 + 1, i2);
                //store minimum of the two in lookupTable
                lookupTable[i1][i2] = Math.min(length1, length2);
            }
        }
        return lookupTable[i1][i2];
    }

    /**#########################################################################################################################################**/


    /**
     * In the tabulation approach, we calculate the smaller values and build larger values from them.
     *
     * We create a lookup table of size (m+1)\times (n+1) = (m+1)×(n+1), whgere m and n are the lengths of the given strings.
     *
     * If one of the strings is of zero length, then the shortest common supersequence (SCS) would be equal to the length of the other string.
     * Therefore, we set the values for such subproblems in the lookupTable beforehand.
     *
     * Next, we iterate through both strings in a nested for loop and check if any of the two conditions are true:
     *
     * If the character str1[i-1] matches str2[j-1], meaning the ending characters are the same.
     * Then, the length of the SCS would be 1 plus the length of the SCS until i-1 and j-1 indexes in the two strings.
     *
     * If the character str[i-1] does not match str2[j-1], we consider two SCS:
     * one excluding a character from str1 and one excluding a character from str2.
     * Our required SCS length is the shortest of these two super sequences plus one.
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int findSCSLengthTabulation(String str1, String str2) {
        int s1 = str1.length(), s2 = str2.length();
        int[][] lookupTable = new int[s1 + 1][];
        //initializing the lookupTable
        for (int i = 0; i < s1 + 1; i++) {
            lookupTable[i] = new int[s2 + 1];
            for (int j = 0; j < s2 + 1; j++)
                lookupTable[i][j] = 0;
        }
        // if one of the strings is of zero length, Shortest common supersequence(SCS)
        // would be equal to the length of the other string
        for (int i = 0; i <= s1; i++)
            lookupTable[i][0] = i;
        for (int j = 0; j <= s2; j++)
            lookupTable[0][j] = j;

        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                //if sequences have a matching end character
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    lookupTable[i][j] = 1 + lookupTable[i - 1][j - 1];
                else
                    //if matching end character not found, take minimum of including one character either from string 1 or string 2
                    lookupTable[i][j] = 1 + Math.min(lookupTable[i - 1][j], lookupTable[i][j - 1]);
            }
        }
        return lookupTable[s1][s2];
    }

    /**#########################################################################################################################################**/

    // this method will not maintain the sequence. self try 1.
    public static int superSequenceLengthNoSequenceMaintained(String s1, String s2) {

        /**
         * shorter string cab be stored here to save some space
         * the idea is, compare each char of S1 with all chars of S2 and count the number of chars from S1 that are not found in S2 (s1CharactersNotFoundInS2).
         * but for S1: aab, S2: ab; a in S2 is already found common once, so we need to skip this char in next iteration.
         * hence, a table is maintained for all S2 chars (s2CharactersFoundInS1) and set those indexes to true which are already compared equal. skip these next time when equal comparision is made.
         * if a char from S1 is not found in S2, we increment the counter.
         * in the end, we know which all chars from S1 are missing in S2. simply add this number with length of S1.
         */
        int s1CharactersNotFoundInS2 = 0;
        boolean[] s2CharactersFoundInS1 = new boolean[s2.length()];

        for (int i=0; i<s1.length(); i++) {
            boolean s1CharFoundInS2 = false;
            for(int j=0; j<s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j) && !s2CharactersFoundInS1[j]) {
                    s2CharactersFoundInS1[j] = true;
                    s1CharFoundInS2 = true;
                    break;
                }
            }
            if (!s1CharFoundInS2) {
                s1CharactersNotFoundInS2++;
            }
        }

        return s1CharactersNotFoundInS2 + s2.length();
    }


}
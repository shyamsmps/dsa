package algo.dp;

import algo.util.Util;

/**
 * Given a string, find the length of its longest palindromic subsequence.
 * In a palindromic subsequence, elements read the same backward and forward.
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements
 */
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String[][] entries = {
                {"abdbca", "abdba"},
                {"cddpd", "dpd"},
                {"pqr", "r"},
                {"abbbafa", "abbba"}
        };

        for (int i=0; i<entries.length; i++) {
            String s = entries[i][0];
            String expectedOutput = entries[i][1];
            System.out.println(s + ". Expected: " + expectedOutput.length() + ", Actual: " + LPSLength(s));
            System.out.println("---------------------------------------------------------------------------------");
        }
    }

    public static int LPSRecursive(String st) {
        return LPSRecursiveInternal(st, 0, st.length()-1);
    }
    // a lookup table can be used to save results for already executed calls of p1 and p2
    public static int LPSRecursiveInternal(String s, int p1, int p2) {
        if (p1>p2)
            return 0;
        if (p1==p2)
            return 1;
        if (s.charAt(p1) == s.charAt(p2)) {
            return 2 + LPSRecursiveInternal(s, p1+1, p2-1);
        } else {
            int l1 = LPSRecursiveInternal(s, p1+1, p2);
            int l2 = LPSRecursiveInternal(s, p1, p2-1);
            return Math.max(l1, l2);
        }
    }

    /**
     * We start from the beginning of the sequence and keep adding one element at a time.
     * At every step, we try all of its subsequences.
     * We choose one of the following two options for every startIndex and endIndex in the given string:
     *
     * For every element of length 1, we already set the value in the lookupTable as 1.
     *
     * If the element at the startIndex matches the element at the endIndex,
     * the length of the longest palindromic subsequence would be two plus the length of longest palindromic
     * till startIndex+1 and endIndex-1.
     *
     * If the element at the startIndex does not match the element at the endIndex,
     * we return the maximum longest palindromic subsequence created by
     * either skipping an element at the startIndex or at the endIndex.
     *
     * look at the printed table to understand better.
     */
    public static int LPSLength(String st)
    {
        int size = st.length();
        // Initializing a lookup table of dimensions size * size
        int [][] lookupTable;
        lookupTable = new int [size][];
        for (int i = 0; i < size; i++) {
            lookupTable[i] = new int[size];
            for (int j = 0; j < size; j++)
                lookupTable[i][j] = 0;
        }
        // every sequence with one element is a palindrome of length 1
        for (int i = 0; i < size; i++)
            lookupTable[i][i] = 1;

        printLookUpTable(lookupTable);

        for (int startIndex = size - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < size; endIndex++)
            {
                // case 1: elements at the beginning and the end are the same
                if (st.charAt(startIndex) == st.charAt(endIndex))
                    lookupTable[startIndex][endIndex] = 2 + lookupTable[startIndex + 1][endIndex - 1];
                else // case 2: skip one element either from the beginning or the end
                    lookupTable[startIndex][endIndex] = Math.max(lookupTable[startIndex + 1][endIndex], lookupTable[startIndex][endIndex - 1]);
            }
            printLookUpTable(lookupTable);
        }
        return lookupTable[0][size - 1];
    }

    public static void printLookUpTable(int [][] lookupTable) {
        Util.print2dArray(lookupTable);
        System.out.println("-----------------------");
    }
}

package algo.dp;

import algo.util.Util;

/**
 * Edit distance is a metric to quantify how dissimilar two strings are to one another by counting the minimum number of operations required to transform one string into the other.
 * You are given two strings; write code to calculate how many minimum Levenshtein distance operations are required to convert one String to another.
 *
 * Edit distances find several applications in the real world. For example:
 * It is used to figure out which word is misspelled in automatic spelling correction.
 * In bioinformatics, it’s used to quantify the similarity between two DNA sequences.
 *
 * The Levenshtein distance operations are the most famous operations we will be following for this example. These are the String operations; each one of them has the same cost.
 * Insertion
 * Deletion
 * Substitution
 *
 * Example:   string str1 = "Tuesday"; string str2 = "Thursday"; Result: 2
 * First character “T” and last four characters “sday” are same. We basically need to convert “ue” to “hur”. This can be done using 2 operations i-e; Add h after T, Add r after u.
 */
public class EditDistance {

    public static void main(String[] args) {
        String[][] testCases = {
                {"Tuesday", "Thursday", "2"},
                {"Saturday", "Saturday", "0"},
                {"www.educative.io/explore", "educative.io/edpresso", "10"},
                {"abcd1234", "efg1234h", "5"},
                {"EducativeIsFun", "AlgorithmsAreFun", "12"}

        };
        for (int i = 0; i < testCases.length; i++) {
            System.out.println(Integer.valueOf(testCases[i][2]) == minEditDistanceTabulation(testCases[i][0], testCases[i][1]) ? "Success" : "Error");
        }
    }

    public static int minEditDistanceRecursion(String str1, String str2) {
        return minEditDistanceRecursion(str1, str1.length()-1, str2, str2.length()-1);
    }

    public static int minEditDistanceRecursion(String str1, int p1, String str2, int p2) {
        if (p1 < 0 && p2 < 0)
           return 0;
        if (p1 < 0 )
            return p2+1;
        if (p2 < 0 )
            return p1+1;
        if(str1.charAt(p1) == str2.charAt(p2)) {
            return minEditDistanceRecursion(str1, p1-1, str2, p2-1);
        } else {
            return 1 + Util.min(
                    minEditDistanceRecursion(str1, p1-1, str2, p2-1),
                    minEditDistanceRecursion(str1, p1, str2, p2-1),
                    minEditDistanceRecursion(str1, p1-1, str2, p2));
        }
    }

    public static int minEditDistanceTabulation(String str1, String str2) {
        int[][] matrix = new int[str1.length()+1][str2.length()+1];
        for(int i=1; i<=str1.length(); i++)
            matrix[i][0] = i;
        for(int j=1; j<=str2.length(); j++)
            matrix[0][j] = j;
        for(int i=1; i<=str1.length(); i++) {
            for(int j=1; j<=str2.length(); j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    matrix[i][j] = matrix[i-1][j-1];
                } else {
                    matrix[i][j] = 1 + Util.min(matrix[i-1][j-1], matrix[i][j-1], matrix[i-1][j]);
                }
            }
        }
//        Util.print2dArray(matrix);
        return matrix[str1.length()][str2.length()];
    }

}

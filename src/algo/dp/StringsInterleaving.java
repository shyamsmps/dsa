package algo.dp;

/**
 * Give three strings m, n, and p, write a function to find out if p has been formed by interleaving m and n.
 * ‘p’ should be considered to be an interleaved form of m and n if it contains all the letters from m and n with the order of the letters preserved.
 */
public class StringsInterleaving {

    public static void main(String[] args) {
        String[][] testCases = {
                {"abd", "cef", "abcdef", "true"},
                {"abcd1234", "efg4h", "abcd1efg2344h", "true"},
                {"Educative", "AlgorithmsAreFun", "EducativeAlgorithmsAreFun", "true"},
                {"C++Rocks", "C++IsFun", "C++RocksISFUN", "false"},
                {"www.educative.io/explore", "educative.io/edpresso", "educative.io", "false"}

        };
        for (int i = 0; i < testCases.length; i++) {
            System.out.println(Boolean.valueOf(testCases[i][3]) == findSI(testCases[i][0], testCases[i][1], testCases[i][2]) ? "Success" : "Error");
        }
    }

    public static boolean findSI(String m, String n, String p) {
        if (p.length() != m.length() + n.length())
            return false;
        return findSI(m, 0, n, 0, p, 0);
    }

    public static boolean findSI(String m, int pm, String n, int pn, String p, int pp) {
        System.out.println(pm + " - " + pn + " - " + pp);
        // if all strings are done
        if (pm>=m.length() && pn>=n.length() && pp>=p.length()) {
            return true;
        } else {
            boolean mMatch = pm<m.length() && p.charAt(pp) == m.charAt(pm) && findSI(m, pm+1, n, pn, p, pp+1);
            boolean nMatch = pn<n.length() && p.charAt(pp) == n.charAt(pn) && findSI(m, pm, n, pn+1, p, pp+1);
            return mMatch || nMatch;
        }
    }

}

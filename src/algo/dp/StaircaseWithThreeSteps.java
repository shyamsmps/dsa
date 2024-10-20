package algo.dp;

import java.util.*;

/**
 *  A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 *  Implement a function to count the number of possible ways that the child can run up the stairs.
 *  1,2,1 and 1,1,2 are two different ways.
 *  Answers: 0-1, 1-1, 2-2, 3-4, 4-7, 5-13, 6-24, 7-44, 8-81
 *  Formula: ways for n steps are: ways(n-1) + ways(n-2) + ways(n-3)
 */
public class StaircaseWithThreeSteps {

    public static void main(String[] args) {
        System.out.println(countWaysWithLookupTable(7));
    }

    public static int countWaysSimple(int n) {
        if (n < 0)
            return 0;
        if (n <= 2)
            return 1;
        int thirdLast = 1; //ways to reach third last stair
        int secondLast = 1; //ways to reach second last stair
        int last = 2; //ways to reach last stair
        int current = 0; //ways to reach current stair
        for (int i = 3; i <= n; i++) {
            current = last + secondLast + thirdLast; //summing ways to reach previous three stairs
            thirdLast = secondLast;
            secondLast = last;
            last = current;
        }
        return current;
    }


    /** a recursive approach with look up table using formula **/
    public static int countWaysWithLookupTable(int n) {
        if (n==0) return 0;
        int[] lookupTable = new int[n+1];
        lookupTable[0] = 1;
        for (int i=1; i<=n; i++) {
            lookupTable[i] = -1;
        }
        return countWaysWithLookupTable(n, lookupTable);
    }

    public static int countWaysWithLookupTable(int n, int[] lookupTable) {
        if (n<0) {
            return 0;
        } else {
            if (lookupTable[n] == -1) {
                lookupTable[n] = countWaysWithLookupTable(n-1, lookupTable) + countWaysWithLookupTable(n-2, lookupTable) + countWaysWithLookupTable(n-3, lookupTable);
            }
            return lookupTable[n];
        }
    }

    /** an over complicated but interesting brute force approach if you do not know the formula **/
    static int countWaysTerrible(int n) {

        if (n==0)
            return 0;

        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i=0; i<=n; i++) {
            map.put(i, new ArrayList<>());
        }
        map.get(0).add(Arrays.asList(0,0,0));

        // calculate combinations
        for (int i=1; i<=n; i++) {

            // including 3
            if (i%3==0)
                map.get(i).add(Arrays.asList(0,0,i/3));

            // including 2 and 3 (optional)
            if (i>=2) {
                for (List<Integer> integers : map.get(i-2)) {
                    if (integers.get(0) == 0)
                        map.get(i).add(Arrays.asList(0,integers.get(1)+1,integers.get(2)));
                }
            }

            // including 1, 2(optional) and 3(optional)
            for (List<Integer> integers : map.get(i-1)) {
                map.get(i).add(Arrays.asList(1+integers.get(0),integers.get(1),integers.get(2)));
            }

        }

        // factorial look up table
        int[] factorials = new int[n+1];
        factorials[0] = 1;
        factorials[1] = 1;

        // calculate permutations
        int ways = 0;
        for (List<Integer> integers: map.get(n)) {
            ways+=permutations(factorials, integers);
        }
        return ways;
    }

    public static int permutations(int[] factorials, List<Integer> combinations) {
        return factorial(factorials, combinations.get(0) + combinations.get(1) + combinations.get(2))
                /(factorial(factorials, combinations.get(0)) * factorial(factorials, combinations.get(1)) * factorial(factorials, combinations.get(2)));
    }

    public static int factorial(int[] factorials, int n) {
        if (factorials[n] > 0) {
            return factorials[n];
        }
        int value = n*factorial(factorials, n-1);
        factorials[n] = value;
        return value;
    }


}
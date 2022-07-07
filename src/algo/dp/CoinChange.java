package algo.dp;

import java.util.Arrays;

/**
 Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent),
 write code to calculate the number of ways to represent n cents.
 important: order here does not matter. Example for 6 cents, 5,1 and 1,5 are same.
 */
public class CoinChange {


    public static void main(String[] args) {
        int[][] coins = {{25, 10, 5, 1}, {5, 10, 25, 1}, {1, 5, 10, 25}, {10, 25, 1, 5}, {1, 2, 3, 5}};
        int[] values = {30, 10, 28, 75, 6};
        int[] outputs = {18, 4, 13, 121, 8};
        for(int i=0; i<coins.length; i++) {
            System.out.println(outputs[i] == countChangeTabulationOptimized(values[i], coins[i]) ? "Success" : "Failed");
        }
    }

    // top down approach where we start from n and calculate results in reverse
    // look up table can be used to save already processed results.
    public static int countChangeRecursive(int[] denoms, int denomsLength, int amount) {
        if (amount == 0)
            return 1;

        // If n is less than 0 then no solution exists
        if (amount < 0 || denomsLength <= 0)
            return 0;

        // If there are no coins and n is greater than 0, then no solution exist
        if (denomsLength <= 0 && amount >= 1)
            return 0;

        // count is sum of solutions (i) including and excluding current (i.e.) last element
        // denomsLength - 1 means we are excluding last element
        return
                countChangeRecursive(denoms, denomsLength - 1, amount) +
                        countChangeRecursive(denoms, denomsLength, amount - denoms[denomsLength - 1]);
    }

    public static int countChangeTabulation(int amount, int[] coins) {
        if (amount <= 0 || coins.length <= 0)
            return 0;

        int i, j, x, y;

        // We need n+1 rows as the table is constructed in bottom up manner using the base case 0
        int[][] lookUpTable = new int[amount + 1][coins.length];

        // Fill the entries for 0
        for (i = 0; i < coins.length; i++)
            lookUpTable[0][i] = 1;

        // Fill rest of the table entries in bottom up manner
        for (i = 1; i < amount + 1; i++) {
            for (j = 0; j < coins.length; j++) {
                // Count of solutions including coins[j]
                x = (i - coins[j] >= 0) ? lookUpTable[i - coins[j]][j] : 0;
                // Count of solutions excluding coins[j] (i.e. the previous entry)
                y = (j >= 1) ? lookUpTable[i][j - 1] : 0;
                // total count
                lookUpTable[i][j] = x + y;
            }
        }
//        Util.print2dArray(lookUpTable);
        return lookUpTable[amount][coins.length - 1];
    }

    public static int countChangeTabulationOptimized(int amount, int[] coins) {
        int[] lookupTable = new int[amount+1]; // indexed 0 to amount
        lookupTable[0] = 1; // important for start up

        for(int i=0; i<coins.length; i++) { // process each coin one by one
            for(int j=coins[i]; j<=amount; j++) { // fill ways for each amount which includes the current coin. obviously it has to start from coin value.
                lookupTable[j] += lookupTable[j-coins[i]];
            }
            System.out.println("Coin processed: " + coins[i] + ", look up table: " + Arrays.toString(lookupTable));
        }

        return lookupTable[amount];
    }

}
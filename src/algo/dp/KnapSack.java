package algo.dp;

/**
 *  Given two integer arrays that represent the weights and profits of N items,
 *  implement a function that finds a subset of these items that will gives us the maximum profit
 *  without their cumulative weight exceeding a given number capacity.
 *  Each item can only be selected once, which means we either skip it or put it in the knapsack.
 */
public class KnapSack {

    public static void main(String[] args) {

        int[][] weights = {{5,2,1,3,1},     {40,35,30,20,5}};
        int[][] profits = {{10,8,8,15,3},   {120,100,90,80,70}};
        int[] capacities = {5,100};
        int[] outputs = {26,370};

        for (int i=0; i<weights.length; i++) {
            System.out.println("[knapsackRecursive] Expected: " + outputs[i] + ", Result: " + knapsackRecursive(weights[i], profits[i], capacities[i]));
            System.out.println("[knapsackBottomUp] Expected: " + outputs[i] + ", Result: " + knapsackBottomUp(weights[i], profits[i], capacities[i]));
        }

    }

    static int knapsackRecursive(int weights[], int profits[], int capacity) {
        int lookupTable[][] = new int [weights.length][];

        // can be done without it. Some calls may be repetitive
        for (int i = 0; i < weights.length; i++) {
            // one entry for 0, and then for all possible capacities till max capacity.
            // Example, if capacity is 4, entries: 0,1,2,3,4
            lookupTable[i] = new int[capacity + 1];
            for (int j = 0; j < capacity + 1; j++)
                lookupTable[i][j] = 0;
        }
        return knapsackRecursive(lookupTable, weights, profits, capacity, 0);
    }

    static int knapsackRecursive(int [][] lookupTable, int weights[], int profits[], int capacity, int startFrom) {
        if(startFrom >= weights.length || capacity <= 0) {
            return 0;
        }
        if (lookupTable[startFrom][capacity] != 0) {
            return lookupTable[startFrom][capacity];
        }
        int profit1 = 0;
        int weight = weights[startFrom];
        if (weight <= capacity) {
            // calculate max profit of subarray starting from startFrom, always including current item
            profit1 = profits[startFrom] + knapsackRecursive(lookupTable, weights, profits, capacity-weight, startFrom+1);
        }
        // calculate next sub array's max profit after startFrom
        int profit2 = knapsackRecursive(lookupTable, weights, profits, capacity, startFrom+1);
        lookupTable[startFrom][capacity] = Math.max(profit1, profit2);
        return lookupTable[startFrom][capacity];
    }

    public static int knapsackBottomUp(int weights[], int profits[], int capacity) {

        int[] lookupTable = new int[capacity + 1];

        // fill it for first element
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c)
                lookupTable[c] = profits[0];
        }
        // process from second element
        for (int i = 1; i < weights.length; i++) {
            for (int c = capacity; c >= 0; c--) {
                int profit1 = 0;
                // include the item, if it is not more than the capacity
                if (weights[i] <= c)
                    profit1 = profits[i] + lookupTable[c - weights[i]];
                // exclude the item
                int profit2 = lookupTable[c];
                // take maximum
                lookupTable[c] = Math.max(profit1, profit2);
            }
        }
        return lookupTable[capacity];
    }


}
package algo.dp;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[][] inputs = {
                {7,1,5,3,6,4},
                {7,6,4,3,1},
                {1,2},
                {2,4,1},
                {3,2,6,5,0,3}
        };

        int[] outputs = {5, 0, 1, 2, 4};
        for (int i=0; i<inputs.length; i++) {
            System.out.println("Expected: " + outputs[i] + ", Actual: " + maxProfit(inputs[i]) + ", Passed: " + (outputs[i] == maxProfit(inputs[i])));
        }
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                int profit = price - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;

    }

    public static int maxProfitBruteforce(int[] prices) {
        int max = 0;
        for (int i=0; i<prices.length; i++) {
            for (int j=i+1; j<prices.length; j++) {
                int temp = prices[j] - prices[i];
                if (temp > 0) {
                    if (temp > max) {
                        max = temp;
                    }
                } else {
                    break;
                }
            }
        }
        return max;

    }
}

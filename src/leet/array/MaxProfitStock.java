package leet.array;


/*

Problem:

You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.

Solution:
If you see any immediate one day profit, buy and sell and get one day profit.
This way, profit will be maximized.

*/

public class MaxProfitStock {

    public static void main(String[] args) {
        float sum = 0;
        sum = sum + 3;
        float half = sum/2;
        System.out.println(half-1);
        int[][] input = {
                {7,1,5,3,6,4},
                {1,2,3,4,5},
                {7,6,4,3,1}
        };

        int[] output = {
                7,
                4,
                0
        };

        for (int i = 0; i < input.length; i++) {
            System.out.println("Expected: " + output[i] + ", Output: " + maxProfit(input[i]));
        }
    }

    public static int maxProfit(int[] prices) {
        int p = 0;
        int i = 0, j = 1;
        while (j < prices.length) {
            if (prices[j] > prices[i]) {
                p = p + prices[j] - prices[i];
            }
            i++;
            j++;
        }
        return p;
    }

}

package algo.dp;

import java.util.Arrays;

/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed.
The only constraint stopping you from robbing each of them is that adjacent houses have security systems connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

dp[i]=max(dp[i−1],dp[i−2]+nums[i])

 */
public class HouseRobber {

    public static void main(String[] args) {
        int[][] input = {
            {1, 2, 3, 1},
            {2, 7, 9, 3, 1},
            {2, 1, 1, 2},
            {7, 1, 5, 3, 6, 4}
        };

        int [] output = {4, 12, 4, 18};

        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]) + " expected: " + output[i] + " Output: " + rob(input[i]));
        }
    }

    public static int rob(int[] nums) {
        int current = 0; // max profit till now including or excluding current house
        int last = 0; // max profit till last house including or excluding last house
        for (int num : nums) {
            int temp = num + last; // can blindly add the current house value to the last house value as last contains the max profit till last house including last house or excluding last house
            last = current; // swap the last and current values
            current = Math.max(temp, last); // current will be the max of temp and last, means including or excluding current house
        }
        return current;  // Maximum robbed amount
    }

}

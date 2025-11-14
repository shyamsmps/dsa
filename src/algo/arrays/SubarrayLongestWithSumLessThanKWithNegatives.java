package algo.arrays;

import java.util.Arrays;

/*
Given an array of positive integers nums and an integer k,
find the length of the longest contiguous subarray whose sum is less than or equal to k.
You need to return the maximum possible length of such a subarray.

Example:
    nums = [1, 2, 3, 4, 5]
    k = 5
    answer: 3

Constraints:
    - 1 ≤ nums.length ≤ 10^5
    - 1 ≤ nums[i] ≤ 10^4
    - 1 ≤ k ≤ 10^9

 */
public class SubarrayLongestWithSumLessThanK {

    static int[][] arrays = {
            {3, 2, 1, 3, 1, 1},             {5},    {3},
            {3, 2, 4, 5, 1, 10, 20, 1, 1},  {9},    {3},
            {},                             {1},    {0},
            {5},                            {6},    {1},
            {5, 10, 15, 20},                {2},    {0},
            {1,1,1,1,1,1},                  {10},   {6},
            {1, 2, 3, 4, 5},                {5},    {2}
    };

    public static void main(String[] args) {
        for (int i=0; i<arrays.length; i+=3) {
            int[] input = arrays[i];
            int k = arrays[i+1][0];
            int output = arrays[i+2][0];
            int result = longestSubarrayWithSumLessThanK(input, k);
            System.out.println();
            System.out.println(
                    "pass: " + (output == result) + ", " +
                    "input: " + Arrays.toString(input) + ", " +
                    "k: " + k + ", " +
                    "result: " + result + ", " +
                    "expected: " + output);
        }
    }

    private static int longestSubarrayWithSumLessThanK(int[] nums, int k) {
        int result = 0, left = 0, right = 0, sum = 0;
        while(right < nums.length) {
            sum += nums[right];
            if (sum <= k) {
                if ((right-left+1) > result) {
                    result = right-left+1;
                }
            } else {
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return result;
    }

}

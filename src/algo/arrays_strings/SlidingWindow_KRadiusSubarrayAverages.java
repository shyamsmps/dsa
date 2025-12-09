package algo.arrays_strings;

import java.util.Arrays;

/*

https://leetcode.com/problems/k-radius-subarray-averages/description/

You are given a 0-indexed array nums of n integers, and an integer k.

The k-radius average for a subarray of nums centered at some index i with the radius k is the average of all elements in nums between the indices i - k and i + k (inclusive). If there are less than k elements before or after the index i, then the k-radius average is -1.

Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.

The average of x elements is the sum of the x elements divided by x, using integer division. The integer division truncates toward zero, which means losing its fractional part.

For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.

Input: nums = [7,4,3,9,1,8,5,2,6], k = 3
Output: [-1,-1,-1,5,4,4,-1,-1,-1]
Explanation:
- avg[0], avg[1], and avg[2] are -1 because there are less than k elements before each index.
- The sum of the subarray centered at index 3 with radius 3 is: 7 + 4 + 3 + 9 + 1 + 8 + 5 = 37.
  Using integer division, avg[3] = 37 / 7 = 5.
- For the subarray centered at index 4, avg[4] = (4 + 3 + 9 + 1 + 8 + 5 + 2) / 7 = 4.
- For the subarray centered at index 5, avg[5] = (3 + 9 + 1 + 8 + 5 + 2 + 6) / 7 = 4.
- avg[6], avg[7], and avg[8] are -1 because there are less than k elements after each index.

*/

public class SlidingWindow_KRadiusSubarrayAverages {

    public static void main(String[] args) {

        int[][] tests = {
            {7,4,3,9,1,8,5,2,6},    {3},        {-1,-1,-1,5,4,4,-1,-1,-1},
            {100000},               {0},        {100000},
            {8},                    {100000},   {-1},

        };
        
        for (int i=0; i<tests.length; i = i+3) {
            int[] input = tests[i];
            int k = tests[i+1][0];
            int[] expected = tests[i+2];
            int[] actual = withSlidingWindow(input, k);
            String emoji = Arrays.equals(expected, expected) ? "✅" : "❌";
            System.out.println(String.format("%s input: %s, k: %s, expected: %s, actual: %s",
                emoji,  Arrays.toString(input), k, Arrays.toString(expected), Arrays.toString(actual)));
        }
    }

    // additional array for sums
    private static int[] withSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int window = 2*k + 1;

        int[] output = new int[len];
        Arrays.fill(output, -1);

        if (len < window) {
            return output;
        }

        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
    
            // shrink the window when it's too large
            if (i >= window) {
                sum -= nums[i - window];
            }
    
            // window becomes valid when i >= w-1
            if (i >= window - 1) {
                output[i - k] = (int)(sum / window);
            }
        }

        return output;
    }

    private static int[] withSlidingWindowNoBranches(int[] nums, int k) {

        int len = nums.length;
        int[] out = new int[len];
        Arrays.fill(out, -1);

        int window = 2*k+1;
        if (window > len) {
            return out;
        }

        long sum=0;
        for (int i=0; i<window; i++) {
            sum += nums[i];
        }

        out[k] = (int) (sum/window);

        for (int i=k+1; i<len-k; i++) {
            sum = sum + nums[i+k] - nums[i-k-1];
            out[i] = (int) (sum/window);
        }

        return out;
    }

    // no additonal array needed
    private static int[] withPrefixSum(int[] nums, int k) {
        int len = nums.length;

        int[] output = new int[len];
        Arrays.fill(output, -1);

        long[] sums = new long[len+1];
        for (int i = 0; i < len; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        
        for (int i=k; i< len-k; i++) {
            int left = i-k;
            int right = i+k+1;
            output[i] = (int) ((sums[right] - sums[left]) / (2*k+1));
        }
        return output;
    }

}

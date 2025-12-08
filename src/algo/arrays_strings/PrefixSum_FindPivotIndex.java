package algo.arrays_strings;

import java.util.Arrays;

/**
Given an integer array, find the index where the sum of elements to the left equals the sum of elements to the right. 
Return the leftmost such index, or -1 if none exists.
 */
public class PrefixSum_FindPivotIndex {

    public static void main(String[] args) {

        int[][] tests = {
            {1, 7, 3, 6, 5, 6},     {3},
            {2, 1, -1},             {0},
            {0, 0, 0, 0},           {0},
            {1, 2, 3},              {-1},
            {-1, -1, 2, -1, -1},    {2}
        };
        
        for (int i=0; i<tests.length; i = i+2) {
            int[] input = tests[i];
            int output = tests[i+1][0];
            System.out.println();
            int result = withPrefixSum(input);
            System.out.println(String.format("pass: %s, input: %s, expected: %s, actual: %s", 
                                                    (output == result), Arrays.toString(input), output, result));
        }

    }

    private static int withPrefixSum(int[] nums) {
        int total = 0;
        // no need to have another extra array as we only need total sum.
        // we can loop again and do a sum
        // if you want to calculate sum again, extra array can be used but extra writes are always more expensive
        // Modern CPUs LOVE arithmetic and HATE memory access
        for (int i : nums) {
            total += i;
        }
        int leftSum = 0;
        for (int i=0; i<nums.length; i++) {
            int rightSum = total - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

}

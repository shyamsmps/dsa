package algo.arrays_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
Subarray Sum Equals K:
Given an integer array and an integer k, count the total number of contiguous subarrays whose elements sum exactly to k.
 */
public class PrefixSum_SubarraysSumEqualsK {

    public static void main(String[] args) {

        int[][] tests = {
            {1, 2, 3, 4, 5},          {5},  {2},
            {-2, 5, -1, 3, -4, 2},    {3},  {4},
            {10, -3, 4, -2, 1, 6},    {5},  {1},
            {4, -1, 2, 1, -5, 4},     {0},  {1},
            {7, -2, 3, 8, -1, 2},     {8},  {3}
        };
        
        for (int i=0; i<tests.length; i = i+3) {
            int[] input = tests[i];
            int k = tests[i+1][0], output = tests[i+2][0];
            // int result = withPrefixSum(input, k);
            System.out.println();
            int result = withPrefixSum(input, k);
            System.out.println(String.format("pass: %s, input: %s, k: %s, expected: %s, actual: %s", 
                                                    (output == result), Arrays.toString(input), k, output, result));
        }

    }

    private static int bruteforce(int[] nums, int k) {
        int result = 0;
        for (int i=0; i<nums.length; i++) {
            int sum = 0;
            for (int j=i; j<nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    System.out.println(Arrays.toString(Arrays.copyOfRange(nums, i, j+1)));
                    result++;
                }
            }
        }
        return result;
    }

    private static int withPrefixSum(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // to count subarrays starting from index 0 with exactly k sum
        int prefixsum = 0;
        for (int i=0; i<nums.length; i++) {
            prefixsum += nums[i];
            // are there any entries so far till when sum was this-k
            // we want k = currentSum - previousSum; hence previousSum = currentSum - k;
            if (prefixSumMap.containsKey(prefixsum-k)) {
                result += prefixSumMap.get(prefixsum-k);
            }
            prefixSumMap.put(prefixsum, prefixSumMap.getOrDefault(prefixSumMap, 0)+1);
        }
        return result;
    }

}

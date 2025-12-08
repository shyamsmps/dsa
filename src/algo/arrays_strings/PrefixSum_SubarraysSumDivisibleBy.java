package algo.arrays_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
A good subarray is a subarray where:
its length is at least two, and
the sum of the elements of the subarray is a multiple of k.
Note that:
A subarray is a contiguous part of the array.
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.

Constraints:
k > 0

 */
public class PrefixSum_SubarraysSumDivisibleBy {

    public static void main(String[] args) {

        int[][] tests = {
            {1, 2, 3, 4, 5},        {3},       {1},
            {2, 4, 7, 8, 13},       {11},      {1},
            {5, 0, 0, 7, 9},        {6},       {1},
            {5, -2, -3, 7, 12},     {5},       {1},
            {1, 1, 1, 1, 1},        {100},     {0},
            {3, 3, 4},              {4},       {0},
            {1},                    {1},       {0},
            {-1, -2, 3},            {3},       {1}
    };
        
        for (int i=0; i<tests.length; i = i+3) {
            int[] input = tests[i];
            int k = tests[i+1][0], output = tests[i+2][0];
            int result = withPrefixSum(input, k);
            String emoji = output == result ? "✅" : "❌";
            System.out.println(String.format("%s input: %s, k: %s, expected: %s, actual: %s", 
            emoji, Arrays.toString(input), k, output, result));
        }

    }

    private static int withPrefixSum(int[] nums, int k) {

        if (nums.length < 2) {
            return 0;
        }

        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, -1); // to count subarrays starting from index 0 with exactly k sum
        int prefixsum = 0;
        for (int i=0; i<nums.length; i++) {
            prefixsum += nums[i];
            // int remainder = prefixsum % k;
            int remainder = ((prefixsum % k) + k) % k; // optional normalization of remainder, keeps remainder always positive,
            if (prefixSumMap.containsKey(remainder) && (i - prefixSumMap.get(remainder) >= 2)) {
                return 1;
            }
            // store only the first occurence to determine length >= 2
            // important to store the remainder and not the sum
            // more artithmatic than programming, skip this
            prefixSumMap.putIfAbsent(remainder, i);
        }
        return 0;
    }

}

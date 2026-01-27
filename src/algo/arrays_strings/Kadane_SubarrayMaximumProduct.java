package algo.arrays_strings;

import java.util.Arrays;

/*
Given an integer array nums, find the contiguous subarray within the array that has the largest product,
and return that product.

The array may contain positive numbers, negative numbers, and zeros.

Because multiplying by a negative number flips the sign,
you must carefully track both the maximum and minimum product ending at each position.
 */
public class Kadane_SubarrayMaximumProduct {

    static void main(String[] args) {
        int[][] nums = {
                {2, 3, -2, 4},
                {-2, 0, -1},
                {-2, 3, -4},
                {-1, -3, -10, 0, 60},
                {-2, -3, -4},
                {-10, 1, 2},
                {0, 0, 0}
        };
        int[] sums = {6, 0, 24, 60, 12, 2, 0};
        for (int i = 0; i < nums.length; i++) {
            int result = maxProductKadane(nums[i]);
            System.out.println("Dynamic Programming. Passed: " + (result == sums[i]) + ". Expected: " + sums[i] + ", Actual: " + result + ". Array: " + Arrays.toString(nums[i]));
        }
    }

    public static int maxProductKadane(int[] nums) {

        int global_max = nums[0];
        int current_max = nums[0];
        int current_min = nums[0];

        for (int i=1; i<nums.length; i++) {

            int current = nums[i];

            // no special handling for zero is needed as max and min will be calculated keeping 0 in mind

            // swap if negative
            if (current < 0) {
                int temp = current_max;
                current_max = current_min;
                current_min = temp;
            }

            current_max = Math.max(current, current_max * current);
            current_min = Math.min(current, current_min * current);

            global_max = Math.max(current_max, global_max);
        }
        return global_max;
    }

}
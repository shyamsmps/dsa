package leet.arrays;

import java.util.Arrays;

/*


Problem:
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]

 */
public class MoveZerosToEnd {

    public static void main(String[] args) {
        int[][] input = {
                {0,1,0,3,12},
                {0},
                {1,2,3,4,5},
                {1,2,3,4,5,0}
        };
        int[][] output = {
                {1,3,12,0,0},
                {0},
                {1,2,3,4,5},
                {1,2,3,4,5,0}
        };
        for (int i = 0; i < input.length; i++) {
            int[] nums = input[i];
            efficientWithLessSwapping(nums);
            System.out.println("Expected: " + Arrays.toString(output[i]) + ", Output: " + Arrays.toString(nums));
        }
    }

    public static void efficientWithLessSwapping(int[] nums) {
        // i is the index where we can place the next non-zero element
        int i=0;
        // Traverse the array
        for (int j=0; j<nums.length; j++) {
            // If the current element is non-zero
            if (nums[j] != 0) {
                // If i is less than j, then we need to move the non-zero element to the index i, else we don't need to do anything
                if (i < j) {
                    nums[i] = nums[j];
                }
                // increment i if non-zero element is found
                i++;
            }
        }
        // Fill the remaining elements with 0
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }

    public static void withMoreSwapping(int[] nums) {
        int lastNonZeroFoundAt = 0;

        // Traverse the array
        for (int current = 0; current < nums.length; current++) {
            if (nums[current] != 0) {
                // Swap the current element with the element at lastNonZeroFoundAt
                int temp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = nums[current];
                nums[current] = temp;

                // Increment lastNonZeroFoundAt
                lastNonZeroFoundAt++;
            }
        }
    }
}

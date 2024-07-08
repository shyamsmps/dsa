package leet.array;

/*

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?

 */

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {

        int[][] inputArray = {
                {1,2,3,4,5,6,7,8,9,10}
        };

        int[] inputRotateBy = {
                3
        };

        for(int i = 0; i < inputArray.length; i++) {
            rotateArraySwapTwoTimes(inputArray[i], inputRotateBy[i]);
        }
    }

    // at max one swap per element
    public static void rotateCyclic(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // In case k is larger than the length of the array
        int count = 0; // Count of moved elements. at max, we need to move n elements

        for (int start = 0; count < n; start++) {
            int current = start;
            int prev = nums[start];
            // we may reach the same element again, in that case, we need to break and move to the next elements if any
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    // two swaps per element
    public static void rotateArraySwapTwoTimes(int[] nums, int k) {

        System.out.println("Input array: " + (Arrays.toString(nums)) + " rotate by: " + k);
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }

        int n = nums.length;
        k = k % n; // in case k is greater than the length of the array

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);

        System.out.println("Reversed entire array:" + (Arrays.toString(nums)));

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        System.out.println("Reversed first " + k + " entries: " + (Arrays.toString(nums)));

        // Step 3: Reverse the remaining n - k elements
        reverse(nums, k, n - 1);

        System.out.println("Reversed last " + (n-k) + " entries: " + (Arrays.toString(nums)));

    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}

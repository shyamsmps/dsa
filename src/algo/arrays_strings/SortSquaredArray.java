package algo.arrays_strings;

/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1

Input:
nums = [-4, -1, 0, 3, 10]
Output:
[0, 1, 9, 16, 100]
Explanation:
After squaring, the array becomes [16, 1, 0, 9, 100].
After sorting, it becomes [0, 1, 9, 16, 100].

Example 2

Input:
nums = [-7, -3, 2, 3, 11]
Output:
[4, 9, 9, 49, 121]

*/


import java.util.Arrays;

import static algo.util.Util.swapInt;

public class SortSquaredArray {

    static int swap = 0;
    static int iteration = 0;

    static int[][] inputs = {
            {1, 2, 3},
            {-4, -1, 0, 3, 10},
            {},
            {-7, -3, -2, -1, 2, 3, 11},
            {-3, -2},
            {-1},
            {1}
    };

    static int[][] outputs = {
            {1, 4, 9},
            {0, 1, 9, 16, 100},
            {},
            {1, 4, 4, 9, 9, 49, 121},
            {4, 9},
            {1},
            {1}
    };

    public static void main(String[] args) {
        for (int i=0; i< inputs.length; i++) {
            swap = 0;
            iteration = 0;
            int[] input = inputs[i];
            System.out.println("input: " + Arrays.toString(input));
            int[] expected = outputs[i];
            String expectedString = Arrays.toString(expected);
//            int[] result = sortSquaredArrayReverseNegative(input);
            int[] result = sortSquaredArrayExtraSpace(input);
            String resultString = Arrays.toString(result);
            System.out.println("result: " + resultString);
            boolean pass = expectedString.equals(resultString);
            System.out.println("pass: " + pass);
            if (!pass) {
                System.out.println("expected: " + expectedString);
            }
            System.out.println();
        }
    }

    /*
    This is the correct solution, you need extra space else you will have to sort again the entire array.
     */
    private static int[] sortSquaredArrayExtraSpace(int[] nums) {
        int[] result = new int[nums.length];
        int position = nums.length-1;
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int leftSquare = nums[left]*nums[left];
            int rightSquare = nums[right]*nums[right];
            if (leftSquare > rightSquare) {
                result[position--] = leftSquare;
                left++;
            } else {
                result[position--] = rightSquare;
                right--;
            }
        }
        return result;
    }

    /*
    not a good solution as in worst case, you need shuffling all the time till the last element.
    better just square it up and do a sort again.
     */
    private static int[] sortSquaredArrayReverseNegative(int[] nums) {

        boolean isNegative = false;
        boolean isAllNegative = false;

        if (nums.length > 0) {
            iteration++;
            isNegative = nums[0] < 0;
            isAllNegative = nums[nums.length -1 ] < 0;
            nums[0] = nums[0] * nums[0];
        }

        // initialize with no compare needed
        int y = -1;
        for (int i=1; i<nums.length; i++) {

            iteration ++;


            // change from negative numbers to positive if found
            if (y < 0 && isNegative && nums[i] >= 0) {
                // reverse the array
                reverse(nums, i-1);
                y = 0;
            }

            nums[i] = nums[i]*nums[i];

            if (y >= 0 && y < i) {
                for (int p = y; p < i; p++) {
                    iteration++;
                    if (nums[p] > nums[i]) {
                        swap++;
                        swapInt(nums, i, p);
                    }
                }
                y++;
            }
        }

        if (isAllNegative) {
            reverse(nums, nums.length-1);
        }

        System.out.println("size: " + nums.length + ", swap: " + swap + ", iteration: " + iteration);
        return nums;
    }

    private static void reverse(int[] nums, int b) {
        for (int a = 0; a < b; a++, b--) {
            iteration ++;
            int temp = nums[b];
            nums[b] = nums[a];
            nums[a] = temp;
            swap++;
        }
    }

}

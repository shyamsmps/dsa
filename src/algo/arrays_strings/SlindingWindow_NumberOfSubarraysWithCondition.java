package algo.arrays_strings;

import java.util.Arrays;

/*
Given an array of positive integers nums and an integer k, 
return the number of subarrays where the product of all the elements in the subarray is strictly less than k.
If a problem asks for the number of subarrays that fit some constraint, we can still use sliding window, but we need to use a neat math trick to calculate the number of subarrays. If a window is valid, the number of valid windows ending at index right is equal to the size of the window, which we know is right - left + 1.
 */
public class SlindingWindow_NumberOfSubarraysWithCondition {

    public static void main(String[] args) {
        // Array of input arrays
        int[][] inputs = {
            {10, 5, 2, 6},
            {1, 2, 3},
            {1, 1, 1},
            {10, 20, 30},
            {1, 2, 5, 4},
            {100, 200, 300},
            {1},
            {5},
            {2, 3, 4},
            {1, 2, 1, 2, 1}
        };

        // Array of corresponding k values
        int[] ks = {100, 10, 2, 50, 10, 1000, 2, 5, 8, 4};

        // Array of expected outputs
        int[] outputs = { 
            8,   // [10,5,2,6], k=100
            6,   // [1,2,3], k=10
            6,   // [1,1,1], k=2
            3,   // [10,20,30], k=50
            5,   // [1,2,5,4], k=10   <-- fixed
            3,   // [100,200,300], k=1000  <-- fixed
            1,   // [1], k=2
            0,   // [5], k=5  <-- fixed
            4,   // [2,3,4], k=8
            11   // [1,2,1,2,1], k=4  <-- fixed
        };
        
        // for (int i=8; i<9; i++) {
        for (int i=0; i<inputs.length; i++) {
            int[] input = inputs[i];
            int k = ks[i];
            int output = outputs[i];
            // int result = withSlidingWindow(input, k);
            int result = numSubarrayProductLessThanK(input, k);
            System.out.println(String.format("pass: %s, input: %s, k: %s, expected: %s, actual: %s", 
                                                    (output == result), Arrays.toString(input), k, output, result));
        }

    }

    // O(n^2), bruteforce
    private static int withSlidingWindow(int[] nums, int k) {
        int result=0;
        for (int left=0; left<nums.length; left++) {
            int product = 1;
            for (int right=left; right<nums.length; right++) {
                product = product * nums[right];
                if (product<k) {
                    result++;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    // O(n) with sliding window
    private static int numSubarrayProductLessThanK(int[] nums, int k)  {
        if (k <= 1) {
            return 0;
        }
        int count = 0;
        int left = 0;
        int product = 1;
        for (int right=0; right<nums.length; right++) {
            product = product * nums[right];
            while(left <= right && product >= k) {
                product = product/nums[left];
                left++; // trick: moves one pointer ahead of right if item at an index is >= k
            }
            count = count + (right - left + 1);
        }
        return count;
    }
}
    



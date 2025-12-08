package algo.arrays_strings;

import java.util.Arrays;

/*
Given an integer array nums and an integer k, 
find the sum of the subarray with the largest sum whose length is k.
*/
public class SlindingWindow_SubarraysWithFixedLength {

    public static void main(String[] args) {
        int[][] inputs = {
            {1, 2, 3, 4, 5},
            {-2, 5, -1, 3, -4, 2},
            {10, -3, 4, -2, 1, 6},
            {4, -1, 2, 1, -5, 4},
            {7, -2, 3, 8, -1, 2}
        };
        
        int[] ks = {
            2,
            3,
            1,
            4,
            3
        };
        
        int[] outputs = {
            9,   // max sum subarray of size 2
            7,   // max sum subarray of size 3
            10,  // max sum subarray of size 1
            6,   // max sum subarray of size 4
            10   // max sum subarray of size 3
        };
        
        // for (int i=8; i<9; i++) {
        for (int i=0; i<inputs.length; i++) {
            int[] input = inputs[i];
            int k = ks[i];
            int output = outputs[i];
            // int result = withSlidingWindow(input, k);
            int result = withSlidingWondow(input, k);
            System.out.println(String.format("pass: %s, input: %s, k: %s, expected: %s, actual: %s", 
                                                    (output == result), Arrays.toString(input), k, output, result));
        }

    }

    /*
    Prefer for loops, whiles are always prone to bugs
    */
    private static int withSlidingWondow(int[] nums, int k) {
        int current = 0;

        for (int i = 0; i < k; i++) {
            current += nums[i];
        }
        int sum = current;

        for (int i=k; i<nums.length; i++) {
            current = current - nums[i-k] + nums[i];
            sum = Math.max(current, sum);
        }

        return sum;
    }

}

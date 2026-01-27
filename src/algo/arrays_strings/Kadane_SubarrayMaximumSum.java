package algo.arrays_strings;

import java.util.Arrays;

/*
Find max sum of a subarray, a subarray is continuous.
 */
public class Kadane_SubarrayMaximumSum {

    static void main(String[] args) {
        int[][] nums = {{-2, 1, -3, 4, -1, 2, 1, -5, 4}, {5, 4, -1, 7, 8}, {-2, 1}, {-4, -1009, -3, -1}, {-4, -1, 0}};
        int[] sums = {6, 23, 1, -1, 0};
        for (int i = 0; i < nums.length; i++) {
            int result = maxSumKadane(nums[i]);
            System.out.println("Dynamic Programming. Passed: " + (result == sums[i]) + ". Expected: " + sums[i] + ", Actual: " + result + ". Array: " + Arrays.toString(nums[i]));
            int resultDC = maxSubArrayDivideAndConquer(nums[i]);
            System.out.println("Divide and Conquer. Passed: " + (resultDC == sums[i]) + ". Expected: " + sums[i] + ", Actual: " + resultDC + ". Array: " + Arrays.toString(nums[i]));
        }
    }

    public static int maxSumKadane(int[] nums) {
        int global_max = Integer.MIN_VALUE; // max sum so far
        int current_max = 0; // sum ending at this index

        for (int current : nums) {
            // compare current sum + this element vs this element itself
            current_max += current;
            // reset the current sum if there is no point keeping track of previous elements
            current_max = Math.max(current, current_max);
            global_max = Math.max(current_max, global_max);
        }
        return global_max;
    }

    public static int maxSubArrayDivideAndConquer(int[] nums) {
        return maxSubArrayDivideAndConquer(nums,0,nums.length-1);
    }

    private static int maxSubArrayDivideAndConquer(int[] nums, int i, int j) {

        if (i == j) {
            return nums[i];
        }

        int mid = (i + j) / 2;
        int sum = 0, leftMaxSUM = Integer.MIN_VALUE;

        for (int l = mid; l >= i; l--) {
            sum += nums[l];
            if (sum > leftMaxSUM) {
                leftMaxSUM = sum;
            }
        }

        int rightMaxSUM = Integer.MIN_VALUE;
        sum = 0;    // reset sum to 0
        for (int l = mid + 1; l <= j; l++) {
            sum += nums[l];
            if (sum > rightMaxSUM) {
                rightMaxSUM = sum;
            }
        }

        int maxLeftRight = Math.max(maxSubArrayDivideAndConquer(nums, i, mid),
                maxSubArrayDivideAndConquer(nums, mid + 1, j));
        return Math.max(maxLeftRight, leftMaxSUM + rightMaxSUM);
    }

}
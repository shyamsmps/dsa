package algo.arrays;

import java.util.Arrays;

public class MaximumSubarray {

    // TODO understand divide and conquer approach. Calculate complexity.

    public static void main(String[] args) {
        int[][] nums = {{-2, 1, -3, 4, -1, 2, 1, -5, 4}, {5, 4, -1, 7, 8}, {-2, 1}, {-4, -1009, -3, -1}, {-4, -1, 0}};
        int[] sums = {6, 23, 1, -1, 0};
        for (int i = 0; i < nums.length; i++) {
            int result = maxSubArrayDP(nums[i]);
            System.out.println("Dynamic Programming. Passed: " + (result == sums[i]) + ". Expected: " + sums[i] + ", Actual: " + result + ". Array: " + Arrays.toString(nums[i]));
            int resultDC = maxSubArrayDivideAndConquer(nums[i]);
            System.out.println("Divide and Conquer. Passed: " + (resultDC == sums[i]) + ". Expected: " + sums[i] + ", Actual: " + resultDC + ". Array: " + Arrays.toString(nums[i]));
        }
    }

    public static int maxSubArrayDP(int[] nums) {
        // https://en.wikipedia.org/wiki/Maximum_subarray_problem
        int sum = Integer.MIN_VALUE; // minimum possible value
        int tempsum = 0;
        for (int num : nums) {
            tempsum += num;
            if (tempsum > sum) {
                sum = tempsum;
            }
            if (tempsum <= 0) { // reset tempsum
                tempsum = 0;
            }
        }
        return sum;
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
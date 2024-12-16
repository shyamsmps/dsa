package algo.math;

/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Example 1:
Input: nums = [3,0,1]
Output: 2

Example 2:
Input: nums = [0,1]
Output: 2

 */
public class FindMissingNumber {

    public static void main(String[] args) {
        int[][] nums = {
            {3, 0, 1},
            {0, 1}
        };
        int[] results = {2, 2};
        for (int i = 0; i < nums.length; i++) {
            System.out.println("findMissingNumberUsingExtraSpace: " + (findMissingNumberUsingExtraSpace(nums[i]) == results[i]));
            System.out.println("findMissingNumberUsingMath: " + (findMissingNumberUsingMath(nums[i]) == results[i]));
        }
    }

    private static int findMissingNumberUsingExtraSpace(int[] num) {
        boolean[] found = new boolean[num.length + 1];
        for (int i : num) {
            found[i] = true;
        }
        for (int i = 0; i < found.length; i++) {
            if (!found[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int findMissingNumberUsingMath(int[] num) {
        int sum = 0;
        for (int i : num) {
            sum += i;
        }
        return (num.length * (num.length + 1)) / 2 - sum;
    }

}

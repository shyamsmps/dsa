package algo.dp;

import algo.util.Util;

/**
 * Given an array of integers, write a function to find if any two subsets of the input array exist such that the sum of both subsets is equal.
 * You can assume that the array will only consist of positive integers.
 * Every element must be included in either of the two partitions.
 */
public class PartitionOfArrayWithEqualSum {

    public static void main(String [] args) {
        int[][] inputs = {{2, 1, 3, 4}, {1, 1, 3, 4, 7}, {2, 3, 4, 6}};
        boolean[] outputs = {true, true, false};

        for (int i=0; i<inputs.length; i++) {
            System.out.println("[findPartitionBruteForce] Expected: " + outputs[i] + ", Result: " + findPartitionBruteForceRecursive(inputs[i]));
        }
    }

    public static boolean findPartitionBruteForce(int[] num) {
        // find sum of all elements
        int sum = Util.sumOfIntArray(num);
        // we need to find subarray with total sum of sum/2
        if (sum%2==0) {
            for (int i=1; i<num.length; i++) {
                // always including first element and finding remaining elements to reach the target sum.
                // this assumption is correct because an element WILL be included in one of the partitions.
                int sum1=num[0];
                for (int j=i+1; j<num.length && sum1<sum/2; j++) { // break if sum1 is equal or more than sum/2
                    sum1+=num[j];
                }
                if (sum1 == sum/2)
                    return true;
            }
        }
        return false;
    }

    public static boolean findPartitionBruteForceRecursive(int[] num) {
        int sum = Util.sumOfIntArray(num);
        if (sum%2!=0) {
            return false;
        }
        return findPartitionBruteForceRecursiveInternal(num, sum/2, 0);
    }
    private static boolean findPartitionBruteForceRecursiveInternal(int[] num, int targetSum, int startIndex) {
        // a look up table int[][] can also be used to store combination of targetSum and startIndex
        System.out.println("targetSum: " + targetSum + " | startIndex: " + startIndex);
        if (targetSum == 0)
            return true;
        if (startIndex >= num.length) {
            return false;
        }
        // only if element is less or equal than target sum, else exclude this and move to next element
        if (num[startIndex] <= targetSum) {
            if (findPartitionBruteForceRecursiveInternal(num, targetSum-num[startIndex], startIndex+1))
                return true;
        }
        return findPartitionBruteForceRecursiveInternal(num, targetSum, startIndex+1);
    }

}

package algo.greedy;

import java.util.Arrays;

/**
 * Find the largest possible number of given number of digits with a given sum
 */
public class LargestNumberWithGivenSum {

    public static void main(String[] args) {
        int[][] testCases = {
                {3, 20, 992},
                {2, 9, 90},
                {3, 100, -1}
        };

        for(int i=0; i<testCases.length; i++) {
            System.out.println(findLargestNumber(testCases[i][0], testCases[i][1]) == testCases[i][2] ? "Success" : "Error");
        }
    }

    public static int findLargestNumber(int digits, int sum) {
        int currentSum = 0;
        int array[] = new int[digits];
        for(int i=0; i<digits; i++) {
            int add = sum-currentSum > 9 ? 9 : sum-currentSum;
            currentSum += add;
            array[i] = add;
        }
        if(currentSum == sum) {
            int multiplier = 1;
            int number = 0;
            for(int i=array.length-1; i>=0; i--) {
                number += array[i]*multiplier;
                multiplier = multiplier*10;
            }
            return number;
        } else {
            return -1;
        }
    }
}

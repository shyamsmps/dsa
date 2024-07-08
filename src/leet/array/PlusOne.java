package leet.array;

import java.util.Arrays;

/*
Lessons:
Math.pow(double a, double b) returns the value of the first argument raised to the power of the second argument in double.

System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length) copies an array from the specified source array, beginning at the specified position, to the specified position of the destination array.



Problem:

You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.

 */
public class PlusOne {

    public static void main(String[] args) {
        int[][] inputs = {
                {1,2,3},
                {9},
                {9,9,9,9,9,9,9},
                {1,2,3,4,5,6,7,8,9,0},
                {9,8,7,6,5,4,3,2,1,0} // greater than max int limit, hence can not do calculations because 1 <= digits.length <= 100
        };
        int [][] outputs = {
                {1,2,4},
                {1,0},
                {1,0,0,0,0,0,0,0},
                {1,2,3,4,5,6,7,9,0,1},
                {9,8,7,6,5,4,3,2,1,1}
        };
        for (int i=0; i<inputs.length; i++) {
            int[] output = bruteForceCalculateDigitAsInt(inputs[i]);
            System.out.println("Input: " + Arrays.toString(inputs[i]) + ", Expected: " + Arrays.toString(outputs[i]) + ", Output: " + Arrays.toString(output));
        }
    }

    public static int[] bruteForceCalculateDigitAsInt(int[] digits) {
        int l = digits.length;
        int digit = 0;
        // calculate the digit
        for (int i=0; i<l; i++) {
            digit += digits[i] * ((int) Math.pow(10,l-1-i));
        }
        // increment the digit
        digit++;
        // calculate the length of the new digit
        int l1 = (digit / ((int) Math.pow(10, l-1))) > 9 ? l+1 : l;
        int[] plus1 = new int[l1];
        // create an array from the new digit
        for (int i=0; i<l1; i++) {
            int temp = (int) Math.pow(10, l1-1-i);
            plus1[i] = digit / temp;
            digit -= plus1[i] * temp;
        }
        return plus1;
    }

    public static int[] withCarry(int[] digits) {
        int i=digits.length-1, carry = 1;
        while (carry > 0 && i >= 0) {
            int temp = digits[i] + carry;
            digits[i--] = temp % 10;
            carry = temp / 10;
        }
        if (carry > 0) {
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = carry;
            System.arraycopy(digits, 0, newDigits, 1, newDigits.length - 1);
            return newDigits;
        } else {
            return digits;
        }
    }

    public static int[] withCarryEfficient(int[] digits) {
        for (int i=digits.length-1; i>=0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        // it comes here only if all digits are 9. Initialize array with original length + 1 (all elements 0) and set first digit to 1
        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        return newDigits;
    }

}

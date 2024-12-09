package algo.math;

/*
Given an integer n, return true if it is a power of three. Otherwise, return false.
An integer n is a power of three, if there exists an integer x such that n == 3^x.
Input: n = 27


Example 1:
Input: n = 27
Output: true
Explanation: 27 = 3^3

Example 2:
Input: n = 0
Output: false
Explanation: There is no x where 3^x = 0.

Example 3:
Input: n = -1
Output: false
Explanation: There is no x where 3^x = (-1).

 */
public class PowerOfThree {

    public static void main(String[] args) {
        int[] inputs = {27, 0, -1, 3, 9, 45, -27};
        boolean[] expectedOutputs = {true, false, false, true, true, false, false};
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Input: " + inputs[i]);
            System.out.println("Output: " + isPowerOfThree(inputs[i]));
            System.out.println("Expected Output: " + expectedOutputs[i]);
            System.out.println("=================================");
        }

    }

    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

}

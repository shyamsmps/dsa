package algo.math;

/*
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */
public class ReverseInt {

    public static void main(String[] args) {
        int[] input = {123, -123, 120, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        int [] expected = {321, -321, 21, 0, 0, 0};
        for (int i = 0; i < input.length; i++) {
            int result = reverse(input[i]);
            System.out.println("Input: " + input[i] + " Expected: " + expected[i] + " Result: " + result + " Pass: " + (expected[i] == result));
        }
    }

    // no need to handle negative case as divide and modulo will handle it
    // just check for overflow and underflow
    // start from last digit and keep adding to result after multiplying by 10
    public static int reverse(int x) {
        int y = 0;
        while (x != 0) {
            int digit = x%10;
            // overflow. check last digit
            if (y > Integer.MAX_VALUE/10 || (y == Integer.MAX_VALUE/10 && digit > 7)) {
                return 0;
            }
            // underflow. check last digit
            if (y < Integer.MIN_VALUE/10 || (y == Integer.MIN_VALUE/10 && digit < -8)) {
                return 0;
            }
            y = 10*y + digit;
            x = x/10;
        }
        return y;
    }

}

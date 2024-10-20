package algo.math;

/**
 * Given an integer x, return true if x is algo.numbers.Palindrome integer.
 * An integer is a algo.numbers.Palindrome when it reads the same backward as forward.
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a algo.numbers.Palindrome.
 */
public class Palindrome {

    public static void main(String[] args) {
        int arr[] = {0, 1, 10, 11, 101, 1001, 222, 1000, 1221, 1111, 10000, 13231, -121};
        for (int i=0; i<arr.length; i++) {
            System.out.println(Integer.toString(arr[i]) + " : " + Boolean.toString(isPalindromeFindReverse(arr[i])));
        }

    }

    /**
     * First of all we should take care of some edge cases. All negative numbers are not algo.numbers.Palindrome, for example: -123 is not a algo.numbers.Palindrome since the '-' does not equal to '3'.
     * So we can return false for all negative numbers.
     *
     * Now let's think about how to revert the last half of the number.
     * For number 1221, if we do 1221 % 10, we get the last digit 1, to get the second to the last digit, we need to remove the last digit from 1221, we could do so by dividing it by 10, 1221 / 10 = 122.
     * Then we can get the last digit again by doing a modulus by 10, 122 % 10 = 2, and if we multiply the last digit by 10 and add the second last digit, 1 * 10 + 2 = 12, it gives us the reverted number we want.
     * Continuing this process would give us the reverted number with more digits.
     *
     * Now the question is, how do we know that we've reached the half of the number?
     *
     * Since we divided the number by 10, and multiplied the reversed number by 10, when the original number is less than the reversed number, it means we've processed half of the number digits.
     * @param x
     * @return
     */
    public static boolean isPalindromeOptimal(int x) {
        if (x < 0 || (x!= 0 && x%10 == 0)) { // to take care of negative numbers and  10, 1000, 100000 etc
            return false;
        }
        int halfReverse = 0;
        while (halfReverse < x) {
            halfReverse = halfReverse*10 + x%10;
            x = x/10;
        }
        System.out.println("First half is: " + Integer.toString(x) + ", second half is: "+ Integer.toString(halfReverse));
        return  x == halfReverse || x == halfReverse/10; // second part of || is for odd number of digits
    }

    public static boolean isPalindromeFindReverse(int x) {
        if (x < 0) { // to take care of negative numbers
            return false;
        }
        int reverse = 0;
        int number = x;
        while (number > 0) {
            reverse = reverse*10 + number%10;
            number = number/10;
        }
        return  x == reverse;
    }
}

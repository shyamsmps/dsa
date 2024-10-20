package algo.math;

/*

Lesson:
Character.isDigit(c) can be used to check if a character is a digit.
int = char - '0' will give the integer value of the digit.

Problem:

Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
The algorithm for myAtoi(string s) is as follows:
Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
Return the integer as the final result.

Example 1:
Input: s = "42"
Output: 42

Example 2:
Input: s = " -042"
Output: -42

Example 3:
Input: s = "1337c0d3"
Output: 1337

Example 4:
Input: s = "0-1"
Output: 0

Example 5:
Input: s = "words and 987"
Output: 0

Constraints:
0 <= s.length <= 200
s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.

 */
public class StringToInt {

    public static void main(String[] args) {

        String [] inputs = {
                "42",
                " -042",
                "1337c0d3",
                "0-1",
                "words and 987",
                "2147483648",
                "-2147483649",
                "  +002147483647",
                " -02147483648",
                "214748364888464",
                "-214748364888464",
                "-2147483647"


        };

        int[] outputs = {
                42,
                -42,
                1337,
                0,
                0,
                Integer.MAX_VALUE,
                Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                Integer.MIN_VALUE,
                -2147483647
        };

        for(int i=0; i<inputs.length; i++) {
            int result = new StringToInt().myAtoi(inputs[i]);
            System.out.println("Input: " + inputs[i] + " Expected: " + outputs[i] + " Result: " + result + " myAtoi Pass: " + (outputs[i] == result));
            result = new StringToInt().myAtoiOptimized(inputs[i]);
            System.out.println("Input: " + inputs[i] + " Expected: " + outputs[i] + " Result: " + result + " myAtoiOptimized Pass: " + (outputs[i] == result));
        }

    }



    public int myAtoi(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        int i = 0;
        boolean isN = false;
        int number = 0;

        // ignore whitespaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // sign
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            isN = (s.charAt(i) == '-');
            i++;
        }

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {

                int digit = c-'0';
                if (isN) {

                    // handle upper and lower ranges
                    if ( (number < min/10) || (number == min/10 && digit > -1*(min%10)) ) {
                        return min;
                    }
                    number = 10*number - digit;

                } else {

                    // handle upper and lower ranges
                    if ( (number > max/10) || (number == max/10 && digit > max%10) ) {
                        return max;
                    }
                    number = number*10 + digit;

                }

            } else {
                break;
            }
        }

        return number;
    }

    public int myAtoiOptimized(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int index = 0;
        int length = s.length();
        int result = 0;
        int sign = 1;

        // Skip leading whitespace
        while (index < length && s.charAt(index) == ' ') {
            index++;
        }

        // Handle sign
        if (index < length && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // Convert string to integer
        while (index < length && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Check for overflow/underflow
            if (sign == 1) {
                if (result > (Integer.MAX_VALUE - digit) / 10) {
                    return Integer.MAX_VALUE;
                }
            } else {
                if (result < (Integer.MIN_VALUE + digit) / 10) {
                    return Integer.MIN_VALUE;
                }
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }
}

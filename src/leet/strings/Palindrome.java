package leet.strings;

/*

Lesson:
Ascii range of characters:
A-Z: 65-90
a-z: 97-122
0-9: 48-57

To manually change upper to lower case:
c = (char) (c + 32) or c = (char) (c + 'a' - 'A')

Using Character class:
Character.toLowerCase(c) or Character.toUpperCase(c)

For large strings, use StringBuilder instead of String for better performance.

Problem:

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "0P"
Output: false
Explanation: "op" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.

 */
public class Palindrome {

    public static void main(String[] args) {
        String[] inputs = {
                "A man, a plan, a canal: Panama",
                "0P",
                " ",
                "race a car"
        };
        boolean[] expected = {true, false, true, false};
        for (int i = 0; i < inputs.length; i++) {
            boolean result = isPalindrome(inputs[i]);
            System.out.println("Input: " + inputs[i] + " Expected: " + expected[i] + " Result: " + result + " Pass: " + (expected[i] == result));
        }
    }

    public static boolean isPalindrome(String s) {
        StringBuilder s1 = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if ( (c >= 'A'&& c <= 'Z') || (c >= 'a'&& c <= 'z') || (c >= '0'&& c <= '9') ) {
                s1.append(Character.toLowerCase(c));
            }
        }
        for (int i=0,j=s1.length()-1; i<=j; i++,j--) {
            if (s1.charAt(i) != s1.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}

package algo.strings;

/*

Lessons:
char - 'a' as int will give values from 0 to 25 for a to z

Problem:

Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
All characters have a ASCII value in [a-z] range.

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1

 */
public class FindFirstUniqueCharacter {

    public static void main(String[] args) {
        String[] input = {"leetcode", "loveleetcode", "aabb"};
        int [] expected = {0, 2, -1};
        for (int i = 0; i < input.length; i++) {
            int result = firstUniqChar(input[i]);
            System.out.println("Input: " + input[i] + " Expected: " + expected[i] + " Result: " + result + " Pass: " + (expected[i] == result));
        }
    }

    public static int firstUniqChar(String s) {
        int[] frequency = new int[26];
        // count frequency of each character
        for (int i=0; i<s.length(); i++) {
            frequency[s.charAt(i)-'a']++;
        }
        // find first character with frequency 1 by iterating over string from start to end
        for (int i=0; i<s.length(); i++) {
            if (frequency[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}

package leet.strings;

/*

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false


Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.


Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

 */
public class Anagram {

    public static void main(String[] args) {
        String[][] inputs = {
                {"anagram", "nagaram"},
                {"rat", "car"},
                {"a", "ab"},
                {"a", "a"},
                {"a", "b"},
                {"", ""},
                {"", "a"}
        };
        boolean[] expected = {true, false, false, true, false, true, false};
        for (int i = 0; i < inputs.length; i++) {
            boolean result = isAnagram(inputs[i][0], inputs[i][1]);
            System.out.println("Input: " + inputs[i][0] + " " + inputs[i][1] + " Expected: " + expected[i] + " Result: " + result + " Pass: " + (expected[i] == result));
        }
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] a = new int[26];
        // instead of counting frequency of characters in two separate arrays, we can use one array to count frequency of characters in s and decrement frequency of characters in t
        // if characters are unicode, we can use a hashmap to count frequency of characters
        for (int i=0; i<s.length(); i++) {
            a[s.charAt(i)-'a']++;
            a[t.charAt(i)-'a']--;
        }
        for (int count: a) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

}

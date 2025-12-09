package algo.arrays_strings;

import java.util.Arrays;

/*
Find the length of the longest substring within a given string that does not contain any repeating characters.
 */
public class SubstringLongestWithoutRepeatingCharas {

    static void main() {

        String[] inputs = {"abcabcbb", "bbbbb", "pwwkew", "dvdf", "", "abba", "abcdefg"};
        int[] outputs = {3, 1, 3, 3, 0, 2, 7};

        for (int i=0; i<inputs.length; i++) {
            String input = inputs[i];
            int expected = outputs[i];
            int actual = longestSubstringWithoutRepeatingCharas(input);
            String emoji = expected == actual ? "✅" : "❌";
            System.out.printf("%s input: %s, expected: %s, actual: %s%n",
                    emoji, input, expected, actual);
        }
    }

    private static int longestSubstringWithoutRepeatingCharas(String s) {

        int[] arr_index = new int[26]; // assuming all are small case, else can use map
        Arrays.fill(arr_index, -1);

        int max_length = 0;
        int start_index = 0;

        for (int i=0; i<s.length(); i++) {
            int c_index = s.charAt(i) - 'a';
            if (arr_index[c_index] >= start_index) { // exists already in current substring, reset current
                max_length = Math.max(max_length, i-start_index);
                start_index = arr_index[c_index]+1;
            }
            arr_index[c_index] = i;
        }
        return Math.max(max_length, s.length()-start_index);
    }

}

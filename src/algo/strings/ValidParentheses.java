package algo.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 An input string is valid if:
 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String arr[] = {"()[]{}", "(]", "", "["};
        for (int i=0; i<arr.length; i++) {
            System.out.println(String.join(", ", arr[i]) + " : " + validParenthesesV1(arr[i]));
        }

    }

    public static boolean validParenthesesV1(String s) {
        char[] stack = new char[s.length()];
        // can avoid creating map and do it via if else
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        int stackSize = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack[stackSize++] = c;
            } else {
                if (stackSize < 1 || stack[stackSize-1] != map.get(c)) {
                    return false;
                }
                stackSize--;
            }
        }
        return stackSize == 0;
    }

}

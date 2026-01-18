package algo.arrays_strings;

import java.util.Arrays;
import java.util.Stack;

/*
You are given an array of integers.

For each element in the array, find the Next Greater Element (NGE) — the first element to the right of the current element that is strictly greater than it.

If no such element exists, output -1 for that position.

Using monotonic stack, we can solve it using o(n) complexity.
*/
public class MonotonicStack_NextGreaterElement {

    public static void main(String[] args) {
        int[][] tests = {
            {7, 1, 3, 4, 9,  1, 8,  5, 2, 6},
            {9, 3, 4, 9, -1, 8, -1, 6, 6, -1},

            {13, 7,  6,  12},
            {-1, 12, 12, -1}

        };
        
        for (int i=0; i<tests.length; i = i+2) {
            int[] input = tests[i];
            int[] expected = tests[i+1];
            int[] actual = nextGreaterElement(input);
            String emoji = Arrays.equals(expected, actual) ? "✅" : "❌";
            System.out.printf("%s input: %s, expected: %s, actual: %s%n",
                emoji,  Arrays.toString(input), Arrays.toString(expected), Arrays.toString(actual));
        }
    }

    private static int[] nextGreaterElement(int[] nums) {
        int[] result = new int[nums.length];

        Stack<Integer> mStack = new Stack<>();

        // hint: store the indexes of elements that need to be resolved.
        // and pop them once a greater element is found.
        // check everytime if a greater element has been found for topmost element.
        for (int i=0; i<nums.length-1; i++) {
            while (mStack.size() > 0 && nums[i] > nums[mStack.peek()]) {
                result[mStack.pop()] = nums[i];
            }
            mStack.push(i);
        }
        while(mStack.size() > 0) {
            result[mStack.pop()] = -1;
        }

        return result;
    }

}

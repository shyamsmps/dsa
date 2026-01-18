package algo.arrays_strings;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/*
When will you see a warmer day?

Given a list of integers where each number represents the temperature on a given day.
For each day, determine how many days you would have to wait until a warmer temperature occurs.

If there is a future day with a higher temperature, return the number of days until that happens.
If there is no future day with a warmer temperature, return 0 for that day.

Example:

Input: [73, 74, 75, 71, 69, 72, 76, 73]
Output: [1, 1, 4, 2, 1, 1, 0, 0]

*/
public class MonotonicStack_DailyTemperatures {

    public static void main(String[] args) {
        int[][] tests = {
            {73, 73, 74, 75, 71, 69, 72, 76, 73, 73},
            {2, 1, 1, 4, 2, 1, 1, 0, 0, 0},

            {60, 50, 40, 30},
            {0, 0, 0, 0}

        };
        
        for (int i=0; i<tests.length; i = i+2) {
            int[] input = tests[i];
            int[] expected = tests[i+1];
            int[] actual = whenWillISeeWarmerDay(input);
            String emoji = Arrays.equals(expected, actual) ? "✅" : "❌";
            System.out.println(String.format("%s input: %s, expected: %s, actual: %s",
                emoji,  Arrays.toString(input), Arrays.toString(expected), Arrays.toString(actual)));
        }
    }

    private static int[] whenWillISeeWarmerDay(int[] nums) {
        int[] result = new int[nums.length];

        Deque<Integer> mStack = new ArrayDeque<>();

        // hint: store indices of days with unresolved warmer temperatures (monotonic decreasing stack)
        // pop elements that are less than current one and store the results as distance from current position
        for (int i=0; i<nums.length; i++) {
            while (!mStack.isEmpty() && nums[i] > nums[mStack.peek()]) {
                int index = mStack.pop();
                result[index] = i - index;
            }
            mStack.push(i);
        }
        return result;
    }

}

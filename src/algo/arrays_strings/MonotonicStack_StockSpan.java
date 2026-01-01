package algo.arrays_strings;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/*

Given an array of integers where each element represents the price of a stock on a given day,
compute the stock span for each day.

The span of a stock’s price on a given day is defined as
the maximum number of consecutive days (ending on that day)
for which the price of the stock was less than or equal to today’s price.

prices = [100, 80, 60, 70, 60, 75, 85]
span =   [1, 1, 1, 2, 1, 4, 6]

Hint: Stock Span is just Next Greater Element to the left, converted into a distance.

*/
public class MonotonicStack_StockSpan {

    public static void main(String[] args) {
        int[][] tests = {
            {100, 80, 60, 70, 60, 75, 85},
            {1, 1, 1, 2, 1, 4, 6}

        };
        
        for (int i=0; i<tests.length; i = i+2) {
            int[] input = tests[i];
            int[] expected = tests[i+1];
            int[] actual = stockSpanUsingMonotonicStack(input);
            String emoji = Arrays.equals(expected, actual) ? "✅" : "❌";
            System.out.println(String.format("%s input: %s, expected: %s, actual: %s",
                emoji,  Arrays.toString(input), Arrays.toString(expected), Arrays.toString(actual)));
        }
    }

    private static int[] stockSpanUsingMonotonicStack(int[] prices) {
        if (prices == null || prices.length == 0) {
            return new int[0];
        }

        int[] result = new int[prices.length];
        // strictly decreasing stack
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            // to maintain strictly decreasing order
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                // since all are removed, that means today has the highest price
                result[i] = i + 1;
            } else {
                // since its ever decreasing, result for today is,  today - last day when price was greater than today's
                result[i] = i - stack.peek();
            }

            stack.push(i);
        }

        return result;
    }

}

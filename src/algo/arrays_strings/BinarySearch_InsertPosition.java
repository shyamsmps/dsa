package algo.arrays_strings;

import java.util.Arrays;

/*
Search Insert Position
Given a sorted array of distinct integers and a target value,
return the index where it would be inserted in order to maintain the sorted nature of the array.
 */
public class BinarySearch_InsertPosition {

    static void main() {
        int[][] inputs = {
                {1, 3, 5, 6},
                {1, 3, 5, 6},
                {1, 3, 5, 6},
                {1, 3, 5, 6},
                {8},
        };
        int[] targets = {5, 2, 7, 0, 10};
        int[] outputs = {2, 1, 4, 0, 1};

        for (int i=0; i<inputs.length; i++) {
            int[] input = inputs[i];
            int target = targets[i];
            int expected = outputs[i];
            int actual = findInsertPosition(input, target);
            String emoji = expected == actual ? "✅" : "❌";
            System.out.printf("%s input: %s, expected: %s, actual: %s%n",
                    emoji, Arrays.toString(input), expected, actual);
        }
    }

    private static int findInsertPosition(int[] nums, int target) {
        return 0;
    }

}

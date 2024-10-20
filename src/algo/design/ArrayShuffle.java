package algo.design;

import java.util.Arrays;
import java.util.Random;

/*
Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.

Implement the Solution class:

Solution(int[] nums) Initializes the object with the integer array nums.
int[] reset() Resets the array to its original configuration and returns it.
int[] shuffle() Returns a random shuffling of the array.

 */
public class ArrayShuffle {

    public static void main(String[] args) {
        int[][] inputs = {
            {1, 2, 3},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };

        String[] operations = {"reset", "shuffle", "reset", "shuffle", "shuffle", "shuffle", "shuffle", "shuffle", "shuffle", "reset"};

        for (int i = 0; i < inputs.length; i++) {
            Solution obj1 = new Solution(inputs[i]);
            System.out.println("Input: " + Arrays.toString(inputs[i]));
            for (String operation : operations) {
                if (operation.equals("reset")) {
                    System.out.println("Reset: " + Arrays.toString(obj1.reset()));
                } else {
                    System.out.println("Shuffle: " + Arrays.toString(obj1.shuffle()));
                }
            }
            System.out.println();
        }

    }

}

class Solution {

    private final int[] nums;
    private final int[] current;
    private final Random random;

    public Solution(int[] nums) {
        random = new Random();
        this.nums = nums;
        current = new int[nums.length];
        copy(nums, current);
    }

    public int[] reset() {
        copy(nums, current);
        return current;
    }

    public int[] shuffle() {
        // start swapping from the last index so that we know that the last index is already shuffled and need not be swapped again.
        for (int i = current.length-1; i > 0; i--) {
            // Randomly select an index from 0 to i. current index also has a chance to be selected, hence, i has to be included in random selection.
            int j = random.nextInt(i+1);
            int temp = current[i];
            current[i] = current[j];
            current[j] = temp;
        }
        return current;
    }

    private void copy(int[] source, int[] target) {
        for (int i=0; i<source.length; i++) {
            target[i] = source[i];
        }
    }
}

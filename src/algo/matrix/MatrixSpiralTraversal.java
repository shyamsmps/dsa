package algo.matrix;

import java.util.Arrays;

/*

Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order in an array. Spiral order means:

Start from the top-left corner
Move right across the top row
Then down the last column
Then left across the bottom row
Then up the first column
Continue inward until all elements are visited

 */
public class MatrixSpiralTraversal {

    public static void main(String[] args) {
        int[][][] inputs = {
                {
                        {1,  2,  3,  4},
                        {5,  6,  7,  8},
                        {9, 10, 11, 12}
                },
                {
                        {1, 2, 3, 4}
                },
                {
                        {1},
                        {2},
                        {3}
                }
        };

        int [][] outputs = {
                {1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7},
                {1, 2, 3, 4},
                {1, 2, 3}
        };

        for (int i=0; i<inputs.length; i++) {
            int[][] input = inputs[i];
            int[] expected = outputs[i];
            int[] actual = spiralTraversalTry_1(input);
            String emoji = Arrays.equals(expected, actual) ? "✅" : "❌";
            System.out.printf("%s expected: %s, actual: %s%n",
                    emoji, Arrays.toString(expected), Arrays.toString(actual));
        }
    }

    static int[] spiralTraversalTry_1(int [][] matrix) {
        int m = matrix.length;
        int n = (m > 0) ? matrix[0].length : 0;
        int[] result = new int[m * n];
        int current = 0;

        int i = 0, i_start = 0, i_end = m-1; // row number
        int j= 0, j_start = 0, j_end = n-1; // column number

        int state = 0;
        while(current < result.length) {
            switch(state) {
                case 0: {
                    // horizontal forward, i.e. row scan
                    for (j = j_start, i = i_start; j <= j_end; j++) {
                        result[current++] = matrix[i][j];
                    }
                    i_start++;
                    break;
                }
                case 1: { // vertical forward, i.e. columns scan
                    for (j = j_end, i = i_start; i <= i_end; i++) {
                        result[current++] = matrix[i][j];
                    }
                    j_end--;
                    break;
                }
                case 2: { // horizontal backward
                    for (j = j_end, i = i_end; j >= j_start; j--) {
                        result[current++] = matrix[i][j];
                    }
                    i_end--;
                    break;
                }
                case 3: { // vertical backward
                    for (j = j_start, i = i_end; i >= i_start; i--) {
                        result[current++] = matrix[i][j];
                    }
                    j_start++;
                    break;
                }
            }
            state = (state+1) % 4;
        }

        return result;
    }

    static int[] spiralTraversal(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];

        int m = matrix.length;
        int n = matrix[0].length;

        int[] result = new int[m * n];
        int idx = 0;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {

            // 1. Traverse from left to right
            for (int j = left; j <= right; j++) {
                result[idx++] = matrix[top][j];
            }
            top++;

            // 2. Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                result[idx++] = matrix[i][right];
            }
            right--;

            // 3. Traverse from right to left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result[idx++] = matrix[bottom][j];
                }
                bottom--;
            }

            // 4. Traverse from bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[idx++] = matrix[i][left];
                }
                left++;
            }
        }

        return result;
    }


}

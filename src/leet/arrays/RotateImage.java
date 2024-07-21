package leet.arrays;

/*

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

Input: matrix = [[1,2], [3,4]]
Output: [[3,1], [4,2]]

Solution:
If you calculate, you will see that the element at matrix[i][j] will go to matrix[j][n-1-i] after rotation where n is the length of the matrix.
So, we can do this in-place by rotating the elements in a group of 4. We can start from the top-left corner and rotate the elements in a group of 4.

 */
public class RotateImage {

    // 4 way swap solution where we start from outer circle and keep going to inner circle
    // Draw it on paper to understand the logic, start from top left corner and keep swapping until we reach the same position
    public static void rotateMySolution(int[][] matrix) {
        int len = matrix.length;
        // start from outer circle and keep going to inner circle
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - 1 - i; j++) {
                int fromX = i;
                int fromY = j;
                int move = matrix[fromX][fromY];
                // rotate the elements in a group of 4.
                for (int count = 0; count < 4; count++) {
                    int toX = fromY;
                    int toY = len - 1 - fromX;
                    int temp = matrix[toX][toY];
                    matrix[toX][toY] = move;
                    move = temp;
                    fromX = toX;
                    fromY = toY;
                }
            }
        }
    }

    // More standard solution
    // This solution can be used to rotate the matrix in any direction, starting with transpose first.
    // If we want to rotate the matrix in anti-clockwise direction, we can reverse each column instead of row.
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix: Swap the rows and columns.
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int[] row : matrix) {
            reverseRow(row);
        }
    }

    private static void reverseRow(int[] row) {
        int left = 0;
        int right = row.length - 1;
        while (left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }

}

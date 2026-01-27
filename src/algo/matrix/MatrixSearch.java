package algo.matrix;

/*

You are given an m x n integers matrix.
Integers in each row are sorted in ascending order from left to right.
Integers in each column are sorted in ascending order from top to bottom.
Determine if a given target integer exists in the matrix.

 */
public class MatrixSearch {

    public static void main(String[] args) {
        int[][][] matrices = {
            {
                {1,  4,  7,  11,  15},
                {2,  5,  8,  12,  19},
                {3,  6,  9,  16,  22},
                {10, 13, 14, 17,  24},
                {18, 21, 23, 26,  30}
            },
            {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
            },
            {
                {42}
            },
            {
                {42}
            },
            {
                {1, 3, 5, 7, 9}
            },
            {
                {2},
                {4},
                {6},
                {8}
            },
            {
                {2},
                {4},
                {6},
                {8}
            }
        };

        int [] nums = {
            5, 20, 42, 7, 5, 6, 5
        };

        boolean [] outputs = {
            true, false, true, false, true, true, false
        };

        for (int i=0; i<matrices.length; i++) {
            int[][] matrix = matrices[i];
            int number = nums[i];
            boolean result = matrixSearch(matrix, number);
            boolean expected = outputs[i];
            String emoji = result == expected ? "✅" : "❌";
            System.out.printf("%s expected: %s, actual: %s%n", emoji, expected, result);
        }
    }

    private static boolean matrixSearch(int[][] matrix, int number) {

        int m = matrix.length;
        int n = m > 0 ? matrix[0].length : 0;

        // start with first and last column, because we need to eliminate either one entire row or one entire column
        // we need to start here because only two direction are possible and moving in either means discarding a row or column
        // greater ? move in this direction , lesser ? move in that direction

        int row = 0;
        int column = n-1;

        while (row < m && column >= 0) {
            int current = matrix[row][column];
            if (current == number) {
                System.out.println(number + " found at: " + row + "," + column);
                return true;
            } else if (current > number) {
                // move towards smaller elements, means discard the direction where only bigger elements are present
                column--;
            } else {
                // move towards bigger elements, means discard the direction where only smaller elements are present
                row++;
            }
        }
        return false;
    }

}

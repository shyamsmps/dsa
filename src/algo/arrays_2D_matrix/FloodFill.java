package algo.arrays_2D_matrix;

/*

You are given a 2D matrix (image) of integers, where each integer represents a color.
You are also given a starting cell (sr, sc) and a newColor value as an integer.
Perform a flood fill on the image starting from the cell (sr, sc) and return the updated matrix.
Flood Fill Rules:
   - Change the color of the starting cell and all connected cells (4-directionally: up, down, left, right)
   - Only cells with the same original color as the starting cell are filled
   - Diagonal cells are not considered connected

 */
public class FloodFill {

    public static void main(String[] args) {

        int[][][] inputs = {
                {
                        {1, 1, 1},
                        {1, 1, 0},
                        {1, 0, 1}
                },
                {
                        {0, 0, 0},
                        {0, 0, 0}
                },
                {
                        {1, 1},
                        {1, 1}
                }
        };

        int[][][] expectedOutputs = {
                {
                        {2, 2, 2},
                        {2, 2, 0},
                        {2, 0, 1}
                },
                {
                        {1, 1, 1},
                        {1, 1, 1}
                },
                {
                        {1, 1},
                        {1, 1}
                }
        };

        int[][] startingPositions = {
                {1, 1},
                {0, 0},
                {0, 0}
        };

        int[] newColor = {2, 1, 1};


        for (int i = 0; i < inputs.length; i++) {
            int[][] result = floodFill(inputs[i], newColor[i], startingPositions[i][0], startingPositions[i][1]);
            String emoji =java.util.Arrays.deepEquals(result, expectedOutputs[i]) ? "✅" : "❌";
            System.out.printf("Test case %d : %s", i+1, emoji);
            System.out.println("Expected:");
            printMatrix(expectedOutputs[i]);
            System.out.println("Result:");
            printMatrix(result);
            System.out.println();
        }
    }

    private static int[][] floodFill(int[][] input, int newColor, int row, int column) {
        if (input[row][column] == newColor) return input;
        fill(input, input[row][column], newColor, row, column);
        return input;
    }

    private static void fill(
            int[][] input,
            int color,
            int newColor,
            int row,
            int column
    ) {
        // bound checks first, preferred
        if (row < 0 || row >= input.length
                || column < 0 || column >= input[0].length
                || input[row][column] != color) {
            return;
        }
        input[row][column] = newColor;
        fill(input, color, newColor, row+1, column);
        fill(input, color, newColor, row, column+1);
        fill(input, color, newColor, row-1, column);
        fill(input, color, newColor, row, column-1);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}

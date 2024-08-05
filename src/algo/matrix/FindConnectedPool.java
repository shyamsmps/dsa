package algo.matrix;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

Learnings:
- convert a list of integers to an array of int: list.stream().mapToInt(Integer::intValue).toArray()
- sort an array: Arrays.sort(array)
- sort a list: list.stream().sorted().toList()
- convert an array of int to a list of integers: Arrays.stream(array).boxed().toList()

You have an integer matrix representing a plot of land, where the value at the location represents the height above sea level.
A value of zero indicates water.
A pond is a region of water connected vertically, horizontally or diagonally.
The size of the pond is the total number of connected water cells.
Write a method to output all pond sizes.

Example
Input
0 2 1 0
0 1 0 1
1 1 0 1
0 1 0 1
Output: 2, 4, 1 (in any order)

input2
1 1 0 1 0
1 0 0 1 0
1 1 0 1 1
0 0 0 1 1
0 1 0 1 1
Output: 9, 2 (in any order)

 */
public class FindConnectedPool {

    public static void main(String[] args) {
        int[][][] inputs = {
                {
                        {0, 2, 1, 0},
                        {0, 1, 0, 1},
                        {1, 1, 0, 1},
                        {0, 1, 0, 1}
                },
                {
                        {1, 1, 0, 1, 0},
                        {1, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 0, 1, 1},
                        {0, 1, 0, 1, 1}
                }
        };
        int[][] outputs = {
                {2, 4, 1},
                {9,2}
        };

        for (int i=0; i<inputs.length; i++) {
            int[] result = findConnectedPool(inputs[i]);
            int[] expected = outputs[i];
            Arrays.sort(expected);
            Arrays.sort(result);
            System.out.println("Output: " + Arrays.toString(result) + ", Expected: " + Arrays.toString(expected) + ", Match: " + Arrays.equals(result, outputs[i]));
        }
    }

    public static int[] findConnectedPool(int[][] matrix) {
        int[][] visited = new int[matrix.length][matrix[0].length];
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                int size = findConnectedPool(matrix, i, j, visited);
                if (size > 0) {
                    result.add(size);
                }
            }
        }
        return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static int findConnectedPool(int[][] matrix, int i, int j, int[][] visited) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] == 1 || matrix[i][j] != 0) {
            return 0;
        }
        visited[i][j] = 1;
        int count = 1;
        count += findConnectedPool(matrix, i-1, j-1, visited);
        count += findConnectedPool(matrix, i-1, j, visited);
        count += findConnectedPool(matrix, i-1, j+1, visited);
        count += findConnectedPool(matrix, i, j-1, visited);
        count += findConnectedPool(matrix, i, j+1, visited);
        count += findConnectedPool(matrix, i+1, j-1, visited);
        count += findConnectedPool(matrix, i+1, j, visited);
        count += findConnectedPool(matrix, i+1, j+1, visited);
        return count;
    }


}

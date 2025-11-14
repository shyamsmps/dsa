package algo.arrays_strings;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

 */
public class PascalsTriangle {

    public static void main(String[] args) {
        int[] arr = {5, 1, 6, 2};
        for (int j : arr) {
            System.out.println(generate(j));
        }

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        for (int i=2; i<= numRows; i++) {
            List<Integer> previousRow = result.get(i-2);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i - 1; j++) {
                row.add(previousRow.get(j - 1) + previousRow.get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }

}

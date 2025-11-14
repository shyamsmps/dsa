package algo.arrays_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 *
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergedIntervals = merge(intervals);

        // Print the result
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
    public static int[][] merge(int[][] intervals) {
        // Sort intervals by starting time using Comparator.comparing
        Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));

        // List to store merged intervals
        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // If the list of merged intervals is empty or there is no overlap, add the interval.
            // To check the overlap, compare the end of the last interval in the list with the start of the current interval.
            // Since it is sorted, the end of the last interval in the list will always be greater than the start of the current interval.
            // If not sorted, we would additionally have to compare the end of the last interval in the list with the start of the current interval.
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // There is an overlap, so merge the intervals
                // No need to calculate min of start and max of end as the intervals are sorted on start time
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        // Convert list back to int[][]
        return merged.toArray(new int[merged.size()][]);
        // this can also be done to convert this list to array
        // return merged.stream().toArray(int[][]::new);
    }
}


package algo.standard.algorithms;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {

        System.out.println("\n*********** searchOrInsertPositionInSortedDistinctList ***********");
        int[] nums_A = {-3,0,4,7,101, 1002, 1003};
        int[] targets_A = {-3, 101, 0, 4, 7, 1003, 1002, 23, 5, 100, 1003, 1001, 1004};
        for (int i=0; i<targets_A.length; i++) {
            System.out.println("Position of " + targets_A[i] + " in " + Arrays.toString(nums_A) + " is: " +
                    searchOrInsertPositionInSortedDistinctList(nums_A, targets_A[i], 0, nums_A.length-1));
        }

        System.out.println("\n*********** searchFirstPositionInSortedDuplicateList ***********");
        int[] nums_B = {-3, -3, -3, -3, 0, 4, 4, 4, 4, 7, 101, 1002, 1003, 1003};
        int[] targets_B = {-3, 101, 0, 4, 7, 1003, 1002, 23, 5, 100, 1001, 1004};
        for (int i=0; i<targets_B.length; i++) {
            System.out.println("First position of " + targets_B[i] + " in " + Arrays.toString(nums_B) + " is: " +
                    searchFirstPositionInSortedDuplicateList(nums_B, targets_B[i], 0, nums_B.length-1));
        }

        System.out.println("\n*********** searchLastPositionInSortedDuplicateList ***********");
        for (int i=0; i<targets_B.length; i++) {
            System.out.println("Last position of " + targets_B[i] + " in " + Arrays.toString(nums_B) + " is: " +
                    searchLastPositionInSortedDuplicateList(nums_B, targets_B[i], 0, nums_B.length-1));
        }
    }

    /**
     * Given a sorted array of distinct integers and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     */
    public static int searchOrInsertPositionInSortedDistinctList(int[] nums, int target, int begin, int end) {
        if (begin == end) {
            return begin;
        }
        int mid = (begin+end)/2;
        if (target > nums[mid]) {
            return searchOrInsertPositionInSortedDistinctList(nums, target, mid+1, end);
        } else {
            return searchOrInsertPositionInSortedDistinctList(nums, target, begin, mid);
        }
    }

    /**
     * Given a sorted array of integers (could be duplicates) and a target value, return the index of target's first occurrence.
     * If not, return -1.
     */
    public static int searchFirstPositionInSortedDuplicateList(int[] nums, int target, int begin, int end) {
        if (begin == end) {
            return nums[begin] == target ? begin : -1;
        }
        int mid = (begin+end)/2;
        if (target > nums[mid]) { // this will return first occurrence
            return searchFirstPositionInSortedDuplicateList(nums, target, mid+1, end);
        } else {
            return searchFirstPositionInSortedDuplicateList(nums, target, begin, mid);
        }
    }

    /**
     * Given a sorted array of integers (could be duplicates) and a target value, return the index of target's last occurrence.
     * If not, return -1.
     */
    public static int searchLastPositionInSortedDuplicateList(int[] nums, int target, int begin, int end) {
        if (begin == end) {
            return nums[begin] == target ? begin : -1;
        }
        int mid = (begin+end)/2;
        if (target < nums[mid + 1]) { // this will return last occurrence
            return searchLastPositionInSortedDuplicateList(nums, target, begin, mid);
        } else {
            return searchLastPositionInSortedDuplicateList(nums, target, mid+1, end);
        }
    }

}
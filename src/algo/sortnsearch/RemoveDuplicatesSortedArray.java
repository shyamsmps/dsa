package algo.sortnsearch;

import java.util.Arrays;

/**
 Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 Return k after placing the final result in the first k slots of nums.
 Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicatesSortedArray {

    public static void main(String[] args) {
        int[][] arr = {new int[] {1,1,2}, new int[] {1,2,3}, new int[] {-1,-1,0,0,1,1,1,2,2,3,3,4}, new int[] {}, new int[] {1,1,1}};
        for (int i=0; i<arr.length; i++) {
            System.out.println(removeDuplicates(arr[i]));
            System.out.println(Arrays.toString(arr[i]));
            System.out.println();
        }
    }

    public static int removeDuplicates(int[] nums) {
        // can be done with for loop, extra variable p will not be needed.
        int k = -1;
        int p = 0;
        while(p<nums.length) {
            if (k == -1 || nums[p]>nums[k]) {
                nums[++k] = nums[p];
            }
            p++;
        }
        return k+1;
    }


}

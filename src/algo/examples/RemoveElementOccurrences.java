package algo.examples;

import java.util.Arrays;

/**
 Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
 Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums.
 More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
 It does not matter what you leave beyond the first k elements.
 Return k after placing the final result in the first k slots of nums.
 Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 Input: nums = [3,2,2,3], val = 3
 Output: 2, nums = [2,2,_,_]
 */
public class RemoveElementOccurrences {

    public static void main(String[] args) {
        int[][] arrays = {{3,2,2,3}, {0,1,2,2,3,0,4,2}, {1}, {2}, {}};
        int [] elements = {3, 2, 2, 2, 2};
        for (int i=0; i<arrays.length; i++) {
            System.out.println("Input: " + Arrays.toString(arrays[i]) + ". Remove element: " + elements[i]);
            System.out.println("Number of elements left after removal: " + removeElementTwoPointers(arrays[i], elements[i]));
            System.out.println("Array after removal: " + Arrays.toString(arrays[i]));
            System.out.println();
        }

        int[][] arraysV2 = {{3,2,2,3}, {0,1,2,2,3,0,4,2}, {1}, {2}, {}};
        for (int i=0; i<arrays.length; i++) {
            System.out.println("Input: " + Arrays.toString(arraysV2[i]) + ". Remove element: " + elements[i]);
            System.out.println("Number of elements left after removal: " + removeElementTwoPointersV2(arraysV2[i], elements[i]));
            System.out.println("Array after removal: " + Arrays.toString(arraysV2[i]));
            System.out.println();
        }
    }

    // more swaps. swapping done even if value at back pointer is the element to be removed
    public static int removeElementTwoPointers(int[] nums, int val) {
        // forward and backward pointer is helpful when there are very less number of removals needed
        int counter = 0;
        int swaps = 0;
        int i = 0;
        int j = nums.length-1;
        while(i<=j) {
            counter ++;
            if (nums[i] == val) {
                nums[i] = nums[j];
                swaps++;
                j--;
            } else {
                i++;
            }
        }
        System.out.println("V1 swaps: " + swaps + ", counter: " + counter);
        return j+1;
    }

    // less swaps
    public static int removeElementTwoPointersV2(int[] nums, int val) {
        int swaps = 0;
        int counter = 0;
        int i = 0;
        int j = nums.length-1;
        while(i<=j) {
            counter ++;
            if (nums[i] == val) {
                if (nums[j] != val) {
                    nums[i] = nums[j--];
                    swaps++;
                } else {
                    while(j>= 0 && nums[j] == val) {
                        counter ++;
                        j--;
                    }
                    if (j>=0) {
                        nums[i] = nums[j--];
                        swaps++;
                    }
                }
            } else {
                i++;
            }
        }

        System.out.println("V2 swaps: " + swaps + ", counter: " + counter);
        return j+1;
    }


}

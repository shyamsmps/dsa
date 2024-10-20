package algo.sortnsearch;

import java.util.Arrays;

/**


<b>Lessons</b>:
When dealing with two arrays, you can think about starting from beginning or the end. Pick the one that makes sense.

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

 */
public class MergedSortedIntArrays {

    public static void main(String[] args) {
        int[][] nums1 = {
                {1, 2, 3, 0, 0, 0},
                {1,2,3,4,8,0,0,0},
                {1},
                {0}
        };
        int[] m = {3, 5, 1, 0};
        int[][] nums2 = {
                {2, 5, 6},
                {2,3,6},
                {},
                {1}
        };
        int[][] expected = {
                {1, 2, 2, 3, 5, 6},
                {1, 2, 2, 3, 3, 4, 6, 8},
                {1},
                {1}
        };
        for(int i=0; i<nums1.length; i++) {
            merge(nums1[i], m[i], nums2[i], nums2[i].length);
            String exp = Arrays.toString(expected[i]);
            String act = Arrays.toString(nums1[i]);
            System.out.println("Passed: " + exp.equals(act) + ". Expected: " + exp + ", Actual: " + act);
        }
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;
        while(p1 >=0 && p2 >= 0) {
            if (nums2[p2] > nums1[p1]) {
                nums1[p] = nums2[p2--];
            } else {
                nums1[p] = nums1[p1--];
            }
            p--;
        }
        while(p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }

}

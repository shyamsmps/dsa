package algo.trees;

/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.


 */

import java.util.Arrays;

public class BinarySearchTreeFromSortedArray {

    public static void main(String[] args) {
        int[][] inputs = {
            {1,2,3,4,5,6},
            {-10,-3,0,5,9},
            {1,3}
        };
        for(int[] input: inputs) {
            TreeNode root = sortedArrayToBST(input);
            System.out.println("Input: " + Arrays.toString(input));
            System.out.println("Output: ");
            TreeNode.printTree(root);
            System.out.println();
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + ((end-start)/2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid-1);
        root.right = sortedArrayToBST(nums, mid+1, end);
        return root;
    }

}

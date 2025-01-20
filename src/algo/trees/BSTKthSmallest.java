package algo.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Input: root = [3,1,4,null,2], k = 1
Output: 1

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
If the BST is modified frequently (with insertions and deletions), the naive in-order traversal becomes inefficient because we'd have to traverse the tree repeatedly.
See BSTWithSize.java for the optimized solution.

 */
public class BSTKthSmallest {

    public static void main(String[] args) {
        Integer[][] inputs = {
            {3,1,4,null,2},
            {5,3,6,2,4,null,null,1}
        };
        int[] ks = {1, 3};
        int[] outputs = {1, 3};
        for (int i=0; i<inputs.length; i++) {
            TreeNode root = TreeNode.createTree(inputs[i]);
            int k = ks[i];

            System.out.println("expected: " + outputs[i]);

            /*
            Kth smallest with extra space using recursion.
            Inorder traversal can be used to get the kth smallest element. We can store the elements in a list and return the kth element.
            Inorder traversal is left, root, right. We can use this to get the elements in sorted order.
             */
            int output_kthSmallestWithExtraSpace = kthSmallestWithNoExtraSpaceRecursion(root, k);
            System.out.println("kthSmallestWithExtraSpace passed: " + (output_kthSmallestWithExtraSpace == outputs[i]) + ". output: " + output_kthSmallestWithExtraSpace);

            /*
             Kth smallest with no extra space using recursion.
            We can use inorder traversal to get the kth smallest element. We can use a counter to keep track of the number of elements visited.
            When the counter reaches k, we can return the element.
             */
            int output_kthSmallestWithNoExtraSpace = kthSmallestWithNoExtraSpaceRecursion(root, k);
            System.out.println("kthSmallestWithNoExtraSpace passed: " + (output_kthSmallestWithNoExtraSpace == outputs[i]) + ". output: " + output_kthSmallestWithNoExtraSpace);

            /*
             Kth smallest with iteration.
            We can use a stack to do inorder traversal. We can keep track of the number of elements visited.
            For inorder traversal, we go left, root, right. We can use a stack to keep track of the nodes.
            Remember, stack for inorder (left, root, right) and queue for level order traversal (root, left, right).
             */
            int output_kthSmallestIteration = kthSmallestIteration(root, k);
            System.out.println("kthSmallestIteration passed: " + (output_kthSmallestIteration == outputs[i]) + ". output: " + output_kthSmallestIteration);

            /*
            Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
            If the BST is modified frequently (with insertions and deletions), the naive in-order traversal becomes inefficient because we'd have to traverse the tree repeatedly.
            We can store the size of the tree rooted at each node. This way, we can avoid traversing the tree repeatedly.
            We can use this size to find the kth smallest element.
            Complexity for search: O(h) where h is the height of the tree.
            Overhead during insertions and deletions: O(h) where h is the height of the tree.
             */

        }
    }

    public static int kthSmallestWithExtraSpaceRecursion(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        kthSmallestWithExtraSpaceRecursionInternal(root, k, list);
        return list.get(k-1);
    }

    public static void kthSmallestWithExtraSpaceRecursionInternal(TreeNode root, int k, List<Integer> list) {
        if (root == null) {
            return;
        }
        kthSmallestWithExtraSpaceRecursionInternal(root.left, k, list);
        list.add(root.val);
        // optimization. return if we have already found kth smallest.
        if (list.size() == k) {
            return;
        }
        kthSmallestWithExtraSpaceRecursionInternal(root.right, k, list);
    }

    public static int kthSmallestWithNoExtraSpaceRecursion(TreeNode root, int k) {
        // array of size 2. 0th index is the counter. 1st index is the result. This because we can't use int as a reference. Arrays are mutable and can be modified by each recursive call.
        int[] result = new int[2];
        kthSmallestWithNoExtraSpaceRecursionInternal(root, k, result);
        return result[1];
    }

    private static void kthSmallestWithNoExtraSpaceRecursionInternal(TreeNode root, int k, int[] result) {
        // inorder traversal
        if (root == null) {
            return;
        }
        kthSmallestWithNoExtraSpaceRecursionInternal(root.left, k, result);
        if (++result[0] == k) {
            result[1] = root.val;
            return;
        }
        kthSmallestWithNoExtraSpaceRecursionInternal(root.right, k, result);
    }

    public static int kthSmallestIteration(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        int counter = 0;
        while (!stack.isEmpty() || current != null) {
            if (current == null) {
                current = stack.pop();
                if (++counter == k) {
                    return current.val;
                }
                current = current.right;
            } else {
                stack.push(current);
                current = current.left;
            }
        }
        return -1;
    }

}

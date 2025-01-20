package algo.trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static algo.trees.TreeNode.printTree;

/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Preorder traversal of a binary tree means we process the root node first, then the left subtree, and finally the right subtree.
Inorder traversal means we process the left subtree first, then the root node, and finally the right subtree.

Example 1:
Input: preorder = [1,2,4,5,3,6,7,8], inorder = [5,4,2,1,3,7,6,8]
Output: [1,2,3,4,5,6,7,8]

Example 2:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]

 */
public class BinaryTreeFromPreorderAndInorder {

    public static void main(String[] args) {
        int [][] preorders = {
                {1, 2, 4, 5, 3, 6, 7, 8},
                {3, 9, 20, 15, 7},
                {-1}
        };
        int [][] inorders = {
                {5, 4, 2, 1, 3, 7, 6, 8},
                {9, 3, 15, 20, 7},
                {-1}
        };

        Integer[][] outputs = {
                {1,2,3,4,null,null,6,5,null,7,8},
                {3,9,20,null,null,15,7},
                {-1}
        };

        for (int i = 0; i < preorders.length; i++) {
            TreeNode root = FromPreorderAndInorderRecursive(preorders[i], inorders[i]);
            Integer[] expected = outputs[i];
            printTree(root);
            System.out.println("Recursive. expected: " + TreeNode.getString(TreeNode.createTree(expected)) + " actual: " + TreeNode.getString(root) + " passed: " + TreeNode.getString(TreeNode.createTree(expected)).equals(TreeNode.getString(root)));

            TreeNode rootIterative = fromPreorderAndInorderIterative(preorders[i], inorders[i]);
            printTree(rootIterative);
            System.out.println("Iterative. expected: " + TreeNode.getString(TreeNode.createTree(expected)) + " actual: " + TreeNode.getString(rootIterative) + " passed: " + TreeNode.getString(TreeNode.createTree(expected)).equals(TreeNode.getString(rootIterative)));

        }
    }

    public static TreeNode fromPreorderAndInorderIterative(int[] preorder, int[] inorder) {
        // Handle invalid input
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }

        // Stack to simulate recursive calls and keep track of the current path
        Stack<TreeNode> stack = new Stack<>();

        // Root is always the first element in preorder
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        // Indices to traverse preorder and inorder arrays
        int preIndex = 1; // Start from 1 because the root is already processed
        int inIndex = 0;

        // Iterate through the inorder array (this is the correct termination condition)
        while (inIndex < inorder.length) {
            // Check if the stack is not empty and the top of the stack's value
            // is not equal to the current inorder value
            if (!stack.isEmpty() && stack.peek().val != inorder[inIndex]) {
                // This means the current preorder element is the left child
                TreeNode node = stack.peek();
                node.left = new TreeNode(preorder[preIndex++]); // Create left child and increment preIndex
                stack.push(node.left); // Push the left child onto the stack
            } else {
                // If the top of the stack's value IS equal to the current inorder value,
                // we've finished processing the left subtree (or the node itself if it's a leaf)

                // Pop nodes from the stack until we find a node whose value is NOT equal to the current inorder element.
                while (!stack.isEmpty() && stack.peek().val == inorder[inIndex]) {
                    stack.pop(); // Pop the node
                    inIndex++; // Move to the next element in inorder
                }

                // Now, if there are more elements in preorder, the current element is the right child
                // This is the CRUCIAL check to prevent ArrayIndexOutOfBoundsException
                if (preIndex < preorder.length) {
                    TreeNode node = stack.peek(); // Get the last node that was not popped (parent of right child)
                    node.right = new TreeNode(preorder[preIndex++]); // Create right child and increment preIndex
                    stack.push(node.right); // Push the right child onto the stack
                }
            }
        }
        return root;
    }


    public static TreeNode FromPreorderAndInorderRecursive(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            throw new IllegalArgumentException("Invalid input: Arrays are null or lengths do not match.");
        }

        // Create a map for faster lookup of the index of each element in the inorder array
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Start the recursion with proper bounds for preorder and inorder
        return FromPreorderAndInorderRecursive(preorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderMap);
    }

    // Helper function for recursive tree construction
    private static TreeNode FromPreorderAndInorderRecursive(int[] preorder, int preStart, int preEnd,
                                            int inStart, int inEnd,
                                            Map<Integer, Integer> inorderMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null; // Base case: No nodes to process
        }

        // The first element in preorder is the root of the current subtree
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        // Find the root's index in inorder traversal
        int rootIndexInInorder = inorderMap.get(rootValue);

        // Calculate the size of the left subtree
        int leftSubtreeSize = rootIndexInInorder - inStart;

        // Recursively construct the left subtree (left part of preorder and inorder)
        root.left = FromPreorderAndInorderRecursive(preorder, preStart + 1, preStart + leftSubtreeSize,
                inStart, rootIndexInInorder - 1, inorderMap);

        // Recursively construct the right subtree (right part of preorder and inorder)
        root.right = FromPreorderAndInorderRecursive(preorder, preStart + leftSubtreeSize + 1, preEnd,
                rootIndexInInorder + 1, inEnd, inorderMap);

        return root;
    }

}

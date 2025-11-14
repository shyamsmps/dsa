package algo.trees;

import java.util.ArrayList;
import java.util.List;

import static algo.trees.TreeNode.printTree;


/*
Given the root of a binary tree, return the inorder traversal of its nodes' values.
Inorder traversal is a depth-first traversal that processes the nodes in left subtree, then the root, and then the right subtree.
It is called inorder because in a sorted binary tree, the inorder traversal will return the nodes in sorted order.
For this problem, you only need to return the list of node values. Binary tree provided is not a binary search tree.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,2,6,5,7,1,3,9,8]

 */
public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        Integer[][] inputs = {
                {1, null, 2, 3},
                {1,2,3,4,5,null,8,null,null,6,7,9},
                {1,2,3,4,null,null,6,5,null,7,8}
        };
        Integer[][] outputs = {
                {1, 3, 2},
                {4,2,6,5,7,1,3,9,8},
                {5,4,2,1,3,7,6,8}
        };
        for (int i = 0; i < inputs.length; i++) {
            TreeNode treeForIteration = TreeNode.createTree(inputs[i]);
            printTree(treeForIteration);
            List<Integer> outputFromIteration = inorderUsingIteration(treeForIteration);
            System.out.println("inorderUsingIteration. input: " + TreeNode.getString(treeForIteration) + " output: " + outputFromIteration + " passed: " + outputFromIteration.equals(List.of(outputs[i])));

            TreeNode treeForRecursion = TreeNode.createTree(inputs[i]);
            List<Integer> outputFromRecursion = inorderUsingRecursion(treeForRecursion);
            System.out.println("inorderUsingRecursion. input: " + TreeNode.getString(treeForRecursion) + " output: " + outputFromRecursion + " passed: " + outputFromRecursion.equals(List.of(outputs[i])));
        }
    }

    private static List<Integer> inorderUsingRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderUsingRecursion(root, list);
        return list;
    }

    private static void inorderUsingRecursion(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderUsingRecursion(root.left, list);
        list.add(root.val);
        inorderUsingRecursion(root.right, list);
    }

    public static List<Integer> inorderUsingIteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<TreeNode> stack = new ArrayList<>();

        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {

            // processing is always on the element that has been popped from the stack
            // always keep the leftmost node in the subtree at the top of the stack
            // if current becomes null, that means upto this point we have processed the left subtree, now we need to process the root and right subtree
            if (current == null) { // means we have reached the leftmost node in the subtree
                current = stack.remove(stack.size() - 1);
                list.add(current.val);
                current = current.right;
            } else {
                stack.add(current);
                current = current.left;
            }

        }

        return list;
    }
}

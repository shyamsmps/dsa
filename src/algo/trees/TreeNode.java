package algo.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    public static TreeNode createTree(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null; // Empty array, return null tree
        }

        TreeNode root = new TreeNode(arr[0]); // First element is the root
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1; // Index for the array
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // Add left child if not null
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Add right child if not null
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static String getString(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(root.val);
        sb.append(", ");
        sb.append(getString(root.left));
        sb.append(", ");
        sb.append(getString(root.right));
        sb.append("]");
        return sb.toString();
    }

    // Method to print the tree in a tree-like structure
    public static void printTree(TreeNode root) {
        printTreeHelper(root, 0);
    }

    // Helper method to recursively print the tree with indentation
    private static void printTreeHelper(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        // Print the right subtree first (to display it at the top visually)
        printTreeHelper(node.right, level + 1);

        // Print current node with indentation
        System.out.println("    ".repeat(level) + node.val);

        // Print the left subtree
        printTreeHelper(node.left, level + 1);
    }

}

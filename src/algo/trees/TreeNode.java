package algo.trees;

import java.util.*;

public class TreeNode {
    public int val; // Value of the node
    public TreeNode left; // Left child
    public TreeNode right; // Right child

    // Specific fields
    public TreeNode next; // Next pointer, i.e. the node to the right of the current node, used in some problems like NextRightPointer
    public int size; // Size of the tree rooted at this node. Used in problems like KthSmallestElementInBST where BST is modified often.

    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;

        // specific fields
        next = null;
        size = 1;
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
            if (arr[i] != null) {
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

    public static Integer[] getArray(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        list.add(root.val);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            list.add(node.left != null ? node.left.val : null);
            if (node.right != null) {
                queue.offer(node.right);
            }
            list.add(node.right != null ? node.right.val : null);
        }
        // remove trailing nulls
        while (list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }
        return list.toArray(new Integer[0]);
    }


    public static TreeNode findNode(TreeNode root, int p) {
        if (root == null) {
            return null;
        }
        if (root.val == p) {
            return root;
        }
        TreeNode left = findNode(root.left, p);
        if (left != null) {
            return left;
        }
        return findNode(root.right, p);
    }
}

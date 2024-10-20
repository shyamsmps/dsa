package algo.trees;

import java.util.Arrays;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    TreeNode(int x, TreeNode y, TreeNode z) {
        val = x;
        left = y;
        right = z;
    }

    public static TreeNode createTree(Integer[] arr) {
        List<Integer> list = Arrays.asList(arr);
        return createTree(list, 0);
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

    public static void printTree(TreeNode root) {
        printTree(root, 0);
    }

    private static void printTree(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        // Print right subtree first (with indentation)
        printTree(node.right, level + 1);

        // Print current node
        for (int i = 0; i < level; i++) {
            System.out.print("    "); // 4 spaces for each level
        }
        System.out.println(node.val);

        // Print left subtree
        printTree(node.left, level + 1);
    }

    private static TreeNode createTree(List<Integer> list, int i) {
        if (i >= list.size() || list.get(i) == null) {
            return null;
        }
        TreeNode root = new TreeNode(list.get(i));
        root.left = createTree(list, 2 * i + 1);
        root.right = createTree(list, 2 * i + 2);
        return root;
    }
}

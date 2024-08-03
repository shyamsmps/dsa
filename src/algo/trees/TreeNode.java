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

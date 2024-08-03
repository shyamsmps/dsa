package algo.trees;

/*
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

public class TreeFindMaxDepth {

    public static void main(String[] args) {
        Integer[][] inputs = {
                {3, 9, 20, null, null, 15, 7},
                {1, 2, 3, 4, 5},
                {1, null, 2},
                {0},
                {}
        };
        int[] outputs = {3, 3, 2, 1, 0};
        for (int i = 0; i < inputs.length; i++) {
            TreeNode root = TreeNode.createTree(inputs[i]);
            int output = maxDepth(root);
            System.out.println("input: " + TreeNode.getString(root) + " output: " + output + " pass: " + (output == outputs[i]));
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

}

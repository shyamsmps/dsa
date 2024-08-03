package algo.trees;

/*

Given the root of a binary tree, determine if it is a valid binary search tree (BST).
A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys more than node's key.
Both the left and right subtrees must also be binary search trees.
Restrictions:
The number of nodes in the tree is in the range [1, 104].
Integer.MIN_VALUE <= Node.val <= Integer.MAX_VALUE

Link: https://leetcode.com/problems/validate-binary-search-tree/

 */

public class TreeValidateIsBinaryTree {

    public static void main(String[] args) {
        Integer[][] inputs = {
                {2, 1, 3},
                {5, 1, 4, null, null, 3, 6},
                {5, 1, 4, null, null, 3, 6},
                {2, 2, 2},
                {Integer.MIN_VALUE},
                {Integer.MAX_VALUE},
                {5, Integer.MIN_VALUE, Integer.MAX_VALUE},
        };
        boolean[] outputs = {true, false, false, false, true, true, true};
        for (int i = 0; i < inputs.length; i++) {
            TreeNode root = TreeNode.createTree(inputs[i]);
            boolean output = isValidBST(root);
            System.out.println("input: " + TreeNode.getString(root) + " output: " + output + " pass: " + (output == outputs[i]));
        }

    }

    public static boolean isValidBST(TreeNode root) {
        // using null and not Integer.MIN_VALUE and Integer.MAX_VALUE because the tree can have these values
        // Constraints: Integer.MIN_VALUE <= Node.val <= Integer.MAX_VALUE
        return isValidBST(root, null, null);
    }

    public static boolean isValidBST(TreeNode root, Integer lower_limit, Integer upper_limit) {
        if (root == null) {
            return true;
        }
        if ((lower_limit != null && root.val <= lower_limit) || (upper_limit != null && root.val >= upper_limit)) {
            return false;
        }
        // left subtree should have values less than root and more than lower_limit that can be passed from parent roots
        boolean isLeftSubtreeValid = isValidBST(root.left, lower_limit, root.val);
        // right subtree should have values more than root and less than upper_limit that can be passed from parent roots
        boolean isRightSubtreeValid = isValidBST(root.right, root.val, upper_limit);
        return isLeftSubtreeValid && isRightSubtreeValid;
    }
}

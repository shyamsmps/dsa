package algo.trees;

/*
Given the root of a binary search tree and a node p in it, return the in-order successor value of that node in the BST.
If the given node has no in-order successor in the tree, return -1.

The successor of a node p is the node with the smallest key greater than p.val.

Example 1:
Input: root = [2,1,3], p = 1
Output: 2

Example 2:
Input: root = [5,3,6,2,4,null,null,1], p = 6
Output: -1

 */
public class BSTInorderSuccessor {

    public static void main(String[] args) {
        Integer[][] inputs = {
            {2,1,3},
            {2,1,3},
            {2,1,3},
            {5,3,6,2,4,null,null,1},
            {10,9,null,8,null,7,null,6,null,5,null,4,null,3,null,2,null,1}
        };
        int[] ps = {1, 2, 3, 6, 1};
        int[] outputs = {2, 3, -1, -1, 2};
        for (int i=0; i<inputs.length; i++) {
            TreeNode root = TreeNode.createTree(inputs[i]);
            TreeNode p = TreeNode.findNode(root, ps[i]);
            int output = inorderSuccessor(root, p);
            System.out.println("passed: " + (output == outputs[i]) + ". output: " + output);
        }
    }

    private static int inorderSuccessor(TreeNode root, TreeNode p) {

        // If the right child of the node is not null, then the inorder successor is the leftmost node in the right subtree.
        if (p.right != null) {
            TreeNode node = p.right;
            while (node.left != null) {
                node = node.left;
            }
            return node.val;
        }

        // If the right child of the node is null, then the inorder successor has to be left child of its parent. Hence, we need to go from the root to the node.
        TreeNode successor = null;
        TreeNode temp = root;
        while (temp != null) {
            if (p.val < temp.val) {
                successor = temp;
                temp = temp.left;
            } else if (p.val > temp.val) {
                temp = temp.right;
            } else {
                break;
            }
        }
        return successor != null ? successor.val : -1;
    }

}

package algo.trees;


/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Input: root = [1,2,2,3,4,4,3]
Output: true

Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100

Follow up: Could you solve it both recursively and iteratively?
 */

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {

    public static void main(String[] args) {
        Integer[][] inputs = {
                {1,2,2,3,4,4,3},
                {1,2,2,null,3,null,3}
        };

        boolean[] outputs = {true, false};
        for (int i = 0; i < inputs.length; i++) {
            TreeNode root = TreeNode.createTree(inputs[i]);
            boolean output = isSymmetric(root);
            System.out.println("input: " + TreeNode.getString(root) + " output: " + output + " pass: " + (output == outputs[i]));
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private static boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null) {
            if (node1.val != node2.val) {
                return false;
            } else {
                return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
            }
        }
        return false;
    }
}

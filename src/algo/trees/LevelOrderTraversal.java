package algo.trees;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Input: root = [1]
Output: [[1]]

Input: root = []
Output: []

 */
public class LevelOrderTraversal {

    public static void main(String[] args) {
        Integer[][] inputs = {
                {3, 9, 20, null, null, 15, 7},
                {1},
                {}
        };
        for (int i = 0; i < inputs.length; i++) {
            TreeNode root = TreeNode.createTree(inputs[i]);
            List<List<Integer>> output = levelOrder(root);
            System.out.println("input: " + TreeNode.getString(root) + " output: " + printList(output));
        }
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        addItems(root, list, 0);
        return list;
    }

    public static void addItems(TreeNode node, List<List<Integer>> list, int level) {
        if (node == null) {
            return;
        }
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(node.val);
        addItems(node.left, list, level+1);
        addItems(node.right, list, level+1);
    }

    private static String printList(List<List<Integer>> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (List<Integer> l : list) {
            sb.append("[");
            for (Integer i : l) {
                sb.append(i).append(",");
            }
            sb.append("],");
        }
        sb.append("]");
        return sb.toString();
    }

}

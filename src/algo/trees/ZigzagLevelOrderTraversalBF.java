package algo.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*

Lessons:
FOR BFS, use Queue. For DFS, use Stack.
Some queue classes in Java: LinkedList, PriorityQueue, ArrayDeque
Some stack classes in Java: LinkedList, Stack

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []

Recursion is not recommended for larger size trees. Use BFS with iteration. Enhance logic to keep track of level and direction.

 */
public class ZigzagLevelOrderTraversalBF {


    public static void main(String[] args) {
        Integer[][] inputs = {
                {3,9,20,null,null,15,7},
                {1},
                {}
        };
        int[][][] outputs = {
                {{3},{20,9},{15,7}},
                {{1}},
                {}
        };

        for (int i=0; i<inputs.length; i++) {
            TreeNode root = TreeNode.createTree(inputs[i]);
            List<List<Integer>> output = zigZagLevelTraverseIteration(root);
            List<List<Integer>> outputExpected = Arrays.stream(outputs[i]).collect(ArrayList::new, (list, arr) -> list.add(Arrays.stream(arr).collect(ArrayList::new, ArrayList::add, ArrayList::addAll)), ArrayList::addAll);
            String outputAsString = String.join(",", output.toString());
            String outputExpectedAsString = String.join(",", outputExpected.toString());
            System.out.println("zigZagLevelTraverseIteration. input: " + TreeNode.getString(root) + " output: " + outputAsString + " expected: " + outputExpectedAsString + " result: " + outputExpectedAsString.equals(outputAsString));
        }

        for (int i=0; i<inputs.length; i++) {
            TreeNode root = TreeNode.createTree(inputs[i]);
            List<List<Integer>> output = zigZagLevelTraverseRecursion(root);
            List<List<Integer>> outputExpected = Arrays.stream(outputs[i]).collect(ArrayList::new, (list, arr) -> list.add(Arrays.stream(arr).collect(ArrayList::new, ArrayList::add, ArrayList::addAll)), ArrayList::addAll);
            String outputAsString = String.join(",", output.toString());
            String outputExpectedAsString = String.join(",", outputExpected.toString());
            System.out.println("zigZagLevelTraverseRecursion. input: " + TreeNode.getString(root) + " output: " + outputAsString + " expected: " + outputExpectedAsString + " result: " + outputExpectedAsString.equals(outputAsString));
        }

    }

    private static List<List<Integer>> zigZagLevelTraverseIteration(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize;
        boolean rtl = false;

        while (!queue.isEmpty()) {

            levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i=0; i<levelSize; i++) {

                TreeNode entry = queue.poll();

                if (rtl) { // adding last entries first. rightmost to be in font.
                    levelList.add(0, entry.val);
                } else { // adding first entries first. left most to be in front.
                    levelList.add(entry.val);
                }

                // add non-null values in order from left to right
                if (entry.left != null) {
                    queue.offer(entry.left);
                }
                if (entry.right != null) {
                    queue.offer(entry.right);
                }
            }
            list.add(levelList);
            rtl = !rtl; // toggle direction
        }
        return list;
    }

    private static List<List<Integer>> zigZagLevelTraverseRecursion(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        zigZagLevelTraverseRecursion(root, list, 0);
        return list;
    }

    private static void zigZagLevelTraverseRecursion(TreeNode root, List<List<Integer>>list, int level) {
        if (root == null) {
            return;
        }
        if (list.size() <= level) {
            list.add(level, new ArrayList<>());
        }

        if (level%2 == 0) {
            list.get(level).add(root.val);
        } else {
            list.get(level).add(0, root.val);
        }

        zigZagLevelTraverseRecursion(root.left, list, level+1);
        zigZagLevelTraverseRecursion(root.right, list, level+1);
    }

}

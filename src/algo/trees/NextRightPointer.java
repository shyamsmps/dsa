package algo.trees;

import java.util.*;

/*
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.

Input: root = [1,2,3,4,5,6,7]
Output: [1,null,2,3,null,4,5,6,7,null]
 */
public class NextRightPointer {

    public static void main(String[] args) {
        Integer[][] input = {
            {1},
            {1,2,3,4,5,6,7},
            {}
        };
        Integer[][] output = {
            {1, null},
            {1,null,2,3,null,4,5,6,7, null},
            {}
        };

        for (int i=0; i<input.length; i++) {
            TreeNode root = TreeNode.createTree(input[i]);
            TreeNode rootWithNext = connectWithIterationUsingQueue(root);
            Integer[] expected = output[i];
            Integer[] actualArray = getArrayForNextPointers(rootWithNext);
            System.out.println("passed: " + Arrays.deepEquals(expected, actualArray) + ". expected: " + Arrays.toString(expected) + ". actual: " + Arrays.toString(actualArray));
        }
    }

    public static TreeNode connectWithIterationUsingQueue(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i=1; i<=levelSize; i++) {
                TreeNode node = q.poll();
                if (i < levelSize) {
                    node.next = q.peek();
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return root;
    }

    public static TreeNode connectWithRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        connectWithRecursion(root.left, root.right);
        return root;
    }

    private static void connectWithRecursion(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        connectWithRecursion(left.left, left.right);
        connectWithRecursion(left.right, right.left);
        connectWithRecursion(right.left, right.right);
    }

    public static Integer[] getArrayForNextPointers(TreeNode root) {
        if (root == null) {
            return new Integer[0];
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // first element in the queue is the head of the level
            list.add(queue.peek().val);
            int size = queue.size();
            for (int i=0; i< size; i++) {
                TreeNode node = queue.poll();
                list.add(node.next != null ? node.next.val : null);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return list.toArray(new Integer[0]);
    }

}

package algo.trees;

/*
This is a binary search tree (BST) implementation with size of the tree rooted at each node.
It is useful for following problems:
1. Kth Smallest Element in a BST
2. Kth Largest Element in a BST
3. Rank of a number in a BST

 */
public class BSTWithSize {
    private TreeNode root;

    // Insert a value into the BST
    public void insert(int val) {
        root = insert(root, val);
    }

    private TreeNode insert(TreeNode node, int val) {
        if (node == null) return new TreeNode(val);
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    // Delete a value from the BST
    public void delete(int val) {
        root = delete(root, val);
    }

    private TreeNode delete(TreeNode node, int val) {
        if (node == null) return null;
        if (val < node.val) {
            node.left = delete(node.left, val);
        } else if (val > node.val) {
            node.right = delete(node.right, val);
        } else {
            // Node to be deleted found
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            TreeNode successor = getMin(node.right);
            node.val = successor.val;
            node.right = delete(node.right, successor.val);
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    private TreeNode getMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // Find the k-th smallest element
    public int kthSmallest(int k) {
        return kthSmallest(root, k);
    }

    private int kthSmallest(TreeNode node, int k) {
        if (node == null) throw new IllegalArgumentException("k is out of range");
        int leftSize = size(node.left);
        if (k <= leftSize) {
            return kthSmallest(node.left, k);
        } else if (k == leftSize + 1) {
            return node.val;
        } else {
            return kthSmallest(node.right, k - leftSize - 1);
        }
    }

    private int size(TreeNode node) {
        return node == null ? 0 : node.size;
    }


}

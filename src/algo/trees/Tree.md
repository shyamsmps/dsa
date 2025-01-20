# Tree

## Binary tree
A tree is a binary tree if each node has at most two children.

### Types of binary trees

#### Full binary tree
A binary tree is full if every node has 0 or 2 children.

#### Complete binary tree
A binary tree is complete if all levels are completely filled except possibly for the last level, which is filled from left to right.

#### Perfect binary tree
A binary tree is perfect if all internal nodes have two children and all leaves are at the same level.

#### Balanced binary tree
A binary tree is balanced if the height of the tree is O(log n) where n is the number of nodes.

#### Degenerate binary tree
A binary tree is degenerate if each internal node has one child.

#### Skewed binary tree
A binary tree is skewed if it is either left-skewed or right-skewed.

##### Left-skewed binary tree
A binary tree is left-skewed if each node has only one child and the child is on the left.

##### Right-skewed binary tree
A binary tree is right-skewed if each node has only one child and the child is on the right.

### Type of tree traversal

#### Depth-first traversal
In depth-first traversal, we visit the nodes in the tree from the root to the deepest node and then back to the root.
Examples of depth-first traversal are pre-order, in-order, and post-order traversal.

##### Pre-order traversal
In pre-order traversal, we visit the root node first, then recursively do a pre-order traversal of the left subtree, followed by a pre-order traversal of the right subtree.
In simple terms, pre-order traversal is visiting the nodes in the tree in the order of root, left, and right.
Example:
```
    1
   / \
  2   3
 / \
4   5
```
Pre-order traversal: 1 2 4 5 3

##### In-order traversal
In in-order traversal, we recursively do an in-order traversal of the left subtree, visit the root node, and finally do an in-order traversal of the right subtree.
In simple terms, in-order traversal is visiting the nodes in the tree in sorted order if it is a binary search tree.
Example:
```
    1
   / \
  2   3
 / \
4   5
```
In-order traversal: 4 2 5 1 3

##### Post-order traversal
In post-order traversal, we recursively do a post-order traversal of the left subtree, followed by a post-order traversal of the right subtree, and finally visit the root node.
In simple terms, post-order traversal is visiting the nodes in the tree in the order of left, right, and root.
Example:
```
    1
   / \
  2   3
 / \
4   5
```
Post-order traversal: 4 5 2 3 1

#### Breadth-first traversal
In breadth-first traversal, we visit the nodes in the tree level by level, starting from the root.
In simple terms, breadth-first traversal is visiting the nodes in the tree level by level horizontally.

Example:
```
    1
   / \
  2   3
 / \
4   5
```
Breadth-first traversal: 1 2 3 4 5



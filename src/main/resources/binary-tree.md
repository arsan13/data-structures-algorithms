# Binary Tree – Interview Revision Notes

## Quick Summary

- **Binary Tree**: Each node has at most 2 children (left & right)

---

## Types of Binary Trees (At a Glance)

| Type        | Key Property |
|------------|-------------|
| Full       | 0 or 2 children |
| Complete   | All levels filled except last; last filled left to right |
| Perfect    | All leaves at same level; fully filled |
| Balanced   | Height ≈ log(n) |
| Degenerate | Acts like a linked list |

---

## Key Concepts to Remember

- **Height of Balanced Tree** → `O(log n)`
- **Degenerate Tree Height** → `O(n)` (worst case)
- **Perfect Tree Nodes Formula** → `2^h - 1`
- **Complete Tree Usage** → Used in **Heaps**

---

## Definitions

### Full Binary Tree
- Every node has either:
    - 0 children, or
    - 2 children

---

### Complete Binary Tree
- All levels are completely filled except possibly the last
- Last level is filled from left to right

---

### Perfect Binary Tree
- All internal nodes have exactly 2 children
- All leaf nodes are at the same level

---

### Balanced Binary Tree
- Height is approximately `log(n)`
- Ensures efficient operations

---

### Degenerate (Skewed) Binary Tree
- Each node has only one child
- Behaves like a linked list
- Types:
    - Left-skewed
    - Right-skewed

---

## Real-World Examples

- **File Systems** → Folder → subfolders hierarchy
- **Database Indexing (BST / B-Trees)** → Fast search & retrieval
- **Heaps (Complete Binary Tree)** → Priority queues
- **Expression Trees** → Evaluate expressions like `(a + b) * c`
- **Game AI / Decision Trees** → Move prediction and scoring

---

## DSA Concepts Related to Binary Trees

- **Traversal Techniques**
    - DFS → Inorder, Preorder, Postorder
    - BFS → Level Order Traversal

- **Time Complexity**
    - Traversal → `O(n)`
    - Search (Balanced Tree) → `O(log n)`
    - Search (Skewed Tree) → `O(n)`

- **Space Complexity**
    - Recursive DFS → `O(h)` (height of tree)
    - BFS → `O(n)` (queue in worst case)

- **Height vs Depth**
    - Height → longest path from node → leaf
    - Depth → distance from root → node

- **Binary Tree vs Binary Search Tree (BST)**
    - Binary Tree → no ordering
    - BST → left < root < right

- **Recursion Pattern**
    - Most tree problems follow:
        - Solve for left subtree
        - Solve for right subtree
        - Combine results

---

## Coding / Frequently Asked Interview Problems

### Easy Level

- Inorder / Preorder / Postorder Traversal
- Level Order Traversal (BFS)
- Maximum Depth / Height of Binary Tree
- Count Total Nodes
- Search in Binary Tree

---

### Medium Level (Very Frequently Asked)

- Check if tree is **Balanced**
- Diameter of Binary Tree
- Lowest Common Ancestor (LCA)
- Check if two trees are **Identical**
- Check if tree is **Symmetric (Mirror)**
- Path Sum (root-to-leaf problems)
- Zigzag Level Order Traversal
- Boundary Traversal

---

### Hard / Advanced (Common in Good Product Companies)

- Serialize & Deserialize Binary Tree
- Binary Tree Maximum Path Sum
- Construct Tree from:
    - Inorder + Preorder
    - Inorder + Postorder
- Flatten Binary Tree to Linked List
- Convert Sorted Array → Balanced BST
- Vertical Order Traversal
- Top View / Bottom View

---

## Patterns to Recognize

- **DFS + Recursion**
    - Most common approach
    - Used for height, path, validation problems

- **BFS + Queue**
    - Used for level-based problems
    - Example: level order, shortest path

- **Divide & Conquer**
    - Solve left + right, combine results
    - Example: diameter, balanced tree

- **Backtracking (Tree Paths)**
    - Used in path sum problems

---

## Quick Interview Tips

- Clarify constraints:
    - Null root?
    - Tree size?

- Think in terms of:
    - Recursive structure
    - Subtree problems

- Always handle edge cases:
    - Empty tree
    - Single node
    - Skewed tree

- Default approach:
    - Start with DFS (recursion)
    - Optimize later if needed
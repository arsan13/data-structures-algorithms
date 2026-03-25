# Binary Search Tree (BST) – Interview Revision Notes

---

## Quick Summary

- **Binary Search Tree (BST)**: A binary tree with ordering property:
    - **Left subtree** → values < root
    - **Right subtree** → values > root

---

## Key Properties

- Inorder traversal of BST → **sorted order**
- No duplicate values (in standard BST)
- Efficient search if tree is balanced

---

## DSA Concepts

- **Time Complexity**
    - Search → `O(log n)` (balanced)
    - Insert → `O(log n)`
    - Delete → `O(log n)`

- **Worst Case (Skewed Tree)**
    - All operations → `O(n)`

---

## Core Operations

### 1. Search

- Compare with root:
    - If smaller → go left
    - If larger → go right

---

### 2. Insert

- Traverse to correct position
- Insert as leaf node

---

### 3. Delete

#### Cases:

1. **Leaf Node**
    - Simply remove

2. **One Child**
    - Replace node with child

3. **Two Children**
    - Replace with:
        - **Inorder Successor** (smallest in right subtree) OR
        - **Inorder Predecessor** (largest in left subtree)

---

## Important Concepts

### Inorder Successor
- Next greater element
- Leftmost node in right subtree

---

### Inorder Predecessor
- Next smaller element
- Rightmost node in left subtree

---

### Balanced BST

- Height ≈ `log n`
- Examples:
    - AVL Tree
    - Red-Black Tree

---

## Real-World Examples

- **Database Indexing**
- **Autocomplete Systems**
- **Sorted Data Storage**
- **Search Operations**

---

## Coding / Frequently Asked Interview Problems

### Easy

- Search in BST
- Insert into BST
- Inorder Traversal

---

### Medium (Very Common)

- Validate BST
- Lowest Common Ancestor (BST)
- Kth Smallest Element
- Convert Sorted Array → BST
- BST Iterator

---

### Hard

- Delete Node in BST
- Recover BST (swapped nodes)
- Serialize & Deserialize BST

---

## Patterns to Recognize

- **BST Property Usage**
    - Avoid full traversal
    - Prune search space

- **Inorder Traversal**
    - Gives sorted order

- **Divide & Conquer**
    - Solve left and right subtrees

---

## Common Interview Questions

### Conceptual

1. What is a BST?
2. Difference between Binary Tree and BST?
3. What is inorder traversal?
4. What is successor/predecessor?
5. What happens if BST becomes skewed?

---

### Coding

1. Validate BST
2. Find Kth smallest element
3. LCA in BST
4. Insert/Delete node
5. Convert sorted array to BST

---

## Edge Cases

- Empty tree
- Single node
- Skewed tree
- Duplicate values

---

## Quick Tips

- Use BST property:
    - Skip unnecessary branches

- Always think:
    - “Can I avoid visiting all nodes?”

- For sorted output:
    - Use **inorder traversal**

- Watch for:
    - Edge cases in delete operation
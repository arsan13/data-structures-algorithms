# Sorting – Interview Revision Notes

---

## Quick Summary

- **Sorting**: Arranging elements in a specific order (ascending/descending)
- Fundamental for:
    - Searching
    - Optimization problems
    - Data organization

---

## Types of Sorting Algorithms

| Algorithm       | Time Complexity (Avg) | Space | Stable | Notes |
|----------------|----------------------|-------|--------|------|
| Bubble Sort    | `O(n^2)`             | O(1)  | Yes    | Simple, rarely used |
| Selection Sort | `O(n^2)`             | O(1)  | No     | Fewer swaps |
| Insertion Sort | `O(n^2)`             | O(1)  | Yes    | Good for small/nearly sorted |
| Merge Sort     | `O(n log n)`         | O(n)  | Yes    | Divide & conquer |
| Quick Sort     | `O(n log n)`         | O(log n) | No | Fast in practice |
| Heap Sort      | `O(n log n)`         | O(1)  | No     | Uses heap |
| Counting Sort  | `O(n + k)`           | O(k)  | Yes    | Non-comparison |
| Radix Sort     | `O(nk)`              | O(n + k) | Yes | Digit-based |

---

## DSA Concepts Related to Sorting

- **Comparison vs Non-Comparison Sort**
    - Comparison → Bubble, Merge, Quick
    - Non-comparison → Counting, Radix

- **Stable Sorting**
    - Maintains relative order of equal elements
    - Important in multi-level sorting

- **In-place Sorting**
    - Uses `O(1)` extra space

- **Divide & Conquer**
    - Merge Sort, Quick Sort

---

## Important Algorithms

### Merge Sort

- Divide array into halves
- Recursively sort
- Merge results

**Time Complexity**: `O(n log n)`  
**Space Complexity**: `O(n)`

---

### Quick Sort

- Choose pivot
- Partition array
- Recursively sort partitions

**Time Complexity**:
- Average → `O(n log n)`
- Worst → `O(n^2)`

---

### Heap Sort

- Build heap
- Extract elements one by one

**Time Complexity**: `O(n log n)`  
**Space Complexity**: `O(1)`

---

## Coding / Frequently Asked Interview Problems

### Easy

- Sort array using built-in methods
- Sort 0s, 1s, 2s (Dutch National Flag)

---

### Medium (Very Common)

- Merge Intervals
- Sort Colors
- Kth Largest Element
- Top K Frequent Elements
- Relative Sort Array

---

### Hard

- Count Inversions (Merge Sort based)
- Reverse Pairs
- External Sorting (large data)

---

## Patterns to Recognize

- **Divide & Conquer**
    - Merge Sort, Quick Sort

- **Partitioning**
    - Quick Sort

- **Heap-based Sorting**
    - Top K problems

- **Counting / Bucketing**
    - When range is limited

---

## Common Interview Questions

### Conceptual

1. Difference between Merge Sort and Quick Sort?
2. What is stable sorting?
3. Which sorting is best for nearly sorted array?
4. Why is Quick Sort faster in practice?
5. Difference between comparison and non-comparison sort?

---

### Coding

1. Implement Merge Sort
2. Implement Quick Sort
3. Sort Colors (0s,1s,2s)
4. Find Kth largest element
5. Count inversions

---

## When to Use What

- **Small / Nearly Sorted Data**
    - Insertion Sort

- **Guaranteed Performance**
    - Merge Sort

- **In-place & Fast**
    - Quick Sort

- **Top K / Priority**
    - Heap Sort / Heap

- **Limited Range**
    - Counting Sort

---

## Quick Tips

- Default choice:
    - Use **Quick Sort / Merge Sort**

- Watch for:
    - Stability requirement
    - Space constraints

- Interview hint:
    - Built-in sort often uses **Hybrid (TimSort)**

- Think:
    - “Do I really need full sort or just Top K?”
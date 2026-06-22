# Binary Search – Interview Revision Notes

---

## Quick Summary

- **Binary Search**: Efficient searching algorithm that works on **sorted data**
- Repeatedly divides the search space into half
- Time Complexity → `O(log n)`

---

## When to Use

- Array is **sorted**
- Need **fast search**
- Search space can be **halved**
- Problems asking:
    - “Find element”
    - “Minimum/Maximum possible value”
    - “Search in range”

---

## Basic Algorithm

1. Initialize:
    - `low = 0`, `high = n - 1`
2. While `low <= high`:
    - `mid = low + (high - low) / 2`
3. Compare:
    - If `arr[mid] == target` → return index
    - If `arr[mid] < target` → search right (`low = mid + 1`)
    - Else → search left (`high = mid - 1`)

---

## DSA Concepts Related to Binary Search

- **Time Complexity**
    - Search → `O(log n)`

- **Space Complexity**
    - Iterative → `O(1)`
    - Recursive → `O(log n)`

- **Binary Search vs Linear Search**
    - Binary → fast, needs sorted array
    - Linear → slow, works on any array

---

## Variants of Binary Search

- **Standard Binary Search**
- **Lower Bound**
    - First element ≥ target
- **Upper Bound**
    - First element > target
- **First Occurrence**
- **Last Occurrence**

---

## Coding / Frequently Asked Interview Problems

### Easy

- Binary Search (basic)
- First and Last Occurrence
- Count occurrences of element
- Square Root of number

---

### Medium (Very Common)

- Search in Rotated Sorted Array
- Find Peak Element
- Minimum in Rotated Sorted Array
- Search Insert Position
- Find Floor / Ceil

---

### Hard

- Median of Two Sorted Arrays
- Kth Smallest Element in Sorted Matrix
- Allocate Books
- Aggressive Cows (Binary Search on Answer)

---

## Binary Search on Answer (Important Pattern)

- Used when:
    - Answer lies in a **range**
    - Need to find **minimum/maximum valid value**

### Steps

1. Define search space (low → high)
2. Pick mid
3. Check if mid is **valid**
4. Adjust search space

---

## Patterns to Recognize

- **Sorted Array Search**
- **Rotated Array Problems**
- **Peak / Valley Problems**
- **Binary Search on Answer**
- **Monotonic Function**
    - Condition changes from false → true

---

## Common Interview Questions

### Conceptual

1. When can we use Binary Search?
2. Why does Binary Search require sorted data?
3. What is overflow issue in mid calculation?
4. Difference between lower bound and upper bound?
5. What is Binary Search on Answer?

---

### Coding

1. Implement Binary Search
2. First & Last Occurrence
3. Search in Rotated Sorted Array
4. Find Peak Element
5. Allocate Books problem

---

## Edge Cases

- Empty array
- Single element
- Element not present
- Duplicate elements

---

## Quick Tips

- Always check:
    - Is array sorted?

- Use safe mid:
    - `mid = low + (high - low) / 2`

- Think:
    - “Can I reduce search space by half?”

- For tricky problems:
    - Convert into **binary search on answer**

- Watch for:
    - Infinite loops (wrong condition updates)
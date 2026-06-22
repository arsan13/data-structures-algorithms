# Heap (Priority Queue) & Greedy – Interview Revision Notes

---

# Heap (Priority Queue)

## Quick Summary

- **Heap**: A specialized tree-based data structure that satisfies the **heap property**
- Typically implemented as a **Complete Binary Tree**
- Two types:
    - **Min Heap** → Parent ≤ Children
    - **Max Heap** → Parent ≥ Children

---

## Key Properties

- **Complete Binary Tree**
    - All levels filled except last
    - Last level filled from left to right

- **Heap Property**
    - Min Heap → smallest element at root
    - Max Heap → largest element at root

- **Array Representation**
    - Parent index → `i`
    - Left child → `2i + 1`
    - Right child → `2i + 2`
    - Parent → `(i - 1) / 2`

---

## Real-World Examples

- **Priority Queues** → Task scheduling
- **CPU Scheduling** → Process priority
- **Dijkstra’s Algorithm** → Shortest path
- **Heap Sort** → Sorting
- **Top K Problems** → Efficient selection

---

## DSA Concepts Related to Heap

- **Time Complexity**
    - Insert → `O(log n)`
    - Delete → `O(log n)`
    - Peek → `O(1)`
    - Build Heap → `O(n)`

- **Space Complexity**
    - `O(n)`

- **Heap vs BST**
    - Heap → partial order
    - BST → full order

---

## Core Operations

- **Insert (Heapify Up)**
- **Delete Root (Heapify Down)**
- **Peek (Get Root)**

---

## Coding / Frequently Asked Interview Problems

### Easy
- Implement Heap
- Heap Sort

### Medium (Very Common)
- Kth Largest Element
- Top K Frequent Elements
- Merge K Sorted Lists
- K Closest Points

### Hard
- Median from Data Stream
- Sliding Window Median
- Smallest Range Covering K Lists

---

## Patterns to Recognize

- **Top K Elements**
- **Kth Smallest / Largest**
- **Two Heaps Pattern**
- **Merge K Sorted Inputs**

---

## Quick Tips

- Use heap when:
    - Need **min/max efficiently**
    - Need **top K elements**

- Java:
    - `PriorityQueue` → Min Heap by default

---

# Greedy Algorithm

## Quick Summary

- **Greedy**: Make the **locally optimal choice** at each step hoping for a **global optimum**

---

## When to Use

- Optimization problems
- Minimum / Maximum problems
- When choices are **independent**
- When problem has:
    - **Greedy Choice Property**
    - **Optimal Substructure**

---

## Real-World Examples

- **Coin Change (minimum coins)**
- **Activity Selection (max meetings)**
- **Job Scheduling**
- **Huffman Coding (compression)**
- **Fractional Knapsack**

---

## DSA Concepts Related to Greedy

- **Time Complexity**
    - Usually `O(n log n)` (due to sorting)

- **Key Idea**
    - Sort input
    - Pick best choice at each step

- **Greedy vs DP**
    - Greedy → faster, not always correct
    - DP → guaranteed optimal

---

## Coding / Frequently Asked Interview Problems

### Easy

- Assign Cookies
- Lemonade Change

---

### Medium (Very Common)

- Activity Selection
- Fractional Knapsack
- Job Scheduling with Deadlines
- Minimum Number of Platforms
- Gas Station Problem

---

### Hard

- Candy Distribution
- Minimum Number of Arrows to Burst Balloons
- Non-overlapping Intervals
- Jump Game II

---

## Patterns to Recognize

- **Sorting + Selection**
    - Sort by:
        - End time
        - Profit
        - Weight/value ratio

- **Interval Problems**
    - Merge / select non-overlapping intervals

- **Greedy + Heap**
    - Combine both for optimization

---

## Common Interview Questions

### Conceptual

1. What is Greedy Algorithm?
2. When does Greedy fail?
3. Difference between Greedy and DP?
4. What is Greedy Choice Property?
5. What is Optimal Substructure?

---

### Coding

1. Activity Selection
2. Fractional Knapsack
3. Job Scheduling
4. Gas Station
5. Jump Game

---

## Quick Tips

- Always ask:
    - “Can I make a local optimal choice?”

- If unsure:
    - Try greedy → validate with counterexample

- Most problems involve:
    - **Sorting + picking**
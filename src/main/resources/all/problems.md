````md id="dsa-patterns-01"
# 🧠 DSA PATTERNS – MASTER DOCUMENT (INTERVIEW READY)

---

# 🔍 1. TWO POINTERS

## When to Use
- Sorted arrays
- Pair problems
- Palindrome checks

## Pattern
```text
left = 0, right = n-1
while (left < right):
    if condition:
        move pointers
````

## Problems

* Two Sum (sorted)
* 3Sum
* Container With Most Water
* Valid Palindrome

---

# 🪟 2. SLIDING WINDOW

## When to Use

* Subarray / substring problems
* Contiguous elements

## Pattern

```text
expand window (right++)
shrink window (left++)
```

## Types

* Fixed window
* Variable window

## Problems

* Longest substring without repeating
* Max sum subarray of size k
* Minimum window substring

---

# ➕ 3. PREFIX SUM

## When to Use

* Range sum queries
* Subarray sum problems

## Pattern

```text
prefix[i] = prefix[i-1] + arr[i]
```

## Problems

* Subarray sum = k
* Range sum query

---

# 🔑 4. HASHING

## When to Use

* Fast lookup
* Frequency counting

## Patterns

* Map for frequency
* Set for uniqueness

## Problems

* Two Sum
* Group Anagrams
* Longest consecutive sequence

---

# 🌳 5. TREE TRAVERSAL

## Types

* DFS → Inorder, Preorder, Postorder
* BFS → Level order

## Problems

* Level order traversal
* Diameter of tree
* LCA

---

# 🌐 6. GRAPH TRAVERSAL

## Patterns

* BFS → shortest path
* DFS → exploration

## Problems

* Number of islands
* Detect cycle
* Course schedule

---

# 🔁 7. BACKTRACKING

## When to Use

* Generate all combinations/permutations

## Pattern

```text
choose
explore
un-choose (backtrack)
```

## Problems

* N Queens
* Subsets
* Permutations
* Sudoku Solver

---

# 🧮 8. DYNAMIC PROGRAMMING

## When to Use

* Overlapping subproblems
* Optimization

## Steps

1. Define state
2. Transition
3. Base case

## Patterns

* 1D DP
* 2D DP
* Knapsack
* LCS

---

# 🎯 9. GREEDY

## When to Use

* Local optimal leads to global optimal

## Problems

* Jump Game
* Activity selection
* Gas station

---

# 🔍 10. BINARY SEARCH

## When to Use

* Sorted data
* Search space reduction

## Pattern

```text
while (low <= high):
    mid = (low + high) / 2
```

## Advanced

* Binary search on answer

## Problems

* Search in rotated array
* Find peak element

---

# 📊 11. MONOTONIC STACK

## Types

* Increasing stack
* Decreasing stack

## Use

* Next greater/smaller element

## Problems

* Next greater element
* Largest rectangle in histogram
* Daily temperatures

---

# 🧱 12. HEAP / PRIORITY QUEUE

## When to Use

* Top K problems
* Min/Max retrieval

## Problems

* Top K frequent elements
* Kth largest element
* Merge k sorted lists

---

# 🔗 13. UNION FIND (DISJOINT SET)

## When to Use

* Connectivity
* Cycle detection

## Operations

* Find
* Union

## Problems

* Number of connected components
* Detect cycle
* Kruskal’s MST

---

# 🌲 14. TRIE

## When to Use

* Prefix matching

## Problems

* Implement Trie
* Word search
* Autocomplete

---

# 🔢 15. BIT MANIPULATION

## Tricks

* `n & (n-1)` → remove last set bit
* XOR properties

## Problems

* Single number
* Counting bits

---

# 📐 16. INTERVALS

## When to Use

* Overlapping ranges

## Pattern

1. Sort intervals
2. Merge / process

## Problems

* Merge intervals
* Meeting rooms
* Insert interval

---

# 📉 17. MATRIX / GRID

## Pattern

* Treat as graph
* Use BFS/DFS

## Problems

* Number of islands
* Flood fill
* Rotten oranges

---

# 🧩 18. FAST & SLOW POINTER

## When to Use

* Cycle detection

## Pattern

```text
slow = slow.next
fast = fast.next.next
```

## Problems

* Detect cycle in linked list
* Find middle node

---

# ⚡ FINAL INTERVIEW STRATEGY

## How to Identify Pattern

Ask:

1. Is it array/string → sliding window / two pointers?
2. Need fast lookup → hashing?
3. Optimization → DP / Greedy?
4. Graph-like → BFS/DFS?
5. Sorted → binary search?
6. Combinations → backtracking?

---

# 🏁 GOLDEN RULE

👉 Most problems are just **variations of these patterns**

Master these → you can solve **80–90% of interview questions**

```
```

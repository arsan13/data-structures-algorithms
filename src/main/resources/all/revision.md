````md id="dsa-ultra-cheatsheet-01"
# 🚀 DSA ULTRA CHEAT SHEET (FAST REVISION)

---

# 🧠 CORE IDEA

👉 Identify pattern → Apply template → Optimize

---

# 🔍 PATTERN QUICK MAP

| Problem Type | Pattern |
|-------------|--------|
| Sorted array | Binary Search / Two Pointers |
| Subarray/Substring | Sliding Window |
| Frequency / Lookup | Hashing |
| Tree/Hierarchy | DFS/BFS |
| Graph/Connections | BFS/DFS/Union-Find |
| Optimization | DP / Greedy |
| Combinations | Backtracking |
| Top K / Min-Max | Heap |
| Range queries | Prefix Sum / Fenwick |

---

# 🔄 TWO POINTERS

```text id="tp"
l = 0, r = n-1
while l < r:
    move pointers
````

Use:

* Sorted arrays
* Pair problems

---

# 🪟 SLIDING WINDOW

```text id="sw"
expand right
shrink left
```

Use:

* Substrings / subarrays

---

# ➕ PREFIX SUM

```text id="ps"
prefix[i] = prefix[i-1] + arr[i]
```

Use:

* Range sum
* Subarray sum = k

---

# 🔑 HASHING

* Map → frequency
* Set → existence

Use:

* Two Sum
* Anagrams
* Duplicates

---

# 🌳 TREE

## DFS

* Pre / In / Post

## BFS

* Level order

---

# 🌐 GRAPH

* BFS → shortest path (unweighted)
* DFS → cycle / exploration
* Union-Find → connectivity

---

# 🔁 BACKTRACKING

```text id="bt"
choose → explore → unchoose
```

Use:

* Permutations
* Combinations

---

# 🧮 DYNAMIC PROGRAMMING

## Steps

1. State
2. Transition
3. Base case

## Common:

* Fibonacci
* Knapsack
* LCS

---

# 🎯 GREEDY

* Local optimal → global optimal

Use:

* Jump Game
* Interval problems

---

# 🔍 BINARY SEARCH

```text id="bs"
mid = (l+r)/2
```

Use:

* Sorted arrays
* Answer search

---

# 📊 MONOTONIC STACK

Use:

* Next greater/smaller

Problems:

* Histogram
* Daily temps

---

# 🧱 HEAP

* Min / Max heap

Use:

* Top K
* Kth largest

---

# 🔗 UNION FIND

* Find + Union

Use:

* Cycle detection
* Components

---

# 🌲 TRIE

Use:

* Prefix search
* Dictionary problems

---

# 🔢 BIT MANIPULATION

* `n & (n-1)` → remove last set bit
* XOR tricks

---

# 📐 INTERVALS

* Sort + merge

---

# 📉 MATRIX / GRID

* Treat as graph
* Use BFS/DFS

---

# ⚡ COMPLEXITY CHEAT

| Operation     | Time      |
| ------------- | --------- |
| HashMap       | O(1)      |
| Binary Search | O(log n)  |
| DFS/BFS       | O(V+E)    |
| Heap          | O(log n)  |
| DP            | O(n / n²) |

---

# ⚠️ EDGE CASES

* Empty input
* Single element
* Duplicates
* Large input

---

# 🧠 PROBLEM APPROACH

1. Clarify
2. Brute force
3. Optimize (pattern)
4. Dry run
5. Code
6. Analyze

---

# 💻 TOP MUST-DO

* Two Sum
* 3Sum
* Longest Substring
* Number of Islands
* Course Schedule
* Coin Change
* LCA
* Kth Largest
* Merge Intervals
* Binary Search

---

# 🚨 INTERVIEW TIPS

* Think out loud
* Write clean code
* Handle edge cases
* Optimize if possible

---

# 🏁 GOLDEN RULE

👉 90% problems = **pattern recognition**

🔥 Revise this daily → you’re interview ready

```
```

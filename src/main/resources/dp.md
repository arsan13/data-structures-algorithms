````md id="dp-notes-faang-01"
# Dynamic Programming (DP) – Interview Revision Notes (FAANG Ready)

---

## Quick Summary

- **Dynamic Programming**: Optimization technique to solve problems by:
  - Breaking into **overlapping subproblems**
  - Storing results to **avoid recomputation**

---

## When to Use DP

- Problem involves:
  - **Overlapping subproblems**
  - **Optimal substructure**

- Keywords:
  - “Maximum / Minimum”
  - “Count ways”
  - “Number of ways”
  - “Best / Optimal”

---

## Core Concepts

### 1. Overlapping Subproblems
- Same subproblem solved multiple times

### 2. Optimal Substructure
- Optimal solution built from optimal subproblems

---

## Approaches

### 1. Memoization (Top-Down)
- Recursion + caching

```java
int dp[] = new int[n];

int solve(int i) {
    if (base_case) return value;

    if (dp[i] != -1) return dp[i];

    return dp[i] = solve(subproblem);
}
````

---

### 2. Tabulation (Bottom-Up)

* Iterative approach

```java
int dp[] = new int[n];

dp[0] = base;

for (int i = 1; i < n; i++) {
    dp[i] = transition;
}
```

---

### 3. Space Optimization

* Reduce DP array → variables

---

## DSA Concepts

* **Time Complexity**

    * Usually `O(n)` / `O(n^2)`

* **Space Complexity**

    * `O(n)` → can optimize to `O(1)`

---

## Common DP Patterns

### 1. 1D DP

* Fibonacci
* Climbing Stairs
* House Robber

---

### 2. 2D DP

* Grid problems
* Unique Paths
* Minimum Path Sum

---

### 3. Knapsack Pattern

* 0/1 Knapsack
* Subset Sum
* Partition Equal Subset

---

### 4. Longest Subsequence Pattern

* Longest Increasing Subsequence (LIS)
* Longest Common Subsequence (LCS)
* Longest Palindromic Subsequence

---

### 5. String DP

* Edit Distance
* Palindrome Partitioning
* Distinct Subsequences

---

### 6. Interval DP

* Matrix Chain Multiplication
* Burst Balloons

---

### 7. DP on Trees

* Tree DP (post-order traversal)

---

## Coding / Frequently Asked Interview Problems

### Easy

* Fibonacci
* Climbing Stairs
* House Robber

---

### Medium (Very Common)

* Coin Change
* Longest Increasing Subsequence
* Longest Common Subsequence
* Partition Equal Subset Sum
* Unique Paths

---

### Hard / Advanced

* Edit Distance
* Matrix Chain Multiplication
* Burst Balloons
* Palindrome Partitioning II
* Distinct Subsequences

---

## How to Approach DP Problems

1. Identify if DP is applicable

2. Define **state**

    * `dp[i]` or `dp[i][j]`

3. Define **transition**

    * How current state depends on previous

4. Define **base case**

5. Choose:

    * Memoization or Tabulation

---

## Common Interview Questions

### Conceptual

1. What is Dynamic Programming?
2. Difference between DP and Greedy?
3. Memoization vs Tabulation?
4. How to identify DP problems?
5. What is state transition?

---

### Coding

1. Climbing Stairs
2. Coin Change
3. Longest Common Subsequence
4. LIS
5. Edit Distance

---

## Patterns to Recognize

* **Choice Diagram**

    * Include / exclude

* **Min / Max Optimization**

* **Counting Ways**

* **Subsequence / Subarray**

* **Partition Problems**

---

## Quick Tips

* Start with recursion → optimize with DP

* Clearly define:

    * State
    * Transition

* Try:

    * Reduce dimensions (2D → 1D)

* Watch for:

    * Initialization errors
    * Wrong state definition

* Think:

    * “Can I store and reuse results?”

```
```

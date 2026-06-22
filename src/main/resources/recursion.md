````md id="rec-backtrack-consolidated-01"
# Recursion & Backtracking – Interview Revision Notes

---

## Quick Summary

- **Recursion**: Solve problems by breaking them into smaller subproblems of the same type  
- **Backtracking**: Explore all possibilities and **undo choices** when a path is invalid  

---

## Core Idea

- Recursion → “Solve smaller problem”  
- Backtracking → “Try → Explore → Undo”  

---

## Core Components

### Base Case
- Condition to stop recursion

### Recursive Case
- Function calls itself with smaller input

---

## Unified Template

```java
void solve(params) {
    // base case
    if (condition) {
        // add result (if needed)
        return;
    }

    for (choice in choices) {
        // choose
        make_choice();

        // explore
        solve(updated_params);

        // undo (backtrack)
        undo_choice();
    }
}
````

---

## DSA Concepts

* **Time Complexity**

    * Recursion → depends on calls (can be `O(n)` to exponential)
    * Backtracking → usually exponential (`O(2^n)`, `O(n!)`)

* **Space Complexity**

    * `O(h)` → recursion stack height
    * Typically `O(n)`

* **Recursion Tree**

    * Visual representation of calls (important for analysis)

---

## Common Patterns

### 1. Linear Recursion

* One recursive call
* Example: Factorial

---

### 2. Tree Recursion

* Multiple recursive calls
* Example: Fibonacci

---

### 3. Backtracking Patterns

* **Include / Exclude**

    * Choose or skip element
    * Example: Subsets

* **Permutation Pattern**

    * Swap or mark visited

* **Constraint Satisfaction**

    * Validate before going deeper

---

## Coding / Frequently Asked Interview Problems

### Easy

* Factorial
* Fibonacci
* Print numbers (1 to N, N to 1)
* Sum of digits

---

### Medium (Very Common)

* Reverse Array / String
* Check Palindrome
* Power (x^n)
* Generate Subsets
* Generate Permutations

---

### Hard / Advanced

* N-Queens
* Sudoku Solver
* Word Search
* Rat in a Maze
* Combination Sum

---

## How to Identify Backtracking Problems

* Need **all possible combinations / permutations**
* Problem says:

    * “Find all ways”
    * “Generate all”
    * “Return all combinations”

---

## Common Interview Questions

### Conceptual

1. What is recursion?
2. What is backtracking?
3. Difference between recursion and backtracking?
4. What is base case?
5. What happens if base case is missing?
6. Why is backtracking expensive?

---

### Coding

1. Generate subsets
2. Generate permutations
3. Solve N-Queens
4. Sudoku solver
5. Combination sum

---

## Quick Tips

* Always:

    * Define **base case first**
    * Dry run recursion tree

* In backtracking:

    * **Undo changes after recursion**

* Optimize:

    * Prune invalid paths early

* Think:

    * “Can I break this into smaller problem?”
    * “Do I need to try all possibilities?”

```
```

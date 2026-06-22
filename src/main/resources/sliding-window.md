# Two Pointers & Sliding Window – Interview Revision Notes

---

# Two Pointers

## Quick Summary

- **Two Pointers**: Technique where two indices traverse the data structure (usually array/string)
- Used to optimize brute force `O(n^2)` → `O(n)`

---

## When to Use

- Sorted arrays
- Pair problems (sum, difference)
- Removing duplicates
- Reversing / rearranging

---

## Common Patterns

- **Opposite Direction**
    - One pointer at start, one at end
    - Example: Two Sum (sorted array)

- **Same Direction (Fast & Slow)**
    - Both pointers move forward
    - Example: Remove duplicates, partitioning

- **Sliding Window Variant**
    - Expanding + shrinking window

---

## DSA Concepts

- **Time Complexity**
    - Usually `O(n)`

- **Space Complexity**
    - `O(1)`

- **Precondition**
    - Often requires **sorted input**

---

## Coding / Frequently Asked Interview Problems

### Easy

- Two Sum (sorted array)
- Remove Duplicates from Sorted Array
- Reverse Array / String
- Move Zeroes

---

### Medium (Very Common)

- Container With Most Water
- 3Sum / 4Sum
- Remove Duplicates II
- Sort Colors (Dutch National Flag)
- Partition Array

---

### Hard

- Trapping Rain Water (two pointer approach)
- Minimum Window Substring (variant)

---

## Patterns to Recognize

- **Left + Right Movement**
    - Adjust pointers based on condition

- **Fast & Slow Pointer**
    - Used in:
        - Cycle detection (linked list)
        - Finding middle

- **Shrink/Grow Strategy**
    - Move pointers to maintain condition

---

## Quick Tips

- Check if array is **sorted**
- Think:
    - “Can I reduce nested loops?”
- Avoid recalculating → reuse pointer movement

---

# Sliding Window

## Quick Summary

- **Sliding Window**: Subarray/substring range that expands and contracts dynamically
- Used for **contiguous subarrays**

---

## Types of Sliding Window

- **Fixed Size Window**
    - Window size `k` is constant

- **Variable Size Window**
    - Window grows/shrinks based on condition

---

## When to Use

- Subarray / substring problems
- Maximum / minimum / count problems
- Problems involving **contiguous elements**

---

## DSA Concepts

- **Time Complexity**
    - `O(n)`

- **Space Complexity**
    - `O(1)` or `O(k)` (for hashmap/set)

- **Core Idea**
    - Expand → process → shrink

---

## Coding / Frequently Asked Interview Problems

### Easy

- Maximum Sum Subarray of Size K
- Average of Subarrays
- First Negative Number in Window

---

### Medium (Very Common)

- Longest Substring Without Repeating Characters
- Longest Repeating Character Replacement
- Minimum Size Subarray Sum
- Permutation in String
- Count Occurrences of Anagrams

---

### Hard

- Minimum Window Substring
- Sliding Window Maximum (Deque)
- Subarrays with K Distinct Integers

---

## Patterns to Recognize

- **Expand Window**
    - Move right pointer

- **Shrink Window**
    - Move left pointer

- **Use HashMap / Set**
    - Track frequency or uniqueness

- **Maintain Valid Window**
    - Condition-based shrinking

---

## Common Interview Questions

### Conceptual

1. Difference between Two Pointers and Sliding Window?
2. When to use Sliding Window?
3. Fixed vs Variable window?
4. Why is Sliding Window efficient?

---

### Coding

1. Longest substring without repeating characters
2. Minimum window substring
3. Maximum sum subarray of size K
4. Sliding window maximum
5. Count anagrams in a string

---

## Quick Tips

- Use sliding window when:
    - Problem involves **contiguous subarray/substring**

- Key thinking:
    - “Can I reuse previous window computation?”

- Watch for:
    - Shrinking condition mistakes
    - Edge cases (empty string, k > n)
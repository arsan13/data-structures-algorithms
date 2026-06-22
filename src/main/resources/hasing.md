# Hashing – Interview Revision Notes

---

## Quick Summary

- **Hashing**: Technique to map data to a fixed-size value using a **hash function**
- Enables **fast lookup, insertion, deletion**

---

## Core Idea

- Key → Hash Function → Index
- Store data in **Hash Table**

---

## Common Data Structures

- **HashMap (Dictionary)**
    - Key → Value mapping

- **HashSet**
    - Stores unique elements

---

## DSA Concepts Related to Hashing

- **Time Complexity (Average)**
    - Insert → `O(1)`
    - Delete → `O(1)`
    - Search → `O(1)`

- **Worst Case**
    - `O(n)` (due to collisions)

---

## Hash Collisions

- Occurs when:
    - Two keys map to same index

### Collision Handling Techniques

- **Chaining**
    - Store list at same index

- **Open Addressing**
    - Linear probing
    - Quadratic probing
    - Double hashing

---

## Real-World Examples

- **Databases** → Indexing
- **Caching** → Fast retrieval
- **Password Storage** → Hashing passwords
- **Duplicate Detection**

---

## Coding / Frequently Asked Interview Problems

### Easy

- Two Sum
- Contains Duplicate
- First Unique Character

---

### Medium (Very Common)

- Longest Consecutive Sequence
- Subarray Sum Equals K
- Group Anagrams
- Top K Frequent Elements
- Isomorphic Strings

---

### Hard

- Minimum Window Substring
- Subarrays with K Distinct Integers
- Longest Substring Without Repeating Characters

---

## Patterns to Recognize

- **Frequency Counting**
    - Count occurrences using map

- **Prefix Sum + HashMap**
    - Subarray sum problems

- **Set for Lookup**
    - Fast existence check

- **Key Transformation**
    - Convert data (e.g., sort string → anagram key)

---

## Common Interview Questions

### Conceptual

1. What is hashing?
2. What is a hash function?
3. What are collisions?
4. How to handle collisions?
5. Difference between HashMap and HashSet?

---

### Coding

1. Two Sum
2. Longest Consecutive Sequence
3. Subarray Sum Equals K
4. Group Anagrams
5. Top K Frequent Elements

---

## Quick Tips

- Use HashMap when:
    - Need **fast lookup**
    - Need to store **frequency**

- Use HashSet when:
    - Need to check **existence**

- Watch for:
    - Collisions (in theory)
    - Large input → memory usage

- Think:
    - “Can I trade space for time?”
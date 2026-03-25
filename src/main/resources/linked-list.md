# Linked List – Interview Revision Notes

---

## Quick Summary

- **Linked List**: Linear data structure where elements (nodes) are connected using **pointers/references**
- Each node contains:
    - `data`
    - `next` (pointer to next node)

---

## Types of Linked Lists

| Type                  | Description |
|----------------------|------------|
| Singly Linked List   | Each node points to next |
| Doubly Linked List   | Nodes have `prev` and `next` |
| Circular Linked List | Last node points to head |
| Circular Doubly LL   | Both directions + circular |

---

## Real-World Examples

- **Music Playlist** → Next/previous song (DLL)
- **Browser Navigation** → Back/forward (DLL)
- **Undo/Redo Systems** → Doubly linked list
- **Memory Management** → Dynamic allocation
- **HashMap (Chaining)** → Collision handling

---

## DSA Concepts Related to Linked List

- **Time Complexity**
    - Access → `O(n)`
    - Insert/Delete (given node) → `O(1)`
    - Search → `O(n)`

- **Space Complexity**
    - `O(n)`

- **Array vs Linked List**
    - Array → contiguous memory, fast access
    - LL → dynamic size, efficient insert/delete

- **Pointers are key**
    - Most bugs come from incorrect pointer handling

---

## Basic Operations

- Insert:
    - At head
    - At tail
    - At position

- Delete:
    - From head
    - From tail
    - By value/position

- Traverse:
    - Iterate from head to null

---

## Coding / Frequently Asked Interview Problems

### Easy

- Reverse a Linked List
- Find Middle of Linked List
- Detect Loop (Floyd’s Cycle Detection)
- Remove Duplicates (sorted list)
- Delete Node (given pointer)

---

### Medium (Very Common)

- Merge Two Sorted Lists
- Remove N-th Node from End
- Intersection of Two Linked Lists
- Palindrome Linked List
- Add Two Numbers (LL representation)
- Odd-Even Linked List

---

### Hard / Advanced

- Reverse Nodes in K Group
- Copy List with Random Pointer
- Flatten Multilevel Linked List
- LRU Cache (DLL + HashMap)
- Rotate Linked List

---

## Patterns to Recognize

- **Two Pointer Technique**
    - Slow & Fast pointer
    - Used in:
        - Cycle detection
        - Finding middle

- **Dummy Node Technique**
    - Simplifies edge cases

- **In-place Reversal**
    - Modify pointers without extra space

- **Divide & Conquer**
    - Merge sort on linked list

---

## Common Interview Questions

### Conceptual

1. Difference between Array and Linked List?
2. Why is Linked List preferred for insert/delete?
3. What is a Circular Linked List?
4. What is the advantage of Doubly Linked List?
5. What are disadvantages of Linked List?

---

### Coding

1. Reverse a Linked List
2. Detect cycle in Linked List
3. Merge two sorted lists
4. Find middle node
5. Remove N-th node from end

---

## Quick Tips

- Always draw the list before coding
- Be careful with:
    - `null` pointers
    - Losing head reference

- Use:
    - **Dummy node** to simplify logic
    - **Fast & slow pointers** for optimization

- Edge cases:
    - Empty list
    - Single node
    - Two nodes  
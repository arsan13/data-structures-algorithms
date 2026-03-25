# Stack & Queue – Interview Revision Notes

---

# Stack

## Quick Summary

- **Stack**: Linear data structure that follows **LIFO (Last In, First Out)**
- Core Operations:
    - `push(x)` → Insert element
    - `pop()` → Remove top element
    - `peek()` / `top()` → Get top element
    - `isEmpty()`

---

## Real-World Examples

- **Undo/Redo Operations** → Text editors
- **Call Stack** → Function calls & recursion
- **Expression Evaluation** → `(a + b) * c`
- **Browser History** → Back navigation
- **Parenthesis Matching** → Syntax validation

---

## DSA Concepts Related to Stack

- **Time Complexity**
    - Push → `O(1)`
    - Pop → `O(1)`
    - Peek → `O(1)`

- **Space Complexity**
    - `O(n)`

- **Implementation**
    - Array-based
    - Linked List-based

- **Recursion uses Stack**
    - Implicit function call stack

---

## Coding / Frequently Asked Interview Problems

### Easy
- Implement Stack (Array / Linked List)
- Valid Parentheses
- Min Stack

### Medium (Very Common)
- Next Greater Element
- Stock Span Problem
- Largest Rectangle in Histogram
- Evaluate Postfix Expression
- Infix → Postfix

### Hard
- Trapping Rain Water
- Maximal Rectangle
- Remove K Digits

---

## Patterns to Recognize

- **Monotonic Stack** → NGE, histogram
- **Expression Problems** → Prefix/Postfix
- **Parenthesis Matching**
- **Span Problems**

---

## Quick Tips

- Use when:
    - Need **previous greater/smaller**
    - Working with **nested structures**
- Always check for **empty stack**

---

# Queue

## Quick Summary

- **Queue**: Linear data structure that follows **FIFO (First In, First Out)**
- Core Operations:
    - `enqueue(x)` → Insert element
    - `dequeue()` → Remove front element
    - `front()` / `peek()` → Get front element
    - `isEmpty()`

---

## Types of Queue

- **Simple Queue** → Basic FIFO
- **Circular Queue** → Efficient memory usage
- **Deque (Double Ended Queue)** → Insert/delete from both ends
- **Priority Queue** → Elements served based on priority (Heap)

---

## Real-World Examples

- **Ticket Queue** → First come, first serve
- **CPU Scheduling** → Task processing
- **Printer Queue** → Print jobs
- **BFS Traversal** → Graph/Tree level traversal
- **Messaging Systems** → Queue-based processing

---

## DSA Concepts Related to Queue

- **Time Complexity**
    - Enqueue → `O(1)`
    - Dequeue → `O(1)`
    - Peek → `O(1)`

- **Space Complexity**
    - `O(n)`

- **Implementation**
    - Array (with circular indexing)
    - Linked List

- **Queue vs Stack**
    - Queue → FIFO
    - Stack → LIFO

---

## Coding / Frequently Asked Interview Problems

### Easy
- Implement Queue (Array / Linked List)
- Implement Circular Queue
- Reverse a Queue

### Medium (Very Common)
- Implement Queue using Stacks
- Implement Stack using Queues
- First Non-Repeating Character in Stream
- Sliding Window Maximum (Deque)
- Generate Binary Numbers

### Hard
- LRU Cache (Deque + HashMap)
- Task Scheduler
- Design Circular Deque

---

## Patterns to Recognize

- **BFS (Level Order Traversal)**
    - Trees & Graphs

- **Sliding Window + Deque**
    - Max/Min in window

- **Producer-Consumer Pattern**
    - System design

- **Priority Queue (Heap)**
    - Top K elements problems

---

## Common Interview Questions

### Conceptual

1. Difference between Stack and Queue?
2. What is FIFO?
3. What is Circular Queue?
4. What is Deque?
5. Where is Queue used in real-world?

---

### Coding

1. Implement Queue using Stacks
2. Sliding Window Maximum
3. BFS Traversal
4. Design LRU Cache
5. First non-repeating character

---

## Quick Tips

- Use queue when:
    - Order matters (**FIFO**)
    - Working with **level-wise traversal (BFS)**

- Use deque when:
    - Need both ends access

- Watch for:
    - Overflow (array implementation)
    - Empty queue before dequeue
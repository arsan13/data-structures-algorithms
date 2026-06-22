# Graph – Interview Revision Notes (FAANG Ready)

---

## Quick Summary

- **Graph**: Collection of **nodes (vertices)** and **edges**
- Models relationships, networks, and connections

---

## Types of Graphs

| Type              | Description |
|-------------------|------------|
| Undirected Graph  | No edge direction |
| Directed Graph    | Edges have direction |
| Weighted Graph    | Edges have weights |
| Unweighted Graph  | No weights |
| Cyclic Graph      | Contains cycles |
| Acyclic Graph     | No cycles |
| DAG               | Directed Acyclic Graph |

---

## Graph Representation

### Adjacency List (Most Used)
- Space → `O(V + E)`
- Efficient for sparse graphs

### Adjacency Matrix
- Space → `O(V^2)`
- Used for dense graphs

---

## Core Traversals

### BFS (Breadth First Search)
- Uses **Queue**
- Time → `O(V + E)`

**Use Cases**
- Shortest path (unweighted)
- Level-wise traversal
- Multi-source BFS

---

### DFS (Depth First Search)
- Uses **Recursion / Stack**
- Time → `O(V + E)`

**Use Cases**
- Cycle detection
- Backtracking
- Topological sort

---

## Important Algorithms

### 1. Dijkstra’s Algorithm
- Shortest path (no negative weights)
- Uses **Min Heap**

---

### 2. Bellman-Ford
- Handles **negative weights**
- Detects negative cycles

---

### 3. Floyd-Warshall
- All-pairs shortest path
- Time → `O(n^3)`

---

### 4. Minimum Spanning Tree (MST)

#### Prim’s Algorithm
- Uses Min Heap

#### Kruskal’s Algorithm
- Uses **Union-Find**

---

### 5. Union Find (Disjoint Set)

- Path compression + rank
- Used for:
    - Cycle detection
    - Connected components

---

### 6. Topological Sort

#### DFS Based
#### Kahn’s Algorithm (BFS)

**Use Cases**
- Course scheduling
- Dependency resolution

---

## Important Concepts

### Cycle Detection

- **Undirected Graph**
    - DFS / Union-Find

- **Directed Graph**
    - DFS + recursion stack

---

### Bipartite Graph

- Check using:
    - BFS / DFS (coloring)
- Key idea:
    - 2-coloring graph

---

### Strongly Connected Components (Advanced)

- Kosaraju’s Algorithm
- Tarjan’s Algorithm

---

## Grid-Based Graph Problems

- Treat grid as graph

**Examples**
- Number of Islands
- Flood Fill
- Rotten Oranges
- 01 Matrix

---

## Multi-Source BFS

- Start BFS from multiple nodes simultaneously

**Examples**
- Rotten Oranges
- 01 Matrix

---

## Coding / Frequently Asked Interview Problems

### Easy

- BFS / DFS Traversal
- Number of Connected Components

---

### Medium (Very Common)

- Number of Islands
- Clone Graph
- Detect Cycle (Directed / Undirected)
- Course Schedule (Topological Sort)
- Bipartite Graph

---

### Hard / Advanced

- Dijkstra’s Algorithm
- Word Ladder
- Minimum Spanning Tree
- Network Delay Time
- Shortest Path in Grid

---

## Patterns to Recognize

- **BFS**
    - Shortest path (unweighted)
    - Level traversal

- **DFS**
    - Exploration / recursion
    - Cycle detection

- **Union Find**
    - Connectivity problems

- **Topological Sort**
    - Dependency problems

- **Multi-source BFS**
    - Simultaneous spread problems

---

## Common Interview Questions

### Conceptual

1. BFS vs DFS?
2. When to use Dijkstra vs BFS?
3. What is DAG?
4. What is MST?
5. Difference between Prim’s and Kruskal’s?
6. What is Bipartite Graph?

---

### Coding

1. Number of Islands
2. Detect Cycle
3. Course Schedule
4. Shortest Path (Dijkstra)
5. Bipartite Graph check

---

## Quick Tips

- Always:
    - Track **visited nodes**

- Use BFS when:
    - Need shortest path (unweighted)

- Use DFS when:
    - Need full exploration

- Convert:
    - Grid → Graph when needed

- Think:
    - “Is this a graph problem?”
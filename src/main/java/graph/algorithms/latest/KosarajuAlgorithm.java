package graph.algorithms.latest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
Used to find Strongly connected components(SCCs).
A subgraph of a directed graph is considered to be an Strongly Connected Components(SCC) if and only if for every pair of vertices A and B, there exists a path from A to B and a path from B to A.

Steps (the matching code is marked with "Step N" comments in countSCC):
1. Compute finishing time of nodes in decreasing order.
   -> DFS over every unvisited node; push a node onto the stack AFTER all its neighbours are done.
      The top of the stack is then the node that finished last.
2. Reverse the direction of all edges in the graph to create the transposed graph.
   -> buildAdjList(..., isReverse = true)
3. Perform a DFS on the transposed graph, considering nodes in decreasing order of their finish times.
   -> Pop nodes from the stack (latest finish first), skipping those already visited.
4. Each DFS traversal in this phase will give us one SCC.
   -> Every DFS launched from the pop loop covers exactly one SCC, so count++ per launch.

Why finish time is needed:
- Goal: one DFS must collect exactly ONE SCC. That only happens if the DFS starts in an SCC with no edges leaving it.
  e.g. A<->B, B->C, C<->D: DFS from A reaches A,B,C,D (two SCCs merged), DFS from C reaches only C,D (correct).
- We don't know which SCC is a dead end, so step 1 finds it indirectly: the last node to finish is in the
  most "upstream" SCC (edges go out of it, none come in).
- Reversing the edges (step 2) flips upstream/downstream while keeping SCCs intact (A<->B stays A<->B),
  so that upstream SCC becomes the dead end. A DFS from it stays inside it.
- Popping by latest finish time guarantees we never start from a downstream SCC (C) before an upstream one (A),
  otherwise the DFS would leak into the upstream SCC (C->B->A) and merge them.
- Repeat: each DFS peels off one SCC, and the next unvisited stack node is upstream-most among what's left.

Time: O(V + E), Space: O(V + E)
 */
public class KosarajuAlgorithm {

    public int countSCC(int v, int[][] edges) {
        List<List<Integer>> adjList = buildAdjList(v, edges, false);

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];

        // Step 1: finish-time ordering. Start from every unvisited node to cover disconnected parts.
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited, stack);
            }
        }

        // Step 2: transpose the graph and reset visited for the second pass.
        adjList = buildAdjList(v, edges, true);
        Arrays.fill(visited, false);

        // Steps 3 & 4: process nodes by decreasing finish time; each fresh DFS is one SCC.
        int count = 0; // If SCC nodes are asked, use list instead of count and populate on each stack iteration
        while (!stack.isEmpty()) {
            int cur = stack.pop();

            if (!visited[cur]) {
                dfs(cur, adjList, visited);
                count++;
            }
        }

        return count;
    }

    private List<List<Integer>> buildAdjList(int v, int[][] edges, boolean isReverse) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            if (isReverse) {
                list.get(edge[1]).add(edge[0]);
            } else {
                list.get(edge[0]).add(edge[1]);
            }
        }

        return list;
    }

    // Pass 1 DFS: pushes the node only after all its descendants are explored (post-order = finish time).
    private void dfs(int src, List<List<Integer>> adjList, boolean[] visited, Stack<Integer> stack) {
        visited[src] = true;
        for (int v : adjList.get(src)) {
            if (!visited[v]) {
                dfs(v, adjList, visited, stack);
            }
        }
        stack.push(src);
    }

    // Pass 2 DFS: plain traversal on the transposed graph; marks every node of one SCC as visited.
    private void dfs(int src, List<List<Integer>> adjList, boolean[] visited) {
        visited[src] = true;
        for (int v : adjList.get(src)) {
            if (!visited[v]) {
                dfs(v, adjList, visited);
            }
        }
    }

    public static void main(String[] args) {
        KosarajuAlgorithm solution = new KosarajuAlgorithm();

        // 0 -> 1 -> 2 -> 0 forms one SCC, 3 and 4 are singletons: expected 3
        System.out.println(solution.countSCC(5, new int[][]{{0, 1}, {1, 2}, {2, 0}, {1, 3}, {3, 4}}));

        // No edges, every node is its own SCC: expected 3
        System.out.println(solution.countSCC(3, new int[][]{}));

        // Single cycle covering all nodes: expected 1
        System.out.println(solution.countSCC(4, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}}));
    }
}

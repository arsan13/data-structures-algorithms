package graph.tarjan.latest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an undirected graph with V vertices and E edges. The graph is represented as a 2D array edges[][], where each element edges[i] = [u, v] indicates an undirected edge between vertices u and v. Return all the articulation points (or cut vertices) in the graph. An articulation point is a vertex whose removal, along with all its connected edges, increases the number of connected components in the graph.

The given graph may be disconnected, i.e., it may consist of more than one connected component.
If no such point exists, return {-1}.
 */
public class ArticulationPoints {

    // Global discovery counter; each node gets the next value when first visited
    private int timer;

    /*
    Tarjan's articulation-point algorithm: a single DFS tracking two values per node.
      inTime[u]  - the time at which u was first discovered
      lowTime[u] - the earliest discovery time reachable from u's DFS subtree using
                   tree edges plus at most one back edge

    Same machinery as bridge finding, but the condition is about a NODE, not an edge.

    Non-root node u is an articulation point iff it has a DFS child v with lowTime[v] >= inTime[u],
    i.e. v's subtree cannot reach any ancestor of u without passing through u.
      lowTime[v] <  inTime[u] -> subtree has a route strictly above u -> u is NOT needed for it
      lowTime[v] >= inTime[u] -> subtree can at best loop back to u itself -> removing u cuts it off
    (Compare with bridges, which use strict '>': a loop back to u still leaves the edge u-v
    replaceable, but it does NOT save the vertex u, since u is the one being removed.)

    Root is special: it has no ancestors, so every child subtree trivially "can't reach above it".
    The root is an articulation point iff it has MORE THAN ONE DFS child, because in an undirected
    graph separate DFS children of the root are only connected to each other through the root.

    The parent is skipped in the DFS because the edge back to it is the very edge we came down.
    Parallel edges don't matter for cut vertices, so skipping the parent by value is safe.

    Example: edges 0-1, 1-2, 2-3, 3-1. DFS order 0 -> 1 -> 2 -> 3, so inTime = [0, 1, 2, 3].
      3 sees back edge to 1 -> lowTime[3] = 1, and lowTime[2] = 1 (inherited from 3)
      at node 2, child 3: lowTime[3]=1 >= inTime[2]=2 ? no  -> 2 is not an articulation point
      at node 1, child 2: lowTime[2]=1 >= inTime[1]=1 ? yes -> 1 is an articulation point
        (removing 1 disconnects 0 from {2, 3})
      node 0 is the root with a single child -> not an articulation point
    Answer: [1]

    Time: O(V + E), Space: O(V + E)
     */
    public List<Integer> articulationPoints(int n, int[][] edges) {
        List<List<Integer>> adjList = buildAdjacencyList(n, edges);

        int[] inTime = new int[n];
        int[] lowTime = new int[n];
        boolean[] isArticulationPoint = new boolean[n];

        // -1 marks "not visited yet", so no separate visited array is needed
        Arrays.fill(inTime, -1);
        timer = 0;

        // The graph may be disconnected, so start a fresh DFS from every unvisited node
        for (int i = 0; i < n; i++) {
            if (inTime[i] == -1) {
                dfs(i, -1, adjList, inTime, lowTime, isArticulationPoint);
            }
        }

        // A boolean array (rather than a list) avoids duplicates, since a node can qualify via several children
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isArticulationPoint[i]) {
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            result.add(-1);
        }

        return result;
    }

    private void dfs(int node, int parent, List<List<Integer>> adjList, int[] inTime, int[] lowTime, boolean[] isArticulationPoint) {
        inTime[node] = lowTime[node] = timer++;
        int children = 0;

        for (int neighbour : adjList.get(node)) {
            // Going back along the tree edge we came from says nothing about alternate paths
            if (neighbour == parent) {
                continue;
            }

            if (inTime[neighbour] != -1) {
                // Back edge to an already-visited node: node can reach it directly,
                // so node's low-link can drop to that node's discovery time
                lowTime[node] = Math.min(lowTime[node], inTime[neighbour]);
            } else {
                // Tree edge: explore the child, then inherit whatever it can reach
                dfs(neighbour, node, adjList, inTime, lowTime, isArticulationPoint);
                lowTime[node] = Math.min(lowTime[node], lowTime[neighbour]);

                // Child's subtree cannot get above node without node -> node is a cut vertex.
                // The root is handled separately below, as every root child satisfies this trivially.
                if (lowTime[neighbour] >= inTime[node] && parent != -1) {
                    isArticulationPoint[node] = true;
                }
                children++;
            }
        }

        // Root with 2+ DFS children: those subtrees are only linked through the root
        if (parent == -1 && children > 1) {
            isArticulationPoint[node] = true;
        }
    }

    private List<List<Integer>> buildAdjacencyList(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        return adjList;
    }
}

package graph.cycle;

import java.util.ArrayList;
import java.util.List;

/*
There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
* */
public class EventualSafeNodesDFS {

    // Slight modification of detect cycle in directed graph using dfs problem
    // Any node part of cycle or leading to the cycle are not safe nodes
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;

        boolean[] visited = new boolean[v];
        boolean[] visitedPath = new boolean[v];
        boolean[] safeNodes = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, visitedPath, safeNodes);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (safeNodes[i]) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean dfs(int src, int[][] graph, boolean[] visited, boolean[] visitedPath, boolean[] safeNodes) {
        visited[src] = true;
        visitedPath[src] = true;

        for (int neighbor : graph[src]) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, graph, visited, visitedPath, safeNodes)) {
                    return true;
                }
            } else if (visitedPath[neighbor]) {
                return true;
            }
        }

        safeNodes[src] = true;
        visitedPath[src] = false;
        return false;
    }
}

package graph.cycle;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleUndirectedUsingDFS {

    // If you visit a vertex that's already visited AND it's not your parent → cycle
    public boolean isCycle(int v, int[][] edges) {
        List<List<Integer>> adjList = getAdjList(v, edges);
        boolean[] visited = new boolean[v];

        // For loop because of connected components case
        for (int i = 0; i < v; i++) {
            if (!visited[i] && dfs(i, -1, adjList, visited)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfs(int src, int parent, List<List<Integer>> adjList, boolean[] visited) {
        visited[src] = true;

        for (int neighbor : adjList.get(src)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, src, adjList, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }

    private List<List<Integer>> getAdjList(int v, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] pair : edges) {
            adjList.get(pair[0]).add(pair[1]);
            adjList.get(pair[1]).add(pair[0]);
        }

        return adjList;
    }

    private record Pair(int child, int parent) {
    }
}

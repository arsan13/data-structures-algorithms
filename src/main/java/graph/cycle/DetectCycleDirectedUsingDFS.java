package graph.cycle;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDirectedUsingDFS {

    // If you visit a vertex that's already visited AND it's on same path → cycle
    public boolean isCycle(int v, int[][] edges) {
        List<List<Integer>> adjList = getAdjList(v, edges);

        boolean[] visited = new boolean[v];
        boolean[] visitedPath = new boolean[v];

        // For loop because of connected components case
        for (int i = 0; i < v; i++) {
            if (!visited[i] && dfs(i, adjList, visited, visitedPath)) {
                return true;
            }

        }

        return false;
    }

    private boolean dfs(int src, List<List<Integer>> adjList, boolean[] visited, boolean[] visitedPath) {
        visited[src] = true;
        visitedPath[src] = true;

        for (int neighbor : adjList.get(src)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adjList, visited, visitedPath)) {
                    return true;
                }
            } else if (visitedPath[neighbor]) {
                return true;
            }

        }

        visitedPath[src] = false;
        return false;
    }

    private List<List<Integer>> getAdjList(int v, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }

        return adjList;
    }
}

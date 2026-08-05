package graph.cycle;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDirectedUsingDFS2 {

    // If you visit a vertex that's already visited AND it's on same path → cycle
    public boolean isCycle(int v, int[][] edges) {
        List<List<Integer>> adjList = getAdjList(v, edges);

        int[] status = new int[v];

        // For loop because of connected components case
        for (int i = 0; i < v; i++) {
            if (status[i] == 0 && dfs(i, adjList, status)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfs(int src, List<List<Integer>> adjList, int[] status) {
        status[src] = 2;

        for (int neighbor : adjList.get(src)) {
            if (status[neighbor] == 1) {
                if (dfs(neighbor, adjList, status)) {
                    return true;
                }
            } else if (status[neighbor] == 2) {
                return true;
            }

        }

        status[src] = 1;
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

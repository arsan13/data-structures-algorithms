package graph.cycle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleUndirectedUsingBFS {

    // If you visit a vertex that's already visited AND it's not your parent → cycle
    public boolean isCycle(int v, int[][] edges) {
        List<List<Integer>> adjList = getAdjList(v, edges);
        boolean[] visited = new boolean[v];

        // For loop because of connected components case
        for (int i = 0; i < v; i++) {
            if (!visited[i] && bfs(i, adjList, visited)) {
                return true;
            }

        }

        return false;
    }

    private boolean bfs(int src, List<List<Integer>> adjList, boolean[] visited) {
        Queue<Pair> queue = new LinkedList<>();

        visited[src] = true;
        queue.offer(new Pair(src, -1));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int neighbor : adjList.get(pair.child)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new Pair(neighbor, pair.child));
                } else if (pair.parent != neighbor) {
                    return true;
                }
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

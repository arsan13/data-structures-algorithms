package graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = getAdjList(isConnected);

        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adjList, visited);
            }
        }

        return count;
    }

    private List<List<Integer>> getAdjList(int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList<>();
        int v = isConnected.length;

        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(j);
                }
            }
        }

        return adjList;
    }

    private void dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited);
            }
        }
    }
}

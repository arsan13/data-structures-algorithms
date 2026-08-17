package graph.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualSafeNodesBFS {

    public List<Integer> eventualSafeNodes(int v, int[][] edges) {
        List<List<Integer>> adjListRev = getAdjListRev(v, edges);

        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int j : adjListRev.get(i)) {
                inDegree[j]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adjListRev.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }

    private static List<List<Integer>> getAdjListRev(int v, int[][] edges) {
        List<List<Integer>> adjListRev = new ArrayList<>();

        // Create reverse graph
        for (int i = 0; i < v; i++) {
            adjListRev.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjListRev.get(edge[1]).add(edge[0]);
        }
        return adjListRev;
    }
}

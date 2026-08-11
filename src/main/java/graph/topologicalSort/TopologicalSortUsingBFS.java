package graph.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortUsingBFS {

    public static List<Integer> topologicalSort(List<ArrayList<Integer>> adj, int v) {

        // 1. Calculate indegree
        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int j : adj.get(i)) {
                indegree[j]++;
            }
        }

        // 2. Insert zero indegree nodes to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 3. Update indegree, push to queue if zero indegree and populate result
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int i : adj.get(node)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int n = 7;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());

        adj.get(0).add(1);
        adj.get(0).add(3);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(4).add(3);
        adj.get(4).add(5);
        adj.get(4).add(6);

        final List<Integer> list = topologicalSort(adj, n);
        System.out.println(list);
    }

}

package graph.topologicalSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortUsingDFS {

    private static void dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[src] = true;

        for (int neighbour : adj.get(src)) {
            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited, stack);
            }
        }

        stack.push(src);
    }

    public static List<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj, int n) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

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

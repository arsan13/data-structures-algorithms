package backtracking.latest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MColoring {

    public static void main(String[] args) {
        int v = 5;
        int m = 2;
        int[][] edges = {
                {0, 3},
                {1, 2},
                {1, 4},
                {2, 1},
                {3, 0},
                {3, 4},
                {4, 1},
                {4, 3},
        };

        System.out.println(graphColoring(v, edges, m));
    }

    static boolean graphColoring(int v, int[][] edges, int m) {
        List<Set<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new HashSet<>());
        }

        for (int[] it : edges) {
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }

        int[] color = new int[v];
        Arrays.fill(color, -1);

        return graphColoring(0, v, adj, m, color);
    }

    private static boolean graphColoring(int node, int v, List<Set<Integer>> adj, int m, int[] colors) {
        if (node == v) {
            return true;
        }

        for (int i = 0; i < m; i++) {
            if (isSafe(node, adj, colors, i)) {
                colors[node] = i;

                if (graphColoring(node + 1, v, adj, m, colors)) {
                    return true;
                }
                colors[node] = -1;
            }
        }

        return false;
    }

    private static boolean isSafe(int node, List<Set<Integer>> adj, int[] colors, int color) {
        for (int it : adj.get(node)) {
            if (color == colors[it]) {
                return false;
            }
        }
        return true;
    }
}

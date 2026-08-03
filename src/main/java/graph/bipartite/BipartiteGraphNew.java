package graph.bipartite;

import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphNew {

    public boolean isBipartite(int[][] graph) {
        Boolean[] color = new Boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            // if (color[i] == null && !bfs(i, graph, color)) {
            //     return false;
            // }
            if (color[i] == null && !dfsCheck(i, graph, color, true)) {
                return false;
            }
        }

        return true;
    }

    private boolean bfsCheck(int src, int[][] graph, Boolean[] color) {
        Queue<Integer> queue = new LinkedList<>();

        color[src] = true;
        queue.offer(src);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbour : graph[node]) {
                if (color[neighbour] == null) {
                    color[neighbour] = !color[node];
                    queue.offer(neighbour);
                } else if (color[neighbour].equals(color[node])) {
                    return false;
                }
            }
        }

        return true;
    }

    // Efficient
    private boolean dfsCheck(int src, int[][] graph, Boolean[] color, Boolean assignedColor) {
        color[src] = assignedColor;

        for (int neighbour : graph[src]) {
            if (color[neighbour] == null) {
                if (!dfsCheck(neighbour, graph, color, !assignedColor)) {
                    return false;
                }
            } else if (color[neighbour].equals(assignedColor)) {
                return false;
            }
        }

        return true;
    }
}

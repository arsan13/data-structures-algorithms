package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestDistance {

    public int[] shortestDistanceFromSrc(int src, int v, List<List<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[v];

        Arrays.fill(dist, Integer.MAX_VALUE);

        queue.add(src);
        dist[src] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbour : adjList.get(node)) {
                if (dist[node] + 1 < dist[neighbour]) {
                    dist[neighbour] = dist[node] + 1;
                    queue.add(neighbour);
                }
            }
        }

        for (int i = 0; i < v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}

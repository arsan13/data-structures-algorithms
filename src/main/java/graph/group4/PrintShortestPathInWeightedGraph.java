package graph.group4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrintShortestPathInWeightedGraph {

    public List<Integer> shortestPath(int src, int dest, List<List<Pair>> adjList) {
        int n = adjList.size();


        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        parent[src] = src;

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        pq.offer(new Pair(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            for (Pair neighbour : adjList.get(p.node)) {
                int distTo = dist[p.node] + neighbour.dist;
                if (distTo < dist[neighbour.node]) {
                    parent[neighbour.node] = p.node;
                    dist[neighbour.node] = distTo;
                    pq.offer(new Pair(neighbour.node, distTo));
                }
            }
        }

        if (parent[dest] == -1) {
            return List.of(-1);
        }

        List<Integer> res = new ArrayList<>();
        res.add(dest);

        while (parent[dest] != dest) {
            res.add(parent[dest]);
            dest = parent[dest];
        }

        Collections.reverse(res);
        return res;
    }

    private record Pair(int node, int dist) {
    }
}

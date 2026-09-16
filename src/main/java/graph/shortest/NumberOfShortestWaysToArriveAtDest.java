package graph.shortest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class NumberOfShortestWaysToArriveAtDest {

    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adjList.get(road[0]).add(new Pair(road[1], road[2]));
            adjList.get(road[1]).add(new Pair(road[0], road[2]));
        }

        int mod = (int) (1e9 + 7);

        Queue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.dist));
        long[] dist = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        pq.offer(new Pair(0, 0));
        dist[0] = 0;
        ways[0] = 1;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            for (Pair neighbor : adjList.get(p.node)) {
                long newDist = p.dist + neighbor.dist;

                if (newDist < dist[neighbor.node]) {
                    pq.offer(new Pair(neighbor.node, newDist));
                    dist[neighbor.node] = newDist;
                    ways[neighbor.node] = ways[p.node]; // Strictly shorter path found, discard old count
                } else if (newDist == dist[neighbor.node]) {
                    ways[neighbor.node] = (ways[neighbor.node] + ways[p.node]) % mod; // Another shortest path found, accumulate
                }
            }
        }

        return ways[n - 1] % mod;
    }

    private record Pair(int node, long dist) {}
}

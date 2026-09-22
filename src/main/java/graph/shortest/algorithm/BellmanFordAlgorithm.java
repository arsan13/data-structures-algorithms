package graph.shortest.algorithm;

import java.util.Arrays;

/*
Like Dijkstra, this finds the shortest path from a src node to all other nodes, but unlike Dijkstra,
it also works when edge weights are negative.
It can also detect a negative weight cycle.
It works only on directed graphs, so an undirected graph must first be converted into one
(each undirected edge becomes two directed edges).
 */
public class BellmanFordAlgorithm {

    /*
    Relax every edge (v - 1) times.
    Relaxing edge (from, to, wt) means: if dist[from] + wt < dist[to], update dist[to] = dist[from] + wt.
    (v - 1) rounds because the longest possible shortest path in a graph with v nodes (without a cycle) has
    at most (v - 1) edges, so that many rounds are enough for the shortest distances to propagate to every node.
    One extra (the vth) round is then run: if any edge can still be relaxed, a negative weight cycle exists
    and the distances are meaningless, so a single-element {-1} array is returned instead.
    Time: O(V * E), Space: O(V)
     */
    public int[] algo(int src, int v, int[][] edges) {
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < v - 1; i++) {
            relaxAll(dist, edges);
        }

        boolean hasNegativeCycle = relaxAll(dist, edges);
        return hasNegativeCycle ? new int[]{-1} : dist;
    }

    /*
    Only detects a negative weight cycle that is reachable from src (node 0 here) - a negative cycle
    in a disconnected part of the graph won't be found, since nothing ever relaxes an edge into it.
    Checks the value, not just the length, so a single-node graph (valid dist = {0}) isn't mistaken
    for the {-1} cycle sentinel.
     */
    public boolean hasCycle(int v, int[][] edges) {
        int[] dist = algo(0, v, edges);
        return dist.length == 1 && dist[0] == -1;
    }

    // Relaxes every edge once; returns true if any distance was updated.
    private boolean relaxAll(int[] dist, int[][] edges) {
        boolean updated = false;

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int w = edge[2];

            // from is unreached so far, so there's nothing to relax through it
            // (also avoids overflowing MAX_VALUE + w below)
            if (dist[from] == Integer.MAX_VALUE) {
                continue;
            }

            int newDist = dist[from] + w;
            if (newDist < dist[to]) {
                dist[to] = newDist;
                updated = true;
            }
        }

        return updated;
    }

    public static void main(String[] args) {
        BellmanFordAlgorithm algo = new BellmanFordAlgorithm();

        int[][] edges = {
                {0, 1, 4},
                {0, 2, 5},
                {1, 2, -3},
                {2, 3, 4}
        };
        System.out.println("Distances: " + Arrays.toString(algo.algo(0, 4, edges)));

        int[][] negativeCycleEdges = {
                {0, 1, 1},
                {1, 2, -1},
                {2, 0, -1}
        };
        System.out.println("Has negative cycle: " + algo.hasCycle(3, negativeCycleEdges));
    }
}

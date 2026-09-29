package graph.mst;

import graph.dsu.DisjointSet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalAlgorithm {

    /**
     * Computes the minimum total cost to connect all cities (vertices)
     * using Kruskal's algorithm.
     * <p>
     * Assumes:
     * - Vertices are labeled 0..v-1
     * - 'adj' has size v, where adj.get(u) contains neighbors of u
     * - For an undirected graph, adj[u] contains (v, cost) and adj[v] contains (u, cost)
     */
    public int connectCitiesWithMinimumCost(int v, List<List<Pair>> adj) {
        List<Edge> edges = new ArrayList<>();

        // O(V + E): build edge list from 0..v-1
        for (int u = 0; u < v; u++) {
            for (Pair p : adj.get(u)) {
                int w = p.node();
                int cost = p.cost();

                // If the graph is UNDIRECTED and stored symmetrically in adj,
                // avoid adding each edge twice by enforcing u < w.
                if (u < w) {
                    edges.add(new Edge(u, w, cost));
                }

                // If the graph is DIRECTED, you would skip the u < w check
                // and always add the edge:
                // edges.add(new Edge(u, w, cost));
            }
        }

        // O(E log E): sort edges by cost
        edges.sort(Comparator.comparingInt(e -> e.cost));

        int totalCost = 0;
        List<Edge> mstEdges = new ArrayList<>(); // With edges, MST can be reconstructed if a caller ever needs the actual tree, not just its cost.
        DisjointSet ds = new DisjointSet(v); // supports 0..v-1
        int edgesUsed = 0;

        // O(E * α(V)): process edges using DSU
        for (Edge e : edges) {
            int rootU = ds.findRoot(e.src);
            int rootV = ds.findRoot(e.dest);

            if (rootU != rootV) {
                totalCost += e.cost;
                ds.unionBySize(rootU, rootV);
                mstEdges.add(e);
                edgesUsed++;

                // For a connected graph, MST has exactly v - 1 edges
                if (edgesUsed == v - 1) {
                    break;
                }
            }
        }

        // If edgesUsed < v - 1, the graph was disconnected; you can optionally
        // detect that and return something special (like -1) if required.
        return totalCost;
    }

    private record Pair(int node, int cost) {
    }

    private record Edge(int src, int dest, int cost) {
    }
}

package graph.mst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// Grow a single tree GREEDILY from an arbitrary start node: at each step, add the
// cheapest edge that connects an already-visited node to an unvisited one. A min-heap
// keyed by edge cost always gives that cheapest edge next; stale entries for nodes
// already visited (added when they were the cheapest option at the time but later
// beaten by an even cheaper edge) are simply skipped when popped. Repeat until every
// node has joined the tree - the sum of the edges taken is the MST cost.
public class PrimAlgorithm {

    // Connect all cities with the minimum total cost
    // Time: O(E log E) - each edge can be pushed to the heap once and every push/pop is O(log E)
    // Space: O(V + E) - adjacency list plus the heap and visited array
    public int connectCitiesWithMinimumCost(int v, List<List<Pair>> adj) {
        boolean[] visited = new boolean[v];
        Queue<Tuple> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        // Tuple (not Pair) carries the parent node too, so the MST edges below
        // can be reconstructed if a caller ever needs the actual tree, not just its cost.
        List<Integer[]> edges = new ArrayList<>();

        int totalCost = 0;
        pq.offer(new Tuple(0, 0, -1));

        while (!pq.isEmpty()) {
            Tuple tuple = pq.poll();

            if (visited[tuple.node]) {
                continue;
            }

            visited[tuple.node] = true;
            totalCost += tuple.cost;
            edges.add(new Integer[]{tuple.parent, tuple.node});

            for (Pair neighbour : adj.get(tuple.node)) {
                if (!visited[neighbour.node]) {
                    pq.offer(new Tuple(neighbour.node, neighbour.cost, tuple.node));
                }
            }
        }

        return totalCost;
    }

    private record Pair(int node, int cost) {}
    private record Tuple(int node, int cost, int parent) {}

    public static void main(String[] args) {
        // Classic 5-city example (CLRS/GFG Prim's demo), expected MST cost = 16
        // via edges 0-1(2), 1-2(3), 0-3(6), 1-4(5).
        int v = 5;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 3, 6);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 1, 3, 8);
        addEdge(adj, 1, 4, 5);
        addEdge(adj, 2, 4, 7);
        addEdge(adj, 3, 4, 9);

        int totalCost = new PrimAlgorithm().connectCitiesWithMinimumCost(v, adj);
        System.out.println("Minimum cost to connect all cities: " + totalCost);
        System.out.println("Expected: 16, Passed: " + (totalCost == 16));
    }

    private static void addEdge(List<List<Pair>> adj, int u, int w, int cost) {
        adj.get(u).add(new Pair(w, cost));
        adj.get(w).add(new Pair(u, cost));
    }
}

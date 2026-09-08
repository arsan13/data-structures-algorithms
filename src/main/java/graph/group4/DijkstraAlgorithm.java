package graph.group4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * This algo doesn't work for negative weights, because traversal between two nodes will fall into infinite loop.
 * */
public class DijkstraAlgorithm {

    // Time: O(E logV). E - edges, V - nodes
    public int[] shortestPath(int src, List<List<Pair>> adj) {
        int n = adj.size();

        Queue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            for (Pair neighbor : adj.get(p.node)) {
                int distance = p.dist + neighbor.dist;
                if (distance < dist[neighbor.node]) {
                    dist[neighbor.node] = distance;
                    pq.offer(new Pair(neighbor.node, distance));
                }
            }
        }

        return dist;
    }

    private record Pair(int node, int dist) {
    }

    /*
    * Time complexity derivation:
    *The time complexity of **Dijkstra's Algorithm** using a **Priority Queue** is derived as $O(E log V)$, where $E$ is the number of edges and $V$ is the number of vertices. Here is the breakdown of the derivation (6:43-13:46):

    **1. The Primary Loop:**
    The main `while` loop processes vertices using a **greedy strategy**. In the worst-case scenario, this loop runs for each vertex, leading to $V$ iterations.

    **2. Priority Queue Operations:**
    Inside the loop, two main operations occur:
    * **Pop:** Removing the vertex with the minimal distance, which takes $O(log(Heap Size))$.
    * **Push:** Adding neighboring edges to the priority queue, which also takes $O(log(Heap Size))$.

    **3. Heap Size and Edge Count:**
    * In a **dense graph**, where each node can be connected to all other nodes, the priority queue may need to store up to $O(V^2)$ entries in the worst case.
    * Since the total number of edges $E$ in a dense graph is proportional to $V^2$, the complexity $O(V^2 log V)$ simplifies to $O(E log V)$.

    **Variables Mapping:**
    * $V$: Total number of vertices (nodes) in the graph.
    * $E$: Total number of edges in the graph.
    * Heap Size: The maximum number of elements stored in the priority queue at any given time.
    * */
}

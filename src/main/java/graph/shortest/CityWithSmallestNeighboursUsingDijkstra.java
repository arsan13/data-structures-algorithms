package graph.shortest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Runs Dijkstra from every node: O(n * E log n). For dense graphs (E ~ n^2, as this problem
allows), that's O(n^3 log n) - worse than the O(n^3) of CityWithSmallestNeighboursUsingFloydWarshall.
This approach only pays off when the graph is known to be sparse (E << n^2).
 */
public class CityWithSmallestNeighboursUsingDijkstra {

    public static void main(String[] args) {
        CityWithSmallestNeighboursUsingDijkstra solution = new CityWithSmallestNeighboursUsingDijkstra();
        int[][] edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        System.out.println(solution.findTheCity(4, edges, 4));
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> adjList = getAdjacencyList(n, edges);

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            dist[i] = dijkstra(i, n, adjList);
        }

        return findTheCity(n, distanceThreshold, dist);
    }

    private List<List<Pair>> getAdjacencyList(int n, int[][] edges) {
        List<List<Pair>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adjacencyList.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
        return adjacencyList;
    }

    private int[] dijkstra(int src, int n, List<List<Pair>> adjList) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::distance));
        pq.offer(new Pair(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            if (pair.distance > dist[pair.node]) {
                continue;
            }

            for (Pair neighbour : adjList.get(pair.node)) {
                int newDistance = dist[pair.node] + neighbour.distance;
                if (newDistance < dist[neighbour.node]) {
                    dist[neighbour.node] = newDistance;
                    pq.offer(new Pair(neighbour.node, newDistance));
                }
            }
        }

        return dist;
    }

    private int findTheCity(int n, int distanceThreshold, int[][] dist) {
        int minCount = n;
        int city = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                city = i;
            }
        }

        return city;
    }

    private record Pair(int node, int distance) {
    }
}

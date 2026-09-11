package graph.shortest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlight {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adjList.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        Queue<Pair> queue = new LinkedList<>();
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        queue.offer(new Pair(src, 0));
        cost[src] = 0;

        int stops = 0;
        while (!queue.isEmpty()) {
            if (stops > k) {
                break;
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();

                for (Pair neighbour : adjList.get(pair.node)) {
                    int newCost = pair.cost + neighbour.cost;
                    if (newCost < cost[neighbour.node]) {
                        queue.offer(new Pair(neighbour.node, newCost));
                        cost[neighbour.node] = newCost;
                    }
                }
            }

            stops++;
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

    private record Pair(int node, int cost) {}
}

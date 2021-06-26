package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestCostWithKStops {
	
	static class Edge implements Comparable<Edge> {
		int src, stops, cost;

		public Edge(int src, int stops, int cost) {
			this.src = src;
			this.stops = stops;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost; //min-heap
		}
	}
	
	private static int findCheapestPrice(int src, int dest, int[][] flights, int n, int k) {
		
		Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] f : flights) {
            if (!prices.containsKey(f[0])) prices.put(f[0], new HashMap<>());
            prices.get(f[0]).put(f[1], f[2]);
        }
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(src, 0, 0));
		
		while(!pq.isEmpty()) {
			
			Edge edge = pq.poll();
			int u = edge.src;
			int stops = edge.stops;
			int cost = edge.cost;
			
			if(u == dest)
				return edge.cost;
			
			if(stops > k)
				continue;
			
			//traverse
			Map<Integer, Integer> adj  = prices.getOrDefault(u, new HashMap<>());
            for (int a : adj.keySet()) {
                pq.add(new Edge(a, stops+1, cost + adj.get(a)));
            }
			
		}
		
		return -1;
	}

//	private static int findCheapestPrice(int src, int dest, int[][] flights, int n, int k) {
//
//		PriorityQueue<Edge> pq = new PriorityQueue<>();
//		pq.add(new Edge(src, 0, 0));
//
//		while (!pq.isEmpty()) {
//			Edge edge = pq.poll();
//
//			if (edge.src == dest)
//				return edge.cost;
//
//			if (edge.stops > k)
//				continue;
//
//			for (int i = 0; i < flights.length; i++) {
//				int u = flights[i][0];
//				int v = flights[i][1];
//				int cost = flights[i][2];
//
//				if (edge.src == u) {
//					pq.add(new Edge(v, edge.stops + 1, cost + edge.cost));
//				}
//			}
//		}
//
//		return -1;
//	}
	
	public static void main(String[] args) {
		
		int n = 3;
		int flights[][] = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}; 
		
		int src = 0;
		int dest = 2;
		int k = 1;
		
		int cost = findCheapestPrice(src, dest, flights, n, k);
		
		System.out.println(cost);
	}
}

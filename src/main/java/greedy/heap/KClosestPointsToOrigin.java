package greedy.heap;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

	private static class Pair {
		int x, y;
		int dist;

		public Pair(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	/* 
	 * Distance Formula: sqrt(sq(x2 - x1) sq(y2 - y1)) 
	 * Origin: x1 = 0, y1 = 0 => sqrt(sq(x2)+ sq(y2)). 
	 * We can neglect sqrt, since removing sqrt from all pair of points makes no difference. 
	 * Formula = sq(x) + sq(y).
	 */
	private static void kClosest(int[][] points, int k) {
		if(points.length < k)
			return;
		
		PriorityQueue<Pair> maxQueue = new PriorityQueue<>((a, b) -> b.dist - a.dist);
		for(int[] point : points) {
			int x = point[0];
			int y = point[1];
			int dist = (x * x) + (y * y);
			
			Pair p = new Pair(x, y, dist);
			maxQueue.add(p);
			
			if(maxQueue.size() > k) {
				maxQueue.poll();
			}
		}
		
		while(!maxQueue.isEmpty()) {
			Pair p = maxQueue.poll();
			System.out.printf("(%d, %d)\n", p.x, p.y);
		}
	}

	public static void main(String[] args) {

		int points[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		int k = 2;

		kClosest(points, k);
	}
}

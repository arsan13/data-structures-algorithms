package greedy;

import java.util.Arrays;
import java.util.Collections;

public class Knapsack {

	static class Pair implements Comparable<Pair> {
		
		int value, weight;
		double cost;
		
		public Pair(int value, int weight) {
			this.value = value;
			this.weight = weight;
			this.cost = (double)value / (double)weight;
		}

		@Override
		public int compareTo(Pair o) {	// decreasing order
//			return (int) (o.cost - this.cost);	// not working for some test cases
			if(this.cost < o.cost)
				return 1;
			if(this.cost > o.cost)
				return -1;
			return 0;
		}
	}
	
	private static int getMaxValue(int capacity, int[] values, int[] weights, int n) {
		
		int total = 0;
		Pair pair[] = new Pair[n];
		
		for(int i = 0; i < n; i++)
			pair[i] = new Pair(values[i], weights[i]);
		
		Arrays.sort(pair);
		
		for(int i = 0; i < n; i++) {
			Pair p = pair[i];
						
			if(capacity - p.weight >= 0) {
				total += p.value;
				capacity -= p.weight;
			}
			else {
//				double fraction= ((double)capacity / (double)p.weight);
//				total += fraction * p.value;
				total += capacity * p.cost;
				break;
			}
		}
		
		return total;
	}
	
	public static void main(String[] args) {
		
		int n = 3; 
		int capacity = 50;
		int values[] = {60,100,120};
		int weight[] = {10,20,30};
		
		System.out.println(getMaxValue(capacity, values, weight, n));
	}
}

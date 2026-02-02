package greedy;

import java.util.Arrays;

public class MaximumStocks {

	static class Pair implements Comparable<Pair> {
		int price;
		int stocks;
		
		public Pair(int price, int stocks) {
			this.price = price;
			this.stocks = stocks;
		}
		
		@Override
		public int compareTo(Pair o) {
			return this.price - o.price;
		}
	}
	
	private static int maxStocks(int[] arr, int k) {
		int res = 0;
		int n = arr.length;
		Pair[] pair = new Pair[n];
		
		for(int i = 0; i < n; i++)
			pair[i] = new Pair(arr[i], i+1);
		
		Arrays.sort(pair);
		
		for (int i = 0; i < n; i++) { 
			int price = pair[i].price;
			int stocks = pair[i].stocks;
			
			if(price*stocks <= k) {
				res += stocks;
				k -= price*stocks;
			}
			else {
				res += k/price;
				k -= price*(k/stocks);
				break;
			}
		}
					
		return res;
	}
	
	public static void main(String[] args) {

		int k = 45;
		int price[] = { 10, 7, 19 };
		
		System.out.println(maxStocks(price, k));
	}

}

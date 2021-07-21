package dp.group2;

//Repitation allowed i.e., weight can be picked any number of times
public class Kanapsack2 {

	private static int maxProfit(int n, int[] weight, int[] price, int capacity) {
		int[] dp = new int[capacity+1];
		
		for (int i = 0; i < dp.length; i++) {
			for(int j = 0; j < n; j++) {
				if(i >= weight[j]) {
					int remCapacity = i - weight[j];
					dp[i] = Math.max(dp[i], dp[remCapacity] + price[j]);
				}
			}			
		}
		
		return dp[capacity];
	}

	public static void main(String[] args) {

		int n = 5;
		int[] weight = { 2, 5, 1, 3, 4 };
		int[] price = { 15, 14, 10, 45, 30 };
		int capacity = 7;

		int ans = maxProfit(n, weight, price, capacity);
		System.out.println(ans);
	}
}

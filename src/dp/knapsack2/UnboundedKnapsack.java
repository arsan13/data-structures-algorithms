package dp.knapsack2;

//Repitation allowed i.e., any weight can be picked multiple times
//Same as Maximize profit after cutting the rod and selling into pieces. 
public class UnboundedKnapsack {
	
	// O(n*n) Space
	private static int maxProfit1(int n, int[] weight, int[] price, int capacity) {

		int[][] dp = new int[n + 1][capacity + 1];
		int rows = dp.length;
		int cols = dp[0].length;

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (weight[i - 1] <= j) {
					int include = price[i - 1] + dp[i][j - weight[i - 1]];
					int exclude = dp[i - 1][j];
					dp[i][j] = Math.max(include, exclude);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[rows - 1][cols - 1];
	}
	
	
	//O(n) Space
	private static int maxProfit2(int n, int[] weight, int[] price, int capacity) {
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

		int ans = maxProfit1(n, weight, price, capacity);
		System.out.println(ans);
		
		ans = maxProfit2(n, weight, price, capacity);
		System.out.println(ans);
	}
}

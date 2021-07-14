package backtracking.level2.coins;

// Duplication of coins is not allowed

public class CoinChangePermutation1 {
	
	private static void coinChange(int[] coins, int amt, boolean[] used, String ans) {
		
		if(amt < 0)
			return;
		
		if(amt == 0) {
			System.out.print(ans + " ");
			return;
		}
		
		for(int i = 0; i < coins.length; i++) {
			if(used[i] == false) {
				used[i] = true;
				coinChange(coins, amt - coins[i], used, ans+coins[i]);
				used[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		
		int amt = 12;
		int[] coins = {2, 3, 5, 7};
		coinChange(coins, amt, new boolean[coins.length], "");
	}
}

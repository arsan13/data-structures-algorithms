package backtracking.level2.coins;

// Duplication of coins is not allowed

public class CoinChange1 {

	private static void coinChange(int index, int[] coins, int totalAmt, String ans) {
		
		if(totalAmt < 0)	 // Removes unnecessary calls
			return;
		
		if(index == coins.length) {
			if(totalAmt == 0)
				System.out.print(ans + " ");
			return;
		}
		
		coinChange(index+1, coins, totalAmt - coins[index], ans + coins[index]);
		coinChange(index+1, coins, totalAmt - 0, ans + "");
	}

	public static void main(String[] args) {
		
		int amt = 12;
		int[] coins = {2, 3, 5, 7};
		
		coinChange(0, coins, amt, "");		
	}
}
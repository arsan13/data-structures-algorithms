package backtracking.level2.coins;

// Duplication of coins is allowed

public class CoinChangePermutation2 {

	private static void coinChange(int[] coins, int amt, String ans) {

		if (amt < 0)
			return;

		if (amt == 0) {
			System.out.print(ans + " ");
			return;
		}

		for (int i = 0; i < coins.length; i++) {
			coinChange(coins, amt - coins[i], ans + coins[i]);
		}
	}

	public static void main(String[] args) {

		int amt = 12;
		int[] coins = { 2, 3, 5, 7 };
		coinChange(coins, amt, "");
	}
}

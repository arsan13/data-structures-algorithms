package backtracking.level2.coins;

// Duplication of coins is allowed

public class CoinChange2 {

	private static void coinChange(int index, int[] coins, int totalAmt, String ans) {

		if (index == coins.length) {
			if (totalAmt == 0)
				System.out.print(ans + " ");
			return;
		}

		for (int i = 0; coins[index] * i <= totalAmt; i++) {
			String part = "";
			for (int j = 0; j < i; j++) {
				part += coins[index];
			}
			coinChange(index + 1, coins, totalAmt - coins[index] * i, ans + part);
		}
	}

	public static void main(String[] args) {

		int amt = 12;
		int[] coins = {2, 3, 5, 7};
		coinChange(0, coins, amt, "");
	}
}

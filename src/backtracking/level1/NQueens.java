package backtracking.level1;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public static List<List<String>> nQueens(int n) {

		List<List<String>> res = new ArrayList<>();
		int[][] chess = new int[n][n];

		nQueensUtil(0, chess, n, res);

		return res;
	}

	private static void nQueensUtil(int row, int[][] chess, int size, List<List<String>> res) {

		if (row == size) {
			
//			printMatrix(chess);
			
			List<String> list = new ArrayList<>();
			for (int i = 0; i < chess.length; i++) {
				String str = "";
				for (int j = 0; j < chess[0].length; j++) {
					if (chess[i][j] == 0)
						str += ".";
					else
						str += "Q";
				}
				list.add(str);
			}
			res.add(list);
			return;
		}

		for (int col = 0; col < size; col++) {
			if (isSafe(row, col, chess) == true) {
				chess[row][col] = 1;
				nQueensUtil(row + 1, chess, size, res);
				chess[row][col] = 0;
			}
		}
	}

	private static boolean isSafe(int row, int col, int[][] chess) {

		// Check upwards vertical column
		for (int i = row - 1, j = col; i >= 0; i--) {
			if (chess[i][j] == 1)
				return false;
		}

		// Check upwards left diagonals
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (chess[i][j] == 1)
				return false;
		}

		// Check upwards right diagonals
		for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
			if (chess[i][j] == 1)
				return false;
		}

		return true;
	}

	private static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int n = 4;
		List<List<String>> res = nQueens(n);
		System.out.println(res);

	}
}

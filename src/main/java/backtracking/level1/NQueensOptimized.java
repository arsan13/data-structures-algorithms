package backtracking.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensOptimized {

//	BRANCH AND BOUND

	public static void main(String[] args) {
		System.out.println(nQueens(4));

	}

	public static List<List<String>> nQueens(int n) {
		List<List<String>> res = new ArrayList<>();

		String[][] board = new String[n][n];
		for (String[] row : board) {
			Arrays.fill(row, ".");
		}

		nQueens(n, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], board, res);
		return res;
	}

	private static void nQueens(int n, int col, boolean[] leftRow, boolean[] lowerDiagonal, boolean[] upperDiagonal,  String[][] board, List<List<String>> res) {
		if(col == n) {
			List<String> list = new ArrayList<>();
			for (String[] row : board) {
				list.add(String.join("", row));
			}
			res.add(list);
			return;
		}

		for(int row = 0; row < n; row++) {
			if (!leftRow[row] && !lowerDiagonal[row + col] && !upperDiagonal[(n - 1) + (col - row)]) {
				board[row][col] = "Q";
				leftRow[row] = true;
				lowerDiagonal[row + col] = true;
				upperDiagonal[(n - 1) + (col - row)] = true;

				nQueens(n, col + 1, leftRow, lowerDiagonal, upperDiagonal, board, res);

				board[row][col] = ".";
				leftRow[row] = false;
				lowerDiagonal[row + col] = false;
				upperDiagonal[(n - 1) + (col - row)] = false;
			}
		}
	}
}

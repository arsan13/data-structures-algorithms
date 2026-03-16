package backtracking.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NQueens {

	public static void main(String[] args) {
		System.out.println(nQueens(4));

	}

	public static List<List<String>> nQueens(int n) {
		List<List<String>> res = new ArrayList<>();

		String[][] board = new String[n][n];
		for (String[] row : board) {
			Arrays.fill(row, ".");
		}

		nQueens(n, 0, board, res);
		return res;
	}

	private static void nQueens(int n, int col, String[][] board, List<List<String>> res) {
		if(col == n) {
			List<String> list = new ArrayList<>();
			for (String[] row : board) {
				list.add(String.join("", row));
			}
			res.add(list);
			return;
		}

		for(int row = 0; row < n; row++) {
			if (isSafe(board, row, col, n)) {
				board[row][col] = "Q";
				nQueens(n, col + 1, board, res);
				board[row][col] = ".";
			}
		}
	}

	private static boolean isSafe(String[][] board, int row, int col, int n) {
		// Upper diagonal
		int tempRow = row;
		int tempCol = col;
		while(tempRow >= 0 && tempCol >= 0) {
			if(Objects.equals(board[tempRow][tempCol], "Q")) {
				return false;
			}
			tempRow--;
			tempCol--;
		}

		// Left Row
		tempCol = col;
		while(tempCol >= 0) {
			if(Objects.equals(board[row][tempCol], "Q")) {
				return false;
			}
			tempCol--;
		}

		// Lower Diagonal
		tempRow = row;
		tempCol = col;
		while(tempRow < n && tempCol >= 0) {
			if(Objects.equals(board[tempRow][tempCol], "Q")) {
				return false;
			}
			tempRow++;
			tempCol--;
		}

		return true;
	}
}

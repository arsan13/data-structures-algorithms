package backtracking.level2.queens;

/*
 * Formula 
 * row = cell / chess.length ;
 * col = cell / chess.length ;
 * cell = row * chess.length + col ;
 */

public class NQueens {

	private static void nQueens(int qsf, int tq, boolean[][] chess, int cell) {

		if (qsf == tq) {
			printBoard(chess);
			return;
		}

		for (int i = cell + 1; i < chess.length * chess.length; i++) {
			int row = i / chess.length;
			int col = i % chess.length;

			if (chess[row][col] == false && isSafe(row, col, chess)) {
				chess[row][col] = true;
				nQueens(qsf + 1, tq, chess, row * chess.length + col);
				chess[row][col] = false;
			}
		}
	}

	private static boolean isSafe(int row, int col, boolean[][] chess) {

		// Check upwards vertical column
		for (int i = row - 1, j = col; i >= 0; i--) {
			if (chess[i][j] == true)
				return false;
		}

		// Check horizontal column
		for (int i = row, j = col; j >= 0; j--) {
			if (chess[i][j] == true)
				return false;
		}

		// Check upwards left diagonals
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (chess[i][j] == true)
				return false;
		}

		// Check upwards right diagonals
		for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
			if (chess[i][j] == true)
				return false;
		}

		return true;
	}

	private static void printBoard(boolean[][] chess) {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[0].length; j++) {
				System.out.print(chess[i][j] ? "q " : "-  ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {

		boolean[][] chess = new boolean[4][4];

		nQueens(0, 4, chess, -1);
	}
}

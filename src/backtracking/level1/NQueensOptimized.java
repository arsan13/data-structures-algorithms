package backtracking.level1;

public class NQueensOptimized {

//	BRANCH AND BOUND
	
	public static void nQueens(int n) {

		int[][] chess = new int[n][n];
		boolean[] cols = new boolean[n];
		boolean[] ndiag = new boolean[2 * n - 1]; //2*n-1 is total number of diagonals in n*n matrix
		boolean[] rdiag = new boolean[2 * n - 1];

		nQueensUtil(0, chess, cols, ndiag, rdiag);

	}

	private static void nQueensUtil(int row, int[][] chess, boolean[] cols, boolean[] ndiag, boolean[] rdiag) {

		if (row == chess.length) {
			printMatrix(chess);
			System.out.println("========");
			return;
		}

		for (int col = 0; col < chess.length; col++) {
			if (!cols[col] && !ndiag[row + col] && !rdiag[row - col + chess.length - 1]) {
				chess[row][col] = 1;
				cols[col] = true;
				ndiag[row + col] = true;
				rdiag[row - col + chess.length - 1] = true;
				nQueensUtil(row + 1, chess, cols, ndiag, rdiag);
				rdiag[row - col + chess.length - 1] = false;
				ndiag[row + col] = false;
				cols[col] = false;
				chess[row][col] = 0;
			}
		}
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
		nQueens(n);
	}
}

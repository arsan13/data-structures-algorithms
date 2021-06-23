package graph;

public class NQueens {

	private static void printNQueens(String qsf, int row, int[][] chess, int size) {
		
		if(row == size) {
			System.out.println(qsf);
			return;
		}
		
		for(int col = 0; col < size; col++) {
			if(isSafe(row, col, chess) == true) {
				chess[row][col] = 1;
				printNQueens(qsf + row + " " + col + ", ", row + 1, chess, size);
				chess[row][col] = 0;
			}
		}
	}
	
	private static boolean isSafe(int row, int col, int[][] chess) {
		
		// Check upwards vertical column
		for(int i = row-1, j = col; i >= 0; i--) {
			if(chess[i][j] == 1)
				return false;
		}
		
		// Check upwards left diagonals
		for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
			if(chess[i][j] == 1)
				return false;
		}
		
		// Check upwards right diagonals
		for(int i = row-1, j = col+1; i >= 0 && j < chess.length; i--, j++) {
			if(chess[i][j] == 1)
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		int n = 4;
		int chess[][] = new int[n][n];
		printNQueens("", 0, chess, n);
	}
}

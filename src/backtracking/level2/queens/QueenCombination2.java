package backtracking.level2.queens;

public class QueenCombination2 {

	private static void queenCombination(int qsf, int tq, boolean[][] chess, int row, int col) {

		if (qsf == tq) {
			printBoard(chess);
			return;
		}

		for (int j = col + 1; j < chess.length; j++) {
			chess[row][j] = true;
			queenCombination(qsf + 1, tq, chess, row, j);
			chess[row][j] = false;
		}

		for (int i = row + 1; i < chess.length; i++) {
			for (int j = 0; j < chess.length; j++) {
				chess[i][j] = true;
				queenCombination(qsf + 1, tq, chess, i, j);
				chess[i][j] = false;
			}
		}
	}

	private static void queenCombinationEfficient(int qsf, int tq, boolean[][] chess, int cell) {

		if (qsf == tq) {
			printBoard(chess);
			return;
		}

		/*
		 * Formula 
		 * row = cell / chess.length ;
		 * col = cell / chess.length ;
		 * cell = row * chess.length + col ;
		 */
		
		for (int i = cell + 1; i < chess.length * chess.length; i++) {
			int row = i / chess.length;  
			int col = i % chess.length;
			
			chess[row][col] = true;
			queenCombinationEfficient(qsf + 1, tq, chess, i);
			chess[row][col] = false;
		}
	}

	private static void printBoard(boolean[][] chess) {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[0].length; j++) {
				if (chess[i][j] == true)
					System.out.print("q  ");
				else
					System.out.print("-  ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {

		boolean[][] chess = new boolean[4][4];

//		queenCombination(0, 4, chess, 0, -1);
		queenCombinationEfficient(0, 4, chess, -1);
	}
}

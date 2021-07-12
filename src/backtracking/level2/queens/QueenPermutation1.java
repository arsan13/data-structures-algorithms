package backtracking.level2.queens;

public class QueenPermutation1 {

	private static void queenPermutation(int qsf, int tq, int[][] chess) {
		
		if(qsf== tq) {
			printBoard(chess);
			return;
		}
		
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[0].length; j++) {
				if(chess[i][j] == 0) {
					chess[i][j] = qsf + 1;
					queenPermutation(qsf+1, tq, chess);
					chess[i][j] = 0;
				}
			}	
		}
	}

	private static void printBoard(int[][] chess) {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[0].length; j++) {
				if(chess[i][j] == 0)
					System.out.print("-  ");
				else
					System.out.print("q" + chess[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {

		int[][] chess = new int[4][4];
		queenPermutation(0, 4, chess);
	}
}

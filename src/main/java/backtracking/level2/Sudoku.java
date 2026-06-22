package backtracking.level2;

public class Sudoku {

	private static boolean solve(int[][] board, int r, int c, int size) {

		if(r == size) {
			return true;
		}
		
		int nr = 0;
		int nc = 0;
		if (c == size - 1) {
			nr = r + 1;
			nc = 0;
		} else {
			nr = r;
			nc = c + 1;
		}
		
		if(board[r][c] != 0)
			return solve(board, nr, nc, size);
			
		for(int option = 1; option <= 9; option++) {
			if(isAllowed(board, r, c, size, option)) {
				board[r][c] = option;
				if(solve(board, nr, nc, size))
					return true;
				board[r][c] = 0;
			}
		}
		
		return false;
	}

	private static boolean isAllowed(int[][] board, int r, int c, int size, int option) {
		
		// check row
		for(int j = 0, i = r; j < size; j++) {
			if(board[i][j] == option)
				return false;
		}
		
		// check column
		for(int i = 0, j = c; i < size; i++) {
			if(board[i][j] == option)
				return false;
		}
		
		// check sub-matrix
		int smi = r / 3 * 3;
		int smj = c / 3 * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(board[smi + i][smj + j] == option)
					return false;
			}
		}
		
		return true;
	}

	private static void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {

		int[][] grid = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
						{ 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },
						{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
						{ 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
						{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },
						{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
						{ 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
						{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		boolean res = solve(grid, 0, 0, grid.length);
		
		if(res)
			printBoard(grid);
		else
			System.out.println("Not possible");
	}
}

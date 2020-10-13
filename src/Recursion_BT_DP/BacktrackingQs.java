package Recursion_BT_DP;

public class BacktrackingQs {

	public static void main(String[] args) {

		// int[][] maze = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
		// blockedMaze(maze, 0, 0, maze.length - 1, maze[0].length - 1, "", new boolean[4][4]);

		int[][] board = { { 0, 0, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };

		// sudokuSolver(board, 0, 0, board.length-1, board[0].length-1);

		NQueen(new boolean[5][5], 0, "");
	}

	public static void blockedMaze(int[][] maze, int cr, int cc, int er, int ec, String ans, boolean[][] visited) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return;
		}

		if (cr < 0 || cc < 0 || cr > er || cc > ec || maze[cr][cc] == 1 || visited[cr][cc]) {
			return;
		}

		visited[cr][cc] = true;

		blockedMaze(maze, cr - 1, cc, er, ec, ans + "T", visited);
		blockedMaze(maze, cr + 1, cc, er, ec, ans + "D", visited);
		blockedMaze(maze, cr, cc - 1, er, ec, ans + "L", visited);
		blockedMaze(maze, cr, cc + 1, er, ec, ans + "R", visited);

		visited[cr][cc] = false;
	}

	public static void sudokuSolver(int[][] board, int cr, int cc, int er, int ec) {

		if (cr > er) {
			display(board);
			return;
		}

		if (cc > ec) {
			sudokuSolver(board, cr + 1, 0, er, ec);
			return;
		}

		if (board[cr][cc] != 0) {
			sudokuSolver(board, cr, cc + 1, er, ec);
			return;
		}

		for (int i = 1; i <= 9; i++) {

			if (isItSafe(board, cr, cc, er, ec, i)) {

				board[cr][cc] = i;
				sudokuSolver(board, cr, cc + 1, er, ec);
				board[cr][cc] = 0;

			}
		}
	}

	private static boolean isItSafe(int[][] board, int cr, int cc, int er, int ec, int val) {

		// row
		for (int c = 0; c <= ec; c++) {
			if (board[cr][c] == val) {
				return false;
			}
		}

		// col
		for (int r = 0; r <= er; r++) {
			if (board[r][cc] == val) {
				return false;
			}
		}

		// 3*3 grid
		int sr = cr - cr % 3;
		int sc = cc - cc % 3;

		for (int r = sr; r < sr + 3; r++) {
			for (int c = sc; c < sc + 3; c++) {
				if (board[r][c] == val) {
					return false;
				}
			}
		}

		return true;
	}

	private static void display(int[][] board) {

		System.out.println("-----------------------");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");

	}

	public static void NQueen(boolean[][] board, int row, String ans) {

		if (row == board.length) {
			System.out.println(ans);
			return;
		}

		for (int col = 0; col < board[0].length; col++) {

			if (isItSafeQueen(board, row, col)) {
				board[row][col] = true;
				NQueen(board, row + 1, ans + "{" + row + "-" + col + "}");
				board[row][col] = false;
			}
		}

	}

	private static boolean isItSafeQueen(boolean[][] board, int row, int col) {

		// up
		int r = row;
		int c = col;

		while (r >= 0) {

			if (board[r][c]) {
				return false;
			}

			r--;
		}

		// d left
		r = row;
		c = col;

		while (r >= 0 && c >= 0) {
			if (board[r][c]) {
				return false;
			}

			r--;
			c--;
		}

		// d right
		r = row;
		c = col;

		while (r >= 0 && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}

			r--;
			c++;
		}

		return true;

	}
}

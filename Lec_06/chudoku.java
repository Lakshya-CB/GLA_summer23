package Lec_06;

import java.util.Scanner;

public class chudoku {
	static boolean found = false;
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		scn.next();
		char[][] board =new char[9][9];
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				board[i][j] = scn.next().charAt(0);
			}
		}
		
		solve(0, 0, board);
		print(board);
	}

	public static void print(char[][] board) {
		for (char[] row : board) {
			for (char ch : row) {
				System.out.print(ch + " ");
			}
			System.out.println();
		}
	}

	public static void solve(int r, int c, char[][] board) {

		if (c == 9) {
			c = 0;
			r++;
		}
		if (r == 9) {
//			
//			print(board);
			found = true;
//			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			return;
		}
		if (board[r][c] != '0') {
			solve(r, c + 1, board);
		} else {
			for (char ch = '1'; ch <= '9'; ch = (char) (ch + 1)) {
				if (isSafe(ch, r, c, board)) {
					board[r][c] = ch;
					solve(r, c + 1, board);
					if(found) {
						return;
					}
				}
			}
			board[r][c] = '0';
		}
	}

	private static boolean isSafe(char ch, int R, int C, char[][] board) {
		for (int r = 0; r < 9; r++) {
			if (board[r][C] == ch) {
				return false;
			}
		}

		for (int c = 0; c < 9; c++) {
			if (board[R][c] == ch) {
				return false;
			}
		}
		int box_r = R / 3;
		int box_c = C / 3;

		for (int r = box_r * 3; r < box_r * 3 + 3; r++) {
			for (int c = box_c * 3; c < box_c * 3 + 3; c++) {
				if (board[r][c] == ch) {
					return false;
				}
			}
		}
		return true;
	}
}

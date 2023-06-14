package Lec_06;

import java.util.Scanner;

public class rat_maze {
	static boolean ans = false;
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int R = scn.nextInt();
		int C = scn.nextInt();
		char[][] board = new char[R][C];
		for (int r = 0; r < R; r++) {
			board[r] = scn.next().toCharArray();
		}
		solve(0, 0, board);
		if(ans==false) {
			System.out.println("NO PATH FOUND");
		}

	}

	public static void print(char[][] board) {
		for (char[] row : board) {
			for (char ch : row) {
				if (ch != '1') {
					System.out.print(0 + " ");

				} else {
					System.out.print(ch + " ");
				}
			}
			System.out.println();
		}
	}

	public static void solve(int r, int c, char[][] board) {
//		left, right, up or down 
		if (r < 0 || c < 0 || r == board.length || c == board[0].length || board[r][c] == 'X' || board[r][c] == '1') {
			return;
		}
		board[r][c] = '1';
		if (r == board.length - 1 && c == board[0].length - 1) {
			ans = true;
			print(board);
			return;
		}
		
		solve(r, c - 1, board);
		solve(r, c + 1, board);
		solve(r - 1, c, board);
		solve(r + 1, c, board);
		board[r][c] = '0';
	}
}

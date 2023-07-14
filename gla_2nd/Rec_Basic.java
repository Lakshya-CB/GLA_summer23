package gla_2nd;

public class Rec_Basic {
	public static void main(String[] args) {
//		Comb_("abc", "", 2);
//		Comb_1d(0, 2, "", 4);
		Comb2D(0, 0, 2, "", 3, 3, new boolean[3][3]);
	}

	public static void Comb_(String Ques, String ans, int n) {
		if (ans.length() == n) {
			System.out.println(ans);
			return;
		}
		if (Ques.isEmpty()) {
			return;
		}
		String remain = Ques.substring(1);
		char ch = Ques.charAt(0);
		Comb_(remain, ans + ch, n);
		Comb_(remain, ans, n);

	}

	public static void Comb_1d(int col, int QTP, String path, int total_cols) {
		if (QTP == 0) {
			System.out.println(path);
			return;
		}
		if (col == total_cols) {
			return;
		}
		Comb_1d(col + 1, QTP - 1, path + "q" + col, total_cols);
		Comb_1d(col + 1, QTP, path, total_cols);
	}

	public static void print(boolean[][] board) {
		for (boolean[] row : board) {
			for (boolean p : row) {
				if (p) {
					System.out.print("_");
				} else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
		System.out.println("==============");
	}

	public static void Comb2D(int r, int c, int QTP, String path, int tots_r, int tots_c, boolean[][] board) {
		if (QTP == 0) {
			System.out.println(path);
			print(board);
			return;
		}
		if (c == tots_c) {
			c = 0;
			r++;
		}
		if (r == tots_r) {
			return;
		}
		if (isSafe(r, c, board)) {
			board[r][c] = true;
			Comb2D(r, c + 1, QTP - 1, path + "Q{" + r + "," + c + "}", tots_r, tots_c, board);
			board[r][c] = false;
		}
		Comb2D(r, c + 1, QTP, path, tots_r, tots_c, board);

	}

	public static boolean isSafe(int r, int c, boolean[][] board) {
		for(int row = r;row>=0;row--) {
			if(board[row][c]) {
				return false;
			}
		}
		for(int col = 0;col<c;col++) {
			if(board[r][col]) {
				return false;
			}
		}
		int r1 = r;
		int c1 = c;
		while(r1>=0 &&c1>=0) {
			if(board[r1][c1]) {
				return false;
			}
			r1--;
			c1--;
		}
		
		int r2 = r;
		int c2 = c;
		while(r2>=0 &&c2<board[0].length) {
			if(board[r2][c2]) {
				return false;
			}
			r2--;
			c2++;
		}
		return true;
	}

}

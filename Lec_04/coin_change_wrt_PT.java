package Lec_04;

import java.util.Arrays;

public class coin_change_wrt_PT {
	public static void main(String[] args) {
//		solve(2, -1, 4, "");
		int[] coins = { 1, 2, 2, 3, 1, 2, 3, 2, 1, 1, 1 };
		Arrays.sort(coins);
		coin(-1, 5, coins, "");
	}

	public static void solve(int r, int prev, int total_seats, String path) {
		if (r == 0) {
			System.out.println(path);
			return;
		}
//		 prev = 9 
//		curr = 10 to total
		for (int curr = prev + 1; curr < total_seats; curr++) {
//			curr = 11
			solve(r - 1, curr, total_seats, path + "b" + curr);
		}

	}

	public static void coin(int prev, int A, int[] coins, String path) {
		if (A == 0) {
			System.out.println(path);
			return;
		}
		if (A < 0) {
			return;
		}
//		prev = 2;
		for (int curr = prev + 1; curr < coins.length; curr++) {
			if (curr == prev + 1 || coins[curr] != coins[curr - 1]) {
				coin(curr, A - coins[curr], coins, path + coins[curr]);
			}
		}
	}
}

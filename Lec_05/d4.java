package Lec_05;

import java.util.Scanner;

public class d4 {
	static int count = 0;

	public static void print(int n, String ans) {
		if (ans.length() == n) {
			count++;
			return;
		}
		print(n, ans + "a");
		if (ans.length() == 0 || ans.charAt(ans.length() - 1) != 'b') {
			print(n, ans + "b");
		}
	}
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		for (int i = 1; i < tc + 1; i++) {
			int n = scan.nextInt();
			
			print(n, "");
			System.out.println("#" + i + " : " + count);
			count = 0;
		}
	}
}

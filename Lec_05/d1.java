package Lec_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d1 {
	static boolean ans = false;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int sz = sc.nextInt();
			int[] arr = new int[sz];
			for (int i = 0; i < sz; i++) {
				arr[i] = sc.nextInt();
			}
			ans = false;
			Subset(arr, 0, 0, "");
			if (ans == true) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}

	public static void Subset(int[] arr, int ind, int sum, String path) {
		if (ind == arr.length) {
			if (sum == 0 && path.length() > 0) {
				ans = true;
			}
			return;
		}
		Subset(arr, ind + 1, sum + arr[ind], path + arr[ind]);
		Subset(arr, ind + 1, sum, path);
	}
//	
}

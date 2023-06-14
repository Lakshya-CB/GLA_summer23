package Lec_05;

import java.util.Scanner;

public class d3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int sz = sc.nextInt();
		int[] arr = new int[sz];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		subarray(arr, 0, "", k, 0);
	}

	public static void subarray(int[] arr, int ind, String ans, int tar, int sum) {
		if (ind == arr.length) {
			if (sum == tar) {
				System.out.println(ans);
			}
//			System.out.println(ans);
			return;
		}
		subarray(arr, ind + 1, ans, tar, sum);
		subarray(arr, ind + 1, arr[ind] + " "+ans, tar, sum +arr[ind] );
	}
}

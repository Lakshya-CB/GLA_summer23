package Lec_06;

import java.util.ArrayList;

public class tower_of_henoiiii {
	static ArrayList<Integer> A;
	static ArrayList<Integer> B;
	static ArrayList<Integer> C;

	public static void main(String[] args) {
		A = new ArrayList<>();
		int n = 5;
		for (int disk = n; disk >= 1; disk--) {
			A.add(disk);
		}
		B = new ArrayList<>();
		C = new ArrayList<>();

		place(A.size(), A, C, B);
	}

	public static void place(int n, ArrayList<Integer> src, ArrayList<Integer> dest, ArrayList<Integer> helper) {
		if (n == 0) {
			return;
		}

		place(n - 1, src, helper, dest);
//		movement code!!
		int disk = src.remove(src.size() - 1);
		dest.add(disk);
		System.out.println(A + "\t  "+B+"\t "+C);
//		/////
		place(n - 1, helper, dest, src);
	}
}

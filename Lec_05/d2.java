package Lec_05;

import java.util.Scanner;

public class d2 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int testcases = scanner.nextInt();

		for (int t = 1; t <= testcases; t++) {
			int n = scanner.nextInt();
			if (n < 1)
				System.out.println("#" + t + " : " + 0);
			else
				System.out.println("#" + t + " : " + getAnswer(n));
		}
	}

	private static int getAnswer(int input) {
		if (input == 1)
			return 2;

		if (input == 2)
			return 3;

		int firstP = getAnswer(input - 1);
		int secondP = getAnswer(input - 2);

		int myWork = firstP + secondP;
		return myWork;
	}
}

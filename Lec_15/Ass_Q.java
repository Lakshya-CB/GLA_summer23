package Lec_15;

import java.util.HashSet;
import java.util.Set;

public class Ass_Q {
	public static void main(String[] args) {
		int[] arr = {1,2,3,2,3};
		System.out.println(sumOflength(arr, arr.length));
		
	}

	public static int sumOflength(int[] arr, int n) {
		Set s = new HashSet<>();

		int j = 0, ans = 0;
		for (int i = 0; i < n; i++) {
			while (j < n && !s.contains(arr[j])) {
				s.add(arr[j]);
				j++;
			}
			ans += ((j - i) * (j - i + 1)) / 2;
			s.remove(arr[i]);
		}
		return ans;
	}

}

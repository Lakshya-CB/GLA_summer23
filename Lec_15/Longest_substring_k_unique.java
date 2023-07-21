package Lec_15;

import java.util.HashMap;

public class Longest_substring_k_unique {
	public static void main(String[] args) {
		String str = "abcdbcdabcad";
		solve(str, 3);
	}
	public static void solve(String str, int k) {
		int s = 0;
		int e = 0;
		int score = 0;
		HashMap<Character, Integer> HM = new HashMap<>();
		while (true) {
			if (score <= k) {
				if(e==str.length()) {
					return;
				}
//				grow!!=> e wala char add karo!
				char ch = str.charAt(e);
				int prev_Freq = HM.getOrDefault(ch, 0);
				if (prev_Freq == 0) {
					score++;
				}
				HM.put(ch, prev_Freq + 1);
				e++;
			} else {
				if(s==str.length()) {
					return;
				}
//				score>k!! ,s char hein usse delete karo bhaiya!
				char ch = str.charAt(s);
				int prev_Freq = HM.getOrDefault(ch, 0);
				if (prev_Freq == 1) {
					score--;
				}
				HM.put(ch, prev_Freq - 1);
				s++;
			}
//			update!! subarray update!! s to e-1!!
			
			System.out.println(str.substring(s,e)+"-"+score);
		}
	}
}

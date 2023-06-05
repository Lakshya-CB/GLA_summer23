package Lec_Rec02;

public class Subseq {
	public static void main(String[] args) {
		subseq("abc", "");

	}

	public static void subseq(String loog, String team) {
		if(loog.isEmpty()) {
			System.out.println("^"+team);
			return;
		}
//		loog = "abc"
//		team = ""
		String remain = loog.substring(1);
		char chore = loog.charAt(0);
		subseq(remain, team+chore); // include
		subseq(remain, team); // exclude
		
	}
}

package Lec_Rec02;

import java.util.ArrayList;

public class partition {
	public static void main(String[] args) {
		kaat("abcd","", new ArrayList<>());
		
	}

	public static void kaat(String table, String bag,ArrayList<String> bag_AL) {
		if(table.isEmpty()) {
			System.out.println(bag);
			System.out.println(bag_AL);
			System.out.println("=============");
			
		}
//		table = "abcd";
//		bag = ""
		for (int chakku = 1; chakku <= table.length(); chakku++) {
			String piece= table.substring(0,chakku);
			String remain = table.substring(chakku);
//			System.out.println(piece+" - "+remain);
			bag_AL.add(piece);
			kaat(remain, bag+"-"+piece,bag_AL);
		}
	}
}
